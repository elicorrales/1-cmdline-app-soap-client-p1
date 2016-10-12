
package com.eli.calc.shape.service.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for queueCalculationParms complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queueCalculationParms"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="shapeName" type="{http://ws.service.shape.calc.eli.com/}shapeName"/&gt;
 *         &lt;element name="calcType" type="{http://ws.service.shape.calc.eli.com/}calcType"/&gt;
 *         &lt;element name="dimension" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queueCalculationParms", propOrder = {
    "shapeName",
    "calcType",
    "dimension"
})
public class QueueCalculationParms {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ShapeName shapeName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CalcType calcType;
    protected double dimension;

    /**
     * Gets the value of the shapeName property.
     * 
     * @return
     *     possible object is
     *     {@link ShapeName }
     *     
     */
    public ShapeName getShapeName() {
        return shapeName;
    }

    /**
     * Sets the value of the shapeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShapeName }
     *     
     */
    public void setShapeName(ShapeName value) {
        this.shapeName = value;
    }

    /**
     * Gets the value of the calcType property.
     * 
     * @return
     *     possible object is
     *     {@link CalcType }
     *     
     */
    public CalcType getCalcType() {
        return calcType;
    }

    /**
     * Sets the value of the calcType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CalcType }
     *     
     */
    public void setCalcType(CalcType value) {
        this.calcType = value;
    }

    /**
     * Gets the value of the dimension property.
     * 
     */
    public double getDimension() {
        return dimension;
    }

    /**
     * Sets the value of the dimension property.
     * 
     */
    public void setDimension(double value) {
        this.dimension = value;
    }

}
