
package com.eli.calc.shape.service.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for calcType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="calcType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CALC_AREA"/&gt;
 *     &lt;enumeration value="CALC_VOLUME"/&gt;
 *     &lt;enumeration value="CALC_FOO"/&gt;
 *     &lt;enumeration value="CALC_FOOBAR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "calcType")
@XmlEnum
public enum CalcType {

    CALC_AREA,
    CALC_VOLUME,
    CALC_FOO,
    CALC_FOOBAR;

    public String value() {
        return name();
    }

    public static CalcType fromValue(String v) {
        return valueOf(v);
    }

}
