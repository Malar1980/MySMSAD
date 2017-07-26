package com.elan.test;

import org.elan.ws.MyService;
import org.elan.ws.SumRequest;
import org.elan.ws.SumResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/myservice-servletTest-config.xml"})
public class JUnitSpringExample {

	@Autowired
	private MyService myService;


	@Test
	public void testSampleServiceTest() {
		
		SumRequest sumRequest = new SumRequest();
		sumRequest.getAddend().add(10);
		sumRequest.getAddend().add(5);
		SumResponse sumResponse = myService.sum(sumRequest);
		Assert.assertEquals(15, sumResponse.getSum());

	}

	
}