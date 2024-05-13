package io.dowlath.consumemessges.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeContactsCreatedEvent {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
}
