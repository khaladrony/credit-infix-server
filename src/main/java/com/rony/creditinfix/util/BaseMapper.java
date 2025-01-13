package com.rony.creditinfix.util;

public interface BaseMapper <DTO, ENTITY> {

    DTO entityToDto(ENTITY var1);

    ENTITY dtoToEntity(DTO var1);
}
