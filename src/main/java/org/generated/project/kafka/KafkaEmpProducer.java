package org.generated.project.kafka;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.generated.project.domain.Employee;
import org.seedstack.seed.Bind;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Bind
public class KafkaEmpProducer {

	@Inject
    @Named("empProducer")
    private Producer<String, JsonNode> producer;
	
	private ObjectMapper mapper = new ObjectMapper();
	
    public void empProduce(Employee emp) throws InterruptedException, IOException {
		
		String topicName = "empTopic";
        String key = "employeeDetails";
      
        JsonNode jsonNode = mapper.valueToTree(emp);
       
        ProducerRecord<String, JsonNode> producerRecord = new ProducerRecord<>(topicName, key, jsonNode);
        producer.send(producerRecord);
    }
}
