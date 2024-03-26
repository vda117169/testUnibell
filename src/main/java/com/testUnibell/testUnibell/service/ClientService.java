package com.testUnibell.testUnibell.service;

import com.testUnibell.testUnibell.dto.ContactsResponseDto;
import com.testUnibell.testUnibell.dto.EmailsResponseDto;
import com.testUnibell.testUnibell.dto.PhoneNumberResponseDto;
import com.testUnibell.testUnibell.entity.ClientInfo;
import com.testUnibell.testUnibell.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientInfo addClient(ClientInfo client) {
        return clientRepository.save(client);
    }

    public ClientInfo getClientById(Long clientId) {
        return (ClientInfo) clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));
    }

    public List<ClientInfo> getAllClients() {
        return clientRepository.findAll();
    }

    public ContactsResponseDto getContacts(Long clientId) {
        ClientInfo clientInfo = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));

        ContactsResponseDto dto = new ContactsResponseDto();
        dto.setEmailAddress(clientInfo.getEmailAddress());
        dto.setPhoneNumber(clientInfo.getPhoneNumber());

        return dto;

    }
    public EmailsResponseDto getEmails(Long clientId) {
        ClientInfo client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));

        EmailsResponseDto emailsResponseDto = new EmailsResponseDto();
        emailsResponseDto.setEmailAddress(client.getEmailAddress());

        return emailsResponseDto;
    }

    public PhoneNumberResponseDto getPhoneNumbers(Long clientId) {
        ClientInfo client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));

        PhoneNumberResponseDto phoneNumberResponseDto = new PhoneNumberResponseDto();
        phoneNumberResponseDto.setPhoneNumber(client.getPhoneNumber());

        return phoneNumberResponseDto;

    }
}
