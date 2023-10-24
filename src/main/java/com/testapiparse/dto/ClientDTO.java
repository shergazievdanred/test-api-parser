package com.testapiparse.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ClientDTO {
    private Long id;
    private String first_name;
    private String last_name;
    private String surname;
    private LocalDate date;
    private String contract_number;
    private String birth_country;
    private String location;
    private String passport_number;
}
