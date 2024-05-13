package io.dowlath.publishconsumemessges.service.impl;

import io.dowlath.publishconsumemessges.entity.CreateEmployeeContactsModel;
import io.dowlath.publishconsumemessges.event.EmployeeContactsCreatedEvent;
import io.dowlath.publishconsumemessges.service.EmployeeContactsService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeContactsServiceImpl implements EmployeeContactsService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    KafkaTemplate<String, EmployeeContactsCreatedEvent> kafkaTemplate;
    @Override
    public String createEmployeeContacts(CreateEmployeeContactsModel employeeContactsModel) throws Exception {

        String employeeId = UUID.randomUUID().toString();
        // TODO : Persist Employee details into database table before publishing an Event

        EmployeeContactsCreatedEvent employeeContactsCreatedEvent =
                        new EmployeeContactsCreatedEvent(employeeId,
                                employeeContactsModel.getFirstName(),
                                employeeContactsModel.getLastName(),
                                employeeContactsModel.getEmail());
        LOGGER.info("before publishing a employee contacts created event");
        SendResult<String, EmployeeContactsCreatedEvent> result = kafkaTemplate
                .send("employee-contacts-created-events-topic",
                       employeeId,employeeContactsCreatedEvent).get();
        LOGGER.info("Partition:  "+result.getRecordMetadata().partition());
        LOGGER.info("Topic:  "+result.getRecordMetadata().topic());
        LOGGER.info("Offset:  "+result.getRecordMetadata().offset());
        LOGGER.info("*********** Returning Product Id **************");
        return employeeId;

        /*
             synchronous call

             CompletableFuture<SendResult<String,EmployeeContactsCreatedEvent>> future =
             kafkaTemplate.send("employee-contacts-created-events-topic",employeeId,employeeContactsCreatedEvent);

             future.whenComplete((result,exception) -> {
             if(exception != null) {
                LOGGER.error("Failed to send message:  "+ exception.getMessage());
             }else{
                LOGGER.info("Message sent successfully:  :+result.getRecordMetadata());
             }
            });

         */


    }
}
