package com.testUnibell.testUnibell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactsResponseDto {

    private List<String> emailAddress;

    private List<String> phoneNumber;
}
