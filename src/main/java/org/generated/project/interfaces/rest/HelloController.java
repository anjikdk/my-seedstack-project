package org.generated.project.interfaces.rest;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.generated.project.kafka.KafkaProducer;

@Path("kafkaHello")
public class HelloController {

	@GET
	@Path("test/{value}")
    public String someMethod(@PathParam("value") String value) throws InterruptedException, IOException
	{
		KafkaProducer kafkaProducer = new KafkaProducer();
		kafkaProducer.someMethod(value);
		
		return "Success";
	}
}
