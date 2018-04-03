package com.elan.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.elan.dao.MySMSADDao;
import org.elan.entity.MySMSAD;
import org.elan.ws.exception.SMSADNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
// @TestPropertySource(locations= {"classpath:smsad.properties"})
@ContextConfiguration(locations = { "classpath:META-INF/application-contextTest-config.xml" })
public class JUnitMySMSADDaoImpl {

	@Autowired
	private MySMSADDao mySMSADDao;
	
	private MySMSAD smsad,smsad1,smsad2;
	private List<MySMSAD> smsadList;
	@Before
	public void setupData() {
		
		
				
		 smsad = new MySMSAD();
		smsad.setAdCode("a001");
		smsad.setAdUser("Malar");
		smsad.setAdDetails("Television AD");
		smsad.setAdCreatedDate("12/12/12");
		smsad.setAdUpdatedDate("2/2/18");
		
		smsad1 = new MySMSAD();
		smsad1.setAdCode("a002");
		smsad1.setAdUser("Dhivya");
		smsad1.setAdDetails("Mobile AD");
		smsad1.setAdCreatedDate("12/12/12");
		smsad1.setAdUpdatedDate("2/2/18");
		
		smsad2 = new MySMSAD();
		smsad2.setAdCode("a003");
		smsad2.setAdUser("Kamaraj");
		smsad2.setAdDetails("Mobile AD");
		smsad2.setAdCreatedDate("12/12/12");
		smsad2.setAdUpdatedDate("2/2/18");
		

		
	}

	@Test
	public void testCreateAD() {

		MySMSAD mysmsadReturn1 = mySMSADDao.createAd(smsad);
		 mySMSADDao.createAd(smsad1);
		mySMSADDao.createAd(smsad2);
		
		smsadList = mySMSADDao.ViewAll();
		
		System.out.println(mysmsadReturn1.getAdCode());
		System.out.println(mysmsadReturn1.getId());
		System.out.println(smsadList.get(0).getAdCode());
		System.out.println("Size : "+smsadList.size());

		Assert.assertEquals("a001",mysmsadReturn1.getAdCode());
		Assert.assertEquals("Malar",mysmsadReturn1.getAdUser());
		Assert.assertEquals("Television AD",mysmsadReturn1.getAdDetails());
		
		Assert.assertEquals(3, smsadList.size());

			}

	@Test
	public void testDeleteAD() throws SMSADNotFoundException  {
		
		String adcode = "a002";
		MySMSAD smsadResult = mySMSADDao.ViewByAdCode(adcode);
		 assertNotNull(smsadResult);
		MySMSAD smsadReturn = mySMSADDao.deleteAd(adcode);
		 smsadList = mySMSADDao.ViewAll();
		assertEquals(2, smsadList.size());
		//assertNull(smsadReturn);
		System.out.println("Size : "+smsadList.size());

	}
	@Test(expected=SMSADNotFoundException.class)
	public void testViewByADCode() throws SMSADNotFoundException {
		
		String adcode = "a003";
		MySMSAD smsadResult = mySMSADDao.ViewByAdCode(adcode);
		assertNotNull(smsadResult);
				
		 smsadList = mySMSADDao.ViewAll();
		Assert.assertEquals(2, smsadList.size());
		System.out.println("Size : "+smsadList.size());
		
		Assert.assertEquals("a003",smsadResult.getAdCode());
		Assert.assertEquals("Kamaraj",smsadResult.getAdUser());
		Assert.assertEquals("Mobile AD",smsadResult.getAdDetails());
	
		
	}
	@Test(expected=SMSADNotFoundException.class)
	public void testUpdateAD() throws SMSADNotFoundException {
		
		String adcode = "a001";
		MySMSAD smsadResult = mySMSADDao.ViewByAdCode(adcode);
		assertNotNull(smsadResult);
		
		smsadResult.setAdCode("a0012");
		smsadResult.setAdDetails("Electronic AD");
		smsadResult.setAdUser("Kamaraj");
			
		MySMSAD smsadReturn = mySMSADDao.updateAd(smsadResult);
		assertEquals("Electronic AD",smsadReturn.getAdDetails());
		assertEquals("Kamaraj",smsadReturn.getAdUser());
		assertEquals("a0012",smsadReturn.getAdCode());
		
	
	}
	@Test
	public void testViewAll ()
	{
		smsadList = mySMSADDao.ViewAll();
		Assert.assertEquals(3, smsadList.size());
	}
}
