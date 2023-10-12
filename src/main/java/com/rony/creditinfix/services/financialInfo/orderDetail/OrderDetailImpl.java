package com.rony.creditinfix.services.financialInfo.orderDetail;

import com.rony.creditinfix.entity.financialInfo.OrderDetail;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.OrderDetailDTO;
import com.rony.creditinfix.repository.financialInfo.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderDetailImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public List<OrderDetailDTO> saveAll(List<OrderDetailDTO> orderDetailDTOS, Long companyInfoId) {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (OrderDetailDTO orderDetailDTO : orderDetailDTOS) {
            OrderDetail orderDetail = new OrderDetail(orderDetailDTO);
            orderDetailList.add(orderDetail);
        }
        orderDetailRepository.saveAll(orderDetailList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<OrderDetailDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        List<OrderDetail> orderDetailList = orderDetailRepository.findAllByCompanyInfoId(companyInfoId);
        for (OrderDetail orderDetail : orderDetailList) {
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO(orderDetail);
            orderDetailDTOS.add(orderDetailDTO);
        }
        return orderDetailDTOS;
    }

    @Override
    public OrderDetailDTO create(OrderDetailDTO orderDetailDTO) throws ServiceException {
        return null;
    }

    @Override
    public OrderDetailDTO update(Long id, OrderDetailDTO orderDetailDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public OrderDetailDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<OrderDetailDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<OrderDetailDTO> findAll() {
        return null;
    }
}
