package com.purpletech.purplefashion.repository;

import com.purpletech.purplefashion.model.Contact;
import com.purpletech.purplefashion.rowMapper.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ContactRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ContactRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public int saveContactMsg(Contact contact) {
        String addNewContactMsg = "INSERT INTO contact_msg (NAME,EMAIL,SUBJECT,MESSAGE,STATUS," +
                "CREATED_AT,CREATED_BY) VALUES (:name,:email,:subject,:message,:status,:created_at,:created_by)";
        Map<String, Object> parameterValues = new HashMap<>();
        parameterValues.put("name", contact.getName());
        parameterValues.put("email", contact.getEmail());
        parameterValues.put("subject", contact.getSubject());
        parameterValues.put("message", contact.getMessage());
        parameterValues.put("status", contact.getStatus());
        parameterValues.put("created_at", contact.getCreatedAt());
        parameterValues.put("created_by", contact.getCreatedBy());
        SqlParameterSource namedParameters = new MapSqlParameterSource(parameterValues);
        return namedParameterJdbcTemplate.update(addNewContactMsg, parameterValues);
    }

    public List<Contact> getMsgsWithStatus(String status) {
        String sql = "SELECT * FROM CONTACT_MSG WHERE STATUS = :status";
        SqlParameterSource namedParameters = new MapSqlParameterSource("status", status);
        return namedParameterJdbcTemplate.query(sql, namedParameters, new ContactRowMapper());
    }

}
