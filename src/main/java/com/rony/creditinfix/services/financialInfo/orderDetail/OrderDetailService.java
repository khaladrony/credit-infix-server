package com.rony.creditinfix.services.financialInfo.orderDetail;

import com.rony.creditinfix.models.financialInfo.OrderDetailDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface OrderDetailService extends AbstractService<OrderDetailDTO> {

    List<OrderDetailDTO> saveAll(List<OrderDetailDTO> orderDetailDTOS, Long companyInfoId);

    List<OrderDetailDTO> findAllByCompanyInfoId(Long companyInfoId);
}
