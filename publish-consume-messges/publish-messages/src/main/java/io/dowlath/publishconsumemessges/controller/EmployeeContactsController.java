package io.dowlath.publishconsumemessges.controller;

import io.dowlath.publishconsumemessges.entity.CreateEmployeeContactsModel;
import io.dowlath.publishconsumemessges.exception.ErrorMessage;
import io.dowlath.publishconsumemessges.service.EmployeeContactsService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/employees")  // http://localhost:<port>/employees
public class EmployeeContactsController {
    private EmployeeContactsService employeeContactsService;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public ResponseEntity<Object> createdProduct(@RequestBody CreateEmployeeContactsModel employee){
        String employeeId = null;
        try {
            employeeId = employeeContactsService.createEmployeeContacts(employee);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessage(new Date(),e.getMessage(),"/employees"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeId);
    }
}
