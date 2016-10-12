
package com.eli.calc.shape.service.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for runPendingRequestsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="runPendingRequestsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.service.shape.calc.eli.com/}statusResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numRun" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "runPendingRequestsResponse", propOrder = {
    "numRun"
})
public class RunPendingRequestsResponse
    extends StatusResponse
{

    protected int numRun;

    /**
     * Gets the value of the numRun property.
     * 
     */
    public int getNumRun() {
        return numRun;
    }

    /**
     * Sets the value of the numRun property.
     * 
     */
    public void setNumRun(int value) {
        this.numRun = value;
    }

}
