package com.rony.creditinfix.services.financialInfo.orderDetail;

import com.rony.creditinfix.models.financialInfo.OrderDetailDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface OrderDetailService extends AbstractService<OrderDetailDTO> {

    public List<OrderDetailDTO> saveAll(List<OrderDetailDTO> orderDetailDTOS, Long companyInfoId);

    public List<OrderDetailDTO> findAllByCompanyInfoId(Long companyInfoId);
}
