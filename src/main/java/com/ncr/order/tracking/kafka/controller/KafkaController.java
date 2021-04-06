package com.ncr.order.tracking.kafka.controller;

import com.google.protobuf.Descriptors;
import lombok.AllArgsConstructor;

import com.ncr.order.tracking.kafka.producer.KafkaProducer;
import com.protobuf.generated.EmployeeProto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;



//    private final EmployeeProto.Employee employeeProto;

    @PostMapping("/publish")
    public void writeMessageToTopic(@RequestBody String message) throws Descriptors.DescriptorValidationException {
        kafkaProducer.writeLogMessage(message);
    }

//    @PostMapping(path = "/employee", consumes = "application/json", produces = "application/x-protobuf")
//    public void createEmployee(@RequestBody EmployeeProto.Employee employee){
//        kafkaProducer.writeMessageToTopic(employee);
//    }
//    @GetMapping(path = "/employee", produces = "application/x-protobuf")
//    public void getEmployee() {
//        kafkaProducer.writeMessageToTopic(employeeProto);
//    }
}
