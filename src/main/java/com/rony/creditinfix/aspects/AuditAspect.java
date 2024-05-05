package com.rony.creditinfix.aspects;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.util.SpringSecurityUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
public class AuditAspect {

    private static final Logger logger = LoggerFactory.getLogger(AuditAspect.class);

    @Autowired
    private SpringSecurityUtil springSecurityUtil;

    @Before("execution(* com.rony.creditinfix.repository.financialInfo.*Repository.save*(..)) && args(entity)")
    public void setLoggedInId(JoinPoint joinPoint, Object entity) {
        logger.info("Executing setLoggedInId advice method...");

        Long loggedInUserId = springSecurityUtil.getLoggedInUserId();
        try {
//            Use reflection to set the logged-in user's ID dynamically
            Field id = entity.getClass().getDeclaredField("id");
            id.setAccessible(true);
            Object idValue = id.get(entity);
            if (idValue == null) {
                setFieldRecursively(entity, "createdBy", loggedInUserId);
            } else {
                setFieldRecursively(entity, "updatedBy", loggedInUserId);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private void setFieldRecursively(Object entity, String fieldName, Object value) {
        Class<?> clazz = entity.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(entity, value);
                return; // Field found and set, exit the method
            } catch (NoSuchFieldException ignored) {
                // Field not found in this class, continue to superclass
            } catch (IllegalAccessException e) {
                logger.error("Error setting {} field in entity: {}", fieldName, e.getMessage());
                return; // Exit the method if IllegalAccessException occurs
            }
            clazz = clazz.getSuperclass(); // Move to the superclass
        }
        logger.warn("Field {} not found in class hierarchy for entity: {}", fieldName, entity.getClass().getName());
    }
}
