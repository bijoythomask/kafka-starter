package com.bthomask.kafka.basics;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaProducerDemo {

    public static void main(String[] args) {
        Properties properties = new Properties();

        //Kafka bootstrap server
        properties.setProperty("bootstrap.servers","192.168.1.55:9092");
        properties.put("client.id", "DemoProducer");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        //Producer Ack
        properties.setProperty("acks","1");
        properties.setProperty("retries","3");
        properties.setProperty("linger.ms","3");

        Producer producer = new KafkaProducer<String,String>(properties);

        ProducerRecord<String,String> producerRecord  = new ProducerRecord<>("test", "Test Message");

        try {
            producer.send(producerRecord).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
