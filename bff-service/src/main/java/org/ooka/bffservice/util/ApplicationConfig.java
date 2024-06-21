package org.ooka.bffservice.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class ApplicationConfig {

    @Value("${redis.host}")
    private String redisHost;
    @Value("${redis.port}")
    private int redisPort;

    @Bean
    public JedisPool createJedisPool() {
        return new JedisPool(new JedisPoolConfig(), redisHost, redisPort);
    }

}
