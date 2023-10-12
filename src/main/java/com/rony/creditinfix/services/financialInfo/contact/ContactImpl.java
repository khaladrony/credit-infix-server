package com.rony.creditinfix.services.financialInfo.contact;

import com.rony.creditinfix.entity.financialInfo.Contact;
import com.rony.creditinfix.exception.NotFoundException;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.ContactDTO;
import com.rony.creditinfix.repository.financialInfo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public ContactDTO create(ContactDTO contactDTO) throws ServiceException {
        Contact contact = new Contact(contactDTO);

        return new ContactDTO(contactRepository.save(contact));
    }

    @Override
    public ContactDTO update(Long id, ContactDTO contactDTO) throws ServiceException {
        ContactDTO _contactDTO = this.findById(id);
        if (_contactDTO == null) throw new NotFoundException();


        Contact contact = new Contact(contactDTO);

        return new ContactDTO(contactRepository.save(contact));
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public ContactDTO findById(Long id) throws ServiceException {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.isPresent() ? new ContactDTO(contact.orElse(null)) : null;
    }

    @Override
    public Page<ContactDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<ContactDTO> findAll() {
        return null;
    }

    @Override
    public List<ContactDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<ContactDTO> contactDTOS = new ArrayList<>();
        List<Contact> contactList = contactRepository.findAllByCompanyInfoId(companyInfoId);
        for (Contact contact : contactList) {
            ContactDTO contactDTO = new ContactDTO(contact);
            contactDTOS.add(contactDTO);
        }
        return contactDTOS;
    }
}
