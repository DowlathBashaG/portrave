package io.dowlath.consumemessges.handler;

import io.dowlath.consumemessges.event.EmployeeContactsCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@EnableKafka  //employee-contacts-created-events-topic
@KafkaListener(topics="employee-contacts-created-events-topic") //employee-contacts-created-events-topic
public class EmployeeContactsCreatedEventHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @KafkaHandler
    public void handle(EmployeeContactsCreatedEvent employeeContactsCreatedEvent){
        LOGGER.info("Received a new event  :"+employeeContactsCreatedEvent.getFirstName());
    }

}
