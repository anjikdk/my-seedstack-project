package org.generated.project.kafka;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.PathParam;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducer {

	@Inject
    @Named("producer1")
    private Producer<String, String> producer;
    
    public void someMethod(String value) throws InterruptedException, IOException {
		String topicName = "someTopic";
        String key = "name";
       
        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);
        producer.send(record);
    }
}
