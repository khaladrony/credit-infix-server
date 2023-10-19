package com.rony.creditinfix.services.financialInfo.corporateStructure;

import com.rony.creditinfix.entity.financialInfo.CorporateStructure;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.CorporateStructureDTO;
import com.rony.creditinfix.models.financialInfo.ReportDataDTO;
import com.rony.creditinfix.repository.financialInfo.CorporateStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class CorporateStructureImpl implements CorporateStructureService {

    @Autowired
    CorporateStructureRepository corporateStructureRepository;


    @Override
    public List<CorporateStructureDTO> saveAll(List<CorporateStructureDTO> corporateStructureDTOS, Long companyInfoId) {
        List<CorporateStructure> corporateStructureList = new ArrayList<>();
        for (CorporateStructureDTO corporateStructureDTO : corporateStructureDTOS) {
            CorporateStructure corporateStructure = new CorporateStructure(corporateStructureDTO);
            corporateStructureList.add(corporateStructure);
        }
        corporateStructureRepository.saveAll(corporateStructureList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<CorporateStructureDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<CorporateStructureDTO> corporateStructureDTOS = new ArrayList<>();
        List<CorporateStructure> corporateStructureList = corporateStructureRepository.findAllByCompanyInfoId(companyInfoId);
        for (CorporateStructure corporateStructure : corporateStructureList) {
            CorporateStructureDTO corporateStructureDTO = new CorporateStructureDTO(corporateStructure);
            corporateStructureDTOS.add(corporateStructureDTO);
        }
        return corporateStructureDTOS;
    }

    @Override
    public List<List<ReportDataDTO>> findAllByCompanyInfoIdForReport(Long companyInfoId) {
        List<CorporateStructureDTO> corporateStructureDTOS = this.findAllByCompanyInfoId(companyInfoId);

        Map<Integer, List<CorporateStructureDTO>> dtoByItem = new HashMap<>();
        List<ReportDataDTO> rows = null;
        List<List<ReportDataDTO>> data = new ArrayList<>();

        dtoByItem = corporateStructureDTOS.stream()
                .collect(Collectors.groupingBy(CorporateStructureDTO::getSequence));

        for (List<CorporateStructureDTO> list : dtoByItem.values()) {
            boolean isFirstData = true;
            for (CorporateStructureDTO structureDTO : list) {
                if (isFirstData && list.size() > 1
                        && !structureDTO.getItemCode().equals("")
                        && !structureDTO.getItemValue().equals("")) {
                    rows = new ArrayList<>();
                    rows.add(new ReportDataDTO(list.size(), 0, structureDTO.getItemCode()));
                    rows.add(new ReportDataDTO(1, 0, structureDTO.getItemValue()));
                    data.add(rows);
                    isFirstData = false;
                } else if (!isFirstData && list.size() > 1) {
                    rows = new ArrayList<>();
                    rows.add(new ReportDataDTO(1, 0, structureDTO.getItemValue()));
                    data.add(rows);
                } else {
                    rows = new ArrayList<>();
                    rows.add(new ReportDataDTO(1, 0, structureDTO.getItemCode()));
                    rows.add(new ReportDataDTO(1, 0, structureDTO.getItemValue()));
                    data.add(rows);
                }

            }
        }


        return data;
    }

    @Override
    public CorporateStructureDTO create(CorporateStructureDTO corporateStructureDTO) throws ServiceException {
        return null;
    }

    @Override
    public CorporateStructureDTO update(Long id, CorporateStructureDTO corporateStructureDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public CorporateStructureDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<CorporateStructureDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<CorporateStructureDTO> findAll() {
        return null;
    }
}
