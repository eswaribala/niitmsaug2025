package com.niit.accountapi.services;

import com.google.gson.Gson;
import com.niit.accountapi.dtos.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "niitkafkadata", groupId = "saga-account-group")
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void getData(String json) {
        log.info("Consumer service received data: {}", json);

        CustomerDTO  customerDTO = new Gson().fromJson(json, CustomerDTO.class);
        log.info("CustomerDTO: {}", customerDTO);


    }
}
