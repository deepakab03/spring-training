/**
 * 
 */
package com.perot.training.dayfive.diffpkg;

import java.beans.PropertyEditorSupport;

import com.perot.training.dayfive.PersonName2;

/**
 * @author abrahade
 */
public class PersonName2AnotherEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String arg0) throws IllegalArgumentException {
        if (arg0.indexOf(' ') == -1) {
            throw new IllegalArgumentException("Invalid argument: '" + arg0
                    + "' must have ' ' to separate a name");
        }
        String[] strArray = arg0.split(" ");
        PersonName2 pn = new PersonName2(strArray[0], strArray[1]);
        setValue(pn);
    }

}
