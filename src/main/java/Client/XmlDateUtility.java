/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class XmlDateUtility {

    public XMLGregorianCalendar createXMLGregorinCalendarNOW() {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new java.util.Date());
        XMLGregorianCalendar date2 = null;
        try {
            date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(XmlDateUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date2;
    }

    public XMLGregorianCalendar createXMLGregorinCalendar(java.util.Date date) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        XMLGregorianCalendar date2 = null;
        try {
            date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(XmlDateUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date2;
    }

}
