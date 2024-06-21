package org.ooka.bffservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class NewTopicConfig {

    @Bean
    public NewTopic createRequestAuxiliarySystemsTopic() {
        return TopicBuilder.name("request-auxiliary-systems")
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "60000")
                .build();
    }

    @Bean
    public NewTopic createRequestControlSystemsTopic() {
        return TopicBuilder.name("request-control-systems")
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "60000")
                .build();
    }

    @Bean
    public NewTopic createRequestEngineSystemsTopic() {
        return TopicBuilder.name("request-engine-systems")
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "60000")
                .build();
    }

    @Bean
    public NewTopic createRequestMountingSystemsTopic() {
        return TopicBuilder.name("request-mounting-systems")
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "60000")
                .build();
    }

    @Bean
    public NewTopic createRequestPowerTransmissionTopic() {
        return TopicBuilder.name("request-power-transmission")
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "60000")
                .build();
    }

    @Bean
    public NewTopic createResultAnalyserTopic() {
        return TopicBuilder.name("result-analyser")
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "60000")
                .build();
    }

}
