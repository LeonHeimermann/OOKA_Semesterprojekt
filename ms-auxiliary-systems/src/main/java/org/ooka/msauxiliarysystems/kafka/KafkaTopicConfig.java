package org.ooka.msauxiliarysystems.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String RESULT_AUXILIARY_SYSTEMS_TOPIC = "result-auxiliary-systems";

    @Bean
    public NewTopic createRequestEngineSystemsTopic() {
        return TopicBuilder.name(RESULT_AUXILIARY_SYSTEMS_TOPIC)
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "60000")
                .build();
    }

}

