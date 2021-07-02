package org.generated.project.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.seedstack.kafka.ConsumerListener;
import org.seedstack.kafka.KafkaListener;
import org.seedstack.seed.Logging;
import org.slf4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;

@KafkaListener(value = "empConsumer", topics = "empTopic")
public class KafkaEmpConsumer implements ConsumerListener<String, JsonNode> {
    
	@Logging
    private Logger logger;
	
    @Override
    public void onConsumerRecord(ConsumerRecord<String, JsonNode> r) {
        logger.info("Received {}:{}", r.key(), r.value());
    }
 
    @Override
    public void onException(Exception e) throws Exception {
        // process any exception and re-throw an exception if reception must be temporary stopped 
    }
}
