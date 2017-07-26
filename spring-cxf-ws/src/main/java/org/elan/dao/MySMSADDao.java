package org.elan.dao;

import java.util.List;

import org.elan.entity.MySMSAD;
import org.elan.ws.exception.SMSADNotFoundException;
import org.elan.ws.service.to.SMSADDetailRequest;
import org.elan.ws.service.to.SMSADList;

public interface MySMSADDao {

	

	public MySMSAD deleteAd(String adCode) throws SMSADNotFoundException;

	public MySMSAD updateAd(MySMSAD mySmsAD) throws SMSADNotFoundException;

	public MySMSAD ViewByAdCode(String adCode) throws SMSADNotFoundException;

	public List<MySMSAD> ViewAll();

	public MySMSAD createAd(MySMSAD mySmsAD);

}
