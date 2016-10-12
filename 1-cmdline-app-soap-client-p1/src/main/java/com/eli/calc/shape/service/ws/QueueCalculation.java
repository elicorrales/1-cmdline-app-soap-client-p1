
package com.eli.calc.shape.service.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for queueCalculation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queueCalculation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="QueueCalculationParms" type="{http://ws.service.shape.calc.eli.com/}queueCalculationParms"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queueCalculation", propOrder = {
    "queueCalculationParms"
})
public class QueueCalculation {

    @XmlElement(name = "QueueCalculationParms", required = true)
    protected QueueCalculationParms queueCalculationParms;

    /**
     * Gets the value of the queueCalculationParms property.
     * 
     * @return
     *     possible object is
     *     {@link QueueCalculationParms }
     *     
     */
    public QueueCalculationParms getQueueCalculationParms() {
        return queueCalculationParms;
    }

    /**
     * Sets the value of the queueCalculationParms property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueueCalculationParms }
     *     
     */
    public void setQueueCalculationParms(QueueCalculationParms value) {
        this.queueCalculationParms = value;
    }

}
