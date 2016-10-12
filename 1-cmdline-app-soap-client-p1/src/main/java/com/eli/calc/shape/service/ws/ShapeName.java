
package com.eli.calc.shape.service.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shapeName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="shapeName"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CIRCLE"/&gt;
 *     &lt;enumeration value="SQUARE"/&gt;
 *     &lt;enumeration value="EQUILATERALTRIANGLE"/&gt;
 *     &lt;enumeration value="SPHERE"/&gt;
 *     &lt;enumeration value="CUBE"/&gt;
 *     &lt;enumeration value="TETRAHEDRON"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "shapeName")
@XmlEnum
public enum ShapeName {

    CIRCLE,
    SQUARE,
    EQUILATERALTRIANGLE,
    SPHERE,
    CUBE,
    TETRAHEDRON;

    public String value() {
        return name();
    }

    public static ShapeName fromValue(String v) {
        return valueOf(v);
    }

}
