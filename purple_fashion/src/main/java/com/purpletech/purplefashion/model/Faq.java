package com.purpletech.purplefashion.model;

import lombok.Data;

@Data
public class Faq {

    private final String question;
    private final String answer;
    private final Type type;

    public enum Type {
        GENERAL, PRODUCT
    }
}
