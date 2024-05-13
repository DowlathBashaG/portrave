package io.dowlath.publishconsumemessges.service;

import io.dowlath.publishconsumemessges.entity.CreateEmployeeContactsModel;

public interface EmployeeContactsService {
    String createEmployeeContacts(CreateEmployeeContactsModel productRestModel) throws Exception;
}
