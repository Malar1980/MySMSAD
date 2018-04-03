package com.elan.test;

import org.easymock.EasyMock;
import org.elan.dao.MySMSADDao;
import org.elan.ws.service.api.MySMSADService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/config/ApplicationContext.xml" })
public class MySMSADServiceTest {

@Autowired
MySMSADService mySMSADService;
MySMSADDao dao = EasyMock.createMock(MySMSADDao.class);

@Test
public void testCreateADService()
{
	
	
}
}
