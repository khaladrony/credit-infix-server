package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Bankers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankersRepository extends JpaRepository<Bankers, Long> {

    List<Bankers> findAllByCompanyInfoId(Long id);
}
