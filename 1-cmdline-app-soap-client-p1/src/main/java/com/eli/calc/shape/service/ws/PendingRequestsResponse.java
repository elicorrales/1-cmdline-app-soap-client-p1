
package com.eli.calc.shape.service.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pendingRequestsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pendingRequestsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.service.shape.calc.eli.com/}statusResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numPending" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="pendingRequests" type="{http://ws.service.shape.calc.eli.com/}calculationRequest" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pendingRequestsResponse", propOrder = {
    "numPending",
    "pendingRequests"
})
public class PendingRequestsResponse
    extends StatusResponse
{

    protected int numPending;
    @XmlElement(nillable = true)
    protected List<CalculationRequest> pendingRequests;

    /**
     * Gets the value of the numPending property.
     * 
     */
    public int getNumPending() {
        return numPending;
    }

    /**
     * Sets the value of the numPending property.
     * 
     */
    public void setNumPending(int value) {
        this.numPending = value;
    }

    /**
     * Gets the value of the pendingRequests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pendingRequests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPendingRequests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalculationRequest }
     * 
     * 
     */
    public List<CalculationRequest> getPendingRequests() {
        if (pendingRequests == null) {
            pendingRequests = new ArrayList<CalculationRequest>();
        }
        return this.pendingRequests;
    }

}
