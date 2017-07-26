
package org.elan.ws;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(namespace="SumResponse", name = "SumResponse", propOrder = { "sum" }) 
@XmlRootElement(name = "SumResponse")
public class SumResponse {

    protected int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int value) {
        this.sum = value;
    }

}
