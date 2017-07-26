
package org.elan.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace="SumRequest", name = "SumRequest", propOrder = { "addend" }) 
@XmlRootElement(name = "SumRequest")
public class SumRequest {
	

   

	@XmlElement(type = Integer.class)
    protected List<Integer> addend;

    public List<Integer> getAddend() {
        if (addend == null) {
            addend = new ArrayList<Integer>();
        }
        return this.addend;
    }

}
