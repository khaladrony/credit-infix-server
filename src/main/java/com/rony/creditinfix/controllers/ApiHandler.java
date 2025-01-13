package com.rony.creditinfix.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.rony.creditinfix.models.ApiResponse;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Component
public class ApiHandler {
    private final MessageSource messageSource;
    private final ObjectMapper mapper;

    public <T> ResponseEntity<Object> execute(Supplier<T> operation, String messageKey) {
        try {
            return ResponseEntity.ok(new ApiResponse(true,
                    messageSource.getMessage(messageKey, null, null),
                    operation.get()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, e.getMessage()));
        }
    }

    public <T> T parseDTO(String json, Class<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse DTO: " + e.getMessage(), e);
        }
    }
}
