package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    List<OrderDetail> findAllByCompanyInfoId(Long id);
}
