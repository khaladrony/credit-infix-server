package com.rony.creditinfix.services.financialInfo.shareholder;

import com.rony.creditinfix.entity.financialInfo.Shareholder;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.ShareholderDTO;
import com.rony.creditinfix.repository.financialInfo.ShareholderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShareholderImpl implements ShareholderService {

    @Autowired
    private ShareholderRepository shareholderRepository;


    @Override
    public List<ShareholderDTO> saveAll(List<ShareholderDTO> shareholderDTOS, Long companyInfoId) {
        List<Shareholder> shareholderList = new ArrayList<>();
        for (ShareholderDTO shareholderDTO : shareholderDTOS) {
            Shareholder shareholder = new Shareholder(shareholderDTO);
            shareholderList.add(shareholder);
        }
        shareholderRepository.saveAll(shareholderList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<ShareholderDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<ShareholderDTO> shareholderDTOS = new ArrayList<>();
        List<Shareholder> shareholderList = shareholderRepository.findAllByCompanyInfoId(companyInfoId);
        for (Shareholder shareholder : shareholderList) {
            ShareholderDTO shareholderDTO = new ShareholderDTO(shareholder);
            shareholderDTOS.add(shareholderDTO);
        }
        return shareholderDTOS;
    }

    @Override
    public ShareholderDTO create(ShareholderDTO shareholderDTO) throws ServiceException {
        return null;
    }

    @Override
    public ShareholderDTO update(Long id, ShareholderDTO shareholderDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public ShareholderDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<ShareholderDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<ShareholderDTO> findAll() {
        return null;
    }
}
