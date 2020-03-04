
package org.me.calculator.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "add", propOrder = {
    "i",
    "j"
})
public class Add {

    protected String i;
    protected String j;

    /**
     * Gets the value of the i property.
     * 
     * @return 
     */
    public String getI() {
        return i;
    }

    /**
     * Sets the value of the i property.
     * 
     * @param value
     */
    public void setI(String value) {
        this.i = value;
    }

    /**
     * Gets the value of the j property.
     * 
     * @return 
     */
    public String getJ() {
        return j;
    }

    /**
     * Sets the value of the j property.
     * 
     * @param value
     */
    public void setJ(String value) {
        this.j = value;
    }

}
