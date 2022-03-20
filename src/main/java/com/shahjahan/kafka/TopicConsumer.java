package com.shahjahan.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class TopicConsumer {

    Consumer consumer;

    public TopicConsumer(Consumer consumer) {
        this.consumer = consumer;
    }


    public void consume() {
//        System.out.println(consum);

    }
}
