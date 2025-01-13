package com.rony.creditinfix.services.financialInfo.bankers;

import com.rony.creditinfix.entity.financialInfo.Bankers;
import com.rony.creditinfix.models.financialInfo.BankersDTO;
import com.rony.creditinfix.repository.financialInfo.BankersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BankersServiceImpl implements BankersService {

    @Autowired
    private BankersRepository bankersRepository;

    @Override
    public List<BankersDTO> saveAll(List<BankersDTO> bankersDTOS, Long companyInfoId) {
        List<Bankers> bankersList = new ArrayList<>();

        //Delete existing entries
        bankersRepository.deleteAllByCompanyInfoId(companyInfoId);

        for (BankersDTO bankersDTO : bankersDTOS) {
            Bankers bankers = new Bankers(bankersDTO);
            bankersList.add(bankers);
        }
        bankersRepository.saveAll(bankersList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<BankersDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<BankersDTO> bankersDTOS = new ArrayList<>();
        List<Bankers> bankersList = bankersRepository.findAllByCompanyInfoId(companyInfoId);
        for (Bankers bankers : bankersList) {
            BankersDTO bankersDTO = new BankersDTO(bankers);
            bankersDTOS.add(bankersDTO);
        }
        return bankersDTOS;
    }

    @Override
    public BankersDTO create(BankersDTO bankersDTO) {
        return null;
    }

    @Override
    public BankersDTO update(Long id, BankersDTO bankersDTO) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public BankersDTO findById(Long id) {
        return null;
    }

    @Override
    public Page<BankersDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<BankersDTO> findAll() {
        return null;
    }
}
