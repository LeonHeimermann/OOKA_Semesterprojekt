package org.ooka.bffservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String TASK_AUXILIARY_SYSTEMS_TOPIC = "task-auxiliary-systems";
    public static final String TASK_CONTROL_SYSTEMS_TOPIC = "task-control-systems";
    public static final String TASK_ENGINE_SYSTEMS_TOPIC = "task-engine-systems";
    public static final String TASK_MOUNTING_SYSTEMS_TOPIC = "task-mounting-systems";
    public static final String TASK_POWER_TRANSMISSION_TOPIC = "task-power-transmission";

    @Bean
    public NewTopic createAuxiliarySystemsTopic() {
        return TopicBuilder.name(TASK_AUXILIARY_SYSTEMS_TOPIC)
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "60000")
                .build();
    }

    @Bean
    public NewTopic createControlSystemsTopic() {
        return TopicBuilder.name(TASK_CONTROL_SYSTEMS_TOPIC)
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "60000")
                .build();
    }

    @Bean
    public NewTopic createEngineSystemsTopic() {
        return TopicBuilder.name(TASK_ENGINE_SYSTEMS_TOPIC)
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "60000")
                .build();
    }

    @Bean
    public NewTopic createMountingSystemTopic() {
        return TopicBuilder.name(TASK_MOUNTING_SYSTEMS_TOPIC)
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "60000")
                .build();
    }

    @Bean
    public NewTopic createPowerTransmissionTopic() {
        return TopicBuilder.name(TASK_POWER_TRANSMISSION_TOPIC)
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "60000")
                .build();
    }

}

