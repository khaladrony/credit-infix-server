package com.rony.creditinfix.services.storedProcedure;

import com.rony.creditinfix.security.SpringSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StoredProcedureExecuteServiceImpl implements StoredProcedureExecuteService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    SpringSecurityUtil springSecurityUtil;

    @Override
    public String execute(String templateName, Long companyInfoId) {
//        Long createdBy = springSecurityUtil.getLoggedInUserId();
        Long createdBy = 1L;

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("insert_template_data");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("templateName", templateName)
                .addValue("companyInfoId", companyInfoId)
                .addValue("createdBy", createdBy);

        Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);

        System.out.println(simpleJdbcCallResult);

        return "";
    }
}
