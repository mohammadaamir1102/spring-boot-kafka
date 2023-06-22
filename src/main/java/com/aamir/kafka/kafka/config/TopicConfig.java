package com.aamir.kafka.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TopicConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    public String bootstrapServers;

    @Value("${service.topic.codeWithAamirTopic}")
    public String codeWithAamir;

    @Value("${kafka.consumer.concurrency.med}")
    public Integer mediumPartition;

    @Value("${kafka.consumer.concurrency.replication-factor}")
    public short replicationFactors;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> kafkaConfigs = new HashMap<>();
        kafkaConfigs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(kafkaConfigs);
    }

    @Bean
    public NewTopic codeWithAamir(){
        return new NewTopic(codeWithAamir,mediumPartition, replicationFactors);
    }


}
