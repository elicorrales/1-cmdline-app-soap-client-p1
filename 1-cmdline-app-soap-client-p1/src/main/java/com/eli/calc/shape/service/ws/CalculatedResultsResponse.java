
package com.eli.calc.shape.service.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for calculatedResultsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="calculatedResultsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.service.shape.calc.eli.com/}statusResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="calculatedResults" type="{http://ws.service.shape.calc.eli.com/}calculationResult" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="numCalculated" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculatedResultsResponse", propOrder = {
    "calculatedResults",
    "numCalculated"
})
public class CalculatedResultsResponse
    extends StatusResponse
{

    @XmlElement(nillable = true)
    protected List<CalculationResult> calculatedResults;
    protected int numCalculated;

    /**
     * Gets the value of the calculatedResults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calculatedResults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalculatedResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalculationResult }
     * 
     * 
     */
    public List<CalculationResult> getCalculatedResults() {
        if (calculatedResults == null) {
            calculatedResults = new ArrayList<CalculationResult>();
        }
        return this.calculatedResults;
    }

    /**
     * Gets the value of the numCalculated property.
     * 
     */
    public int getNumCalculated() {
        return numCalculated;
    }

    /**
     * Sets the value of the numCalculated property.
     * 
     */
    public void setNumCalculated(int value) {
        this.numCalculated = value;
    }

}
