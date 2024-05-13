package io.dowlath.publishconsumemessges.controller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@RestController
//@AllArgsConstructor
public class FilterController {

 /*   private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/filter")
    public String filterAndPublish(@RequestParam String data) {
        // Example regular expression filtering
        Pattern pattern = Pattern.compile("\\b\\w{5}\\b");
        Matcher matcher = pattern.matcher(data);

        while (matcher.find()) {
            String filteredWord = matcher.group();
            // Publish filtered data to Kafka
            kafkaTemplate.send(new ProducerRecord<>("filtered_data_topic", filteredWord));
        }

        return "Data filtered and published to Kafka.";
    }*/
}

