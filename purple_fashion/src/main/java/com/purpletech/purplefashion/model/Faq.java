package com.purpletech.purplefashion.model;

import lombok.Data;

@Data
public class Faq extends BaseEntity {

    private String question;
    private String answer;
    private Type type;

    public enum Type {
        GENERAL, PRODUCT
    }
}
