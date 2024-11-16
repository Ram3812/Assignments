package com.purpletech.purplefashion.repository;

import com.purpletech.purplefashion.model.Faq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FaqRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FaqRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Faq> retrieveFaqs() {
        String fetchFaqs = "SELECT * FROM faqs";
        var rowMapper = BeanPropertyRowMapper.newInstance(Faq.class);
        return jdbcTemplate.query(fetchFaqs, rowMapper);
    }
}
