package org.elan.ws.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.elan.dao.MySMSADDao;
import org.elan.entity.MySMSAD;
import org.elan.ws.exception.SMSADNotFoundException;
import org.elan.ws.service.api.MySMSADService;
import org.elan.ws.service.to.SMSADDetailRequest;
import org.elan.ws.service.to.SMSADDetailResponse;
import org.elan.ws.service.to.SMSADList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("mySMSADService")
public class MySMSADServiceImpl implements MySMSADService {

	@Autowired
	private MySMSADDao dao;

	public MySMSADDao getDao() {
		return dao;
	}

	public void setDao(MySMSADDao dao) {
		this.dao = dao;
	}
	@Transactional
	@Override
	public SMSADDetailResponse createADService(SMSADDetailRequest smsAdDetailRequest) {

		SMSADDetailResponse smsAddetailResponse = new SMSADDetailResponse();
		MySMSAD mySmsAd = new MySMSAD();
		mySmsAd.setAdCode(smsAdDetailRequest.getAdCode());
		mySmsAd.setAdCreatedDate(smsAdDetailRequest.getAdCreatedDate());
		mySmsAd.setAdUpdatedDate(smsAdDetailRequest.getAdUpdatedDate());
		mySmsAd.setAdUser(smsAdDetailRequest.getAdUser());
		mySmsAd.setAdDetails(smsAdDetailRequest.getAdDetails());
		MySMSAD mySmsAdResponse = new MySMSAD();
		mySmsAdResponse = dao.createAd(mySmsAd);
		smsAddetailResponse.setAdCode(mySmsAdResponse.getAdCode());
		smsAddetailResponse.setId(mySmsAdResponse.getId());
		smsAddetailResponse.setMessage("Successfully Added");
		return smsAddetailResponse;
	}
	@Transactional
	@Override
	public SMSADDetailResponse deleteADService(String adCode) throws SMSADNotFoundException {

		SMSADDetailResponse smsAddetailResponse = new SMSADDetailResponse();
		MySMSAD mySmsAd = new MySMSAD();
		mySmsAd = dao.deleteAd(adCode);
		smsAddetailResponse.setAdCode(mySmsAd.getAdCode());
		smsAddetailResponse.setId(mySmsAd.getId());
		smsAddetailResponse.setMessage("Successfully Deleted");
		return smsAddetailResponse;
	}
	@Transactional
	@Override
	public SMSADDetailResponse updateADService(SMSADDetailRequest smsAdDetailRequest) throws SMSADNotFoundException {

		MySMSAD mySmsAd = new MySMSAD();
		mySmsAd.setAdDetails(smsAdDetailRequest.getAdDetails());
		MySMSAD mySmsADReturn = dao.updateAd(mySmsAd);
		mySmsADReturn.setAdDetails(mySmsADReturn.getAdDetails());
		SMSADDetailResponse smsAddetailResponse = new SMSADDetailResponse();
		smsAddetailResponse.setMessage("Successfully Updated");
		return smsAddetailResponse;
	}
	@Transactional
	@Override
	public SMSADDetailResponse viewByAdCodeADService(String adCode) throws SMSADNotFoundException {

		MySMSAD mySmsAd = dao.ViewByAdCode(adCode);

		SMSADDetailResponse smsAddetailResponse = new SMSADDetailResponse();
		smsAddetailResponse.setAdCode(mySmsAd.getAdCode());
		smsAddetailResponse.setAdCreatedDate(mySmsAd.getAdCreatedDate());
		smsAddetailResponse.setAdUpdatedDate(mySmsAd.getAdUpdatedDate());
		smsAddetailResponse.setAdDetails(mySmsAd.getAdDetails());
		smsAddetailResponse.setAdUser(mySmsAd.getAdUser());

		return smsAddetailResponse;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public SMSADList viewAllADService() {

		SMSADList smsAdList = new SMSADList();

		List<MySMSAD> mySmsAdList = dao.ViewAll();
		for (MySMSAD mySmsAd : mySmsAdList) {

			SMSADDetailResponse smsAdDetailResponse = new SMSADDetailResponse();
			smsAdDetailResponse.setAdCode(mySmsAd.getAdCode());
			smsAdDetailResponse.setAdCreatedDate(mySmsAd.getAdCreatedDate());
			smsAdDetailResponse.setAdUpdatedDate(mySmsAd.getAdUpdatedDate());
			smsAdDetailResponse.setAdDetails(mySmsAd.getAdDetails());
			smsAdDetailResponse.setAdUser(mySmsAd.getAdUser());
			smsAdList.getSmsAdList().add(smsAdDetailResponse);
		}
		return smsAdList;
	}

}
