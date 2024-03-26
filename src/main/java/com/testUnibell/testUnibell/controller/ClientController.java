package com.testUnibell.testUnibell.controller;

import com.testUnibell.testUnibell.dto.ContactsResponseDto;
import com.testUnibell.testUnibell.dto.EmailsResponseDto;
import com.testUnibell.testUnibell.dto.PhoneNumberResponseDto;
import com.testUnibell.testUnibell.entity.ClientInfo;
import com.testUnibell.testUnibell.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public ResponseEntity<ClientInfo> addClient(@RequestBody ClientInfo client) {
        return ResponseEntity.ok(clientService.addClient(client));
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientInfo>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{clientId}/contacts")
    public ResponseEntity<ContactsResponseDto> getContactsById(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.getContacts(clientId));
    }

    @GetMapping("/{clientId}/emails")
    public ResponseEntity<EmailsResponseDto> getEmailsById(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.getEmails(clientId));
    }

    @GetMapping("/{clientId}/phoneNumbers")
    public ResponseEntity<PhoneNumberResponseDto> getPhoneNumbersById(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.getPhoneNumbers(clientId));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientInfo> getClientById(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.getClientById(clientId));
    }

}
