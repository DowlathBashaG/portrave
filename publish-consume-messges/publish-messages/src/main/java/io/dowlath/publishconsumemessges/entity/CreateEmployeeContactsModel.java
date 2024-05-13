package io.dowlath.publishconsumemessges.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeContactsModel {
    private String firstName;
    private String lastName;
    private String email;
}