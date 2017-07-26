package org.elan.ws.service.to;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SMSADList")
public class SMSADList {
	
	
	
	
	    @XmlElement(name = "SMSADDetailResponse")
	    protected List<SMSADDetailResponse> smsAdDetailResponse;
	    public List<SMSADDetailResponse> getSmsAdList() {
	        if (smsAdDetailResponse == null) {
	        	smsAdDetailResponse = new ArrayList<SMSADDetailResponse>();
	        }
	        return this.smsAdDetailResponse;
	    }
	}
