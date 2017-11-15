package com.bthomask.kafka.basics;

import com.bthomask.kafka.basics.Consumer;
import com.bthomask.kafka.basics.KafkaProperties;
import com.bthomask.kafka.basics.Producer;

public class KafkaConsumerProducerDemo {
    public static void main(String[] args) {
        boolean isAsync = args.length == 0 || !args[0].trim().equalsIgnoreCase("sync");
        Producer producerThread = new Producer(KafkaProperties.TOPIC, isAsync);
        producerThread.start();

        Consumer consumerThread = new Consumer(KafkaProperties.TOPIC);
        consumerThread.start();

    }
}