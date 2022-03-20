package com.shahjahan;

import com.shahjahan.kafka.TopicProducer;
import com.shahjahan.resources.HelloWorldResource;
import com.shahjahan.resources.TopicResource;
import com.shahjahan.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.kafka.KafkaConsumerBundle;
import io.dropwizard.kafka.KafkaConsumerFactory;
import io.dropwizard.kafka.KafkaProducerBundle;
import io.dropwizard.kafka.KafkaProducerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.common.TopicPartition;
import org.jdbi.v3.core.Jdbi;

import java.util.Collection;
import java.util.Collections;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {



    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "HelloWorld";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(kafkaProducer);

    }
    ConsumerRebalanceListener consumerRebalanceListener = new ConsumerRebalanceListener() {
        @Override
        public void onPartitionsRevoked(Collection<TopicPartition> collection) {

        }

        @Override
        public void onPartitionsAssigned(Collection<TopicPartition> collection) {

        }
    };
    private final KafkaProducerBundle<String, String, HelloWorldConfiguration> kafkaProducer = new KafkaProducerBundle<String, String, HelloWorldConfiguration>(Collections.singletonList("shahjahan")) {
        @Override
        public KafkaProducerFactory<String, String> getKafkaProducerFactory(HelloWorldConfiguration configuration) {
            return configuration.getKafkaProducerFactory();
        }
    };

    private final KafkaConsumerBundle<String, String, HelloWorldConfiguration> kafkaConsumer = new KafkaConsumerBundle<String, String, HelloWorldConfiguration>(Collections.singletonList("shahjahan"), consumerRebalanceListener) {
        @Override
        public KafkaConsumerFactory<String, String> getKafkaConsumerFactory(HelloWorldConfiguration configuration) {
            return configuration.getKafkaConsumerFactory();
        }
    };

    @Override
    public void run(final HelloWorldConfiguration configuration,
                    final Environment environment) {




        // TODO: implement application
        final HelloWorldResource resources = new HelloWorldResource();
        environment.jersey().register(resources);

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(),"MYSQL");
        environment.jersey().register(new UserResource(jdbi));

        final TopicProducer topicProducer = new TopicProducer(kafkaProducer.getProducer());
        environment.jersey().register(new TopicResource(topicProducer));

    }

}
