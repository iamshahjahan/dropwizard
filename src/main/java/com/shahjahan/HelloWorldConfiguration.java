package com.shahjahan;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.kafka.KafkaConsumerFactory;
import io.dropwizard.kafka.KafkaProducerFactory;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class HelloWorldConfiguration extends Configuration {
    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    public KafkaProducerFactory<String, String> getKafkaProducerFactory() {
        return kafkaProducerFactory;
    }

    public void setKafkaProducerFactory(KafkaProducerFactory<String, String> kafkaProducerFactory) {
        this.kafkaProducerFactory = kafkaProducerFactory;
    }

    @Valid
    @NotNull
    @JsonProperty("producer")
    private KafkaProducerFactory<String, String> kafkaProducerFactory;


    public KafkaConsumerFactory<String, String> getKafkaConsumerFactory() {
        return kafkaConsumerFactory;
    }

    public void setKafkaConsumerFactory(KafkaConsumerFactory<String, String> kafkaConsumerFactory) {
        this.kafkaConsumerFactory = kafkaConsumerFactory;
    }

    @Valid
    @NotNull
    @JsonProperty("consumer")
    private KafkaConsumerFactory<String, String> kafkaConsumerFactory;


    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory) {
        this.database = factory;
    }

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
