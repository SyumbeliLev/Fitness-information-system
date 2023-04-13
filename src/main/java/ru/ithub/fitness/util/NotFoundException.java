package ru.ithub.fitness.util;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final Object entity;
    private final Variable variable;
    private final String data;

    public NotFoundException(Object entity, Variable variable, String data) {
        this.entity = entity;
        this.variable = variable;
        this.data = data;
    }

    public enum Variable {
        ID,
        EMAIL,
        PHONE
    }
}

