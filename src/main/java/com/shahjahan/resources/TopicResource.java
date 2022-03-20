package com.shahjahan.resources;

import com.shahjahan.kafka.TopicConsumer;
import com.shahjahan.kafka.TopicProducer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/produce")
@Produces(MediaType.APPLICATION_JSON)
public class TopicResource {
    final TopicProducer topicProducer;

    public TopicResource(TopicProducer topicProducer) {
        this.topicProducer = topicProducer;
    }

    @GET
    public String getTopic() {

        topicProducer.send();
        return "success";
    }

    @GET
    @Path("/consume")
    public String readTopic() {

        topicProducer.send();
        return "success";
    }
}
