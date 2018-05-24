/**
 * 
 */
package com.perot.training.dayfive;

import java.beans.PropertyEditorSupport;

/**
 * @author abrahade
 */
public class PersonNameEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String arg0) throws IllegalArgumentException {
        if (arg0.indexOf('-') == -1) {
            throw new IllegalArgumentException("Invalid argument: '" + arg0
                    + "' must have '-' to separate a name");
        }
        String[] strArray = arg0.split("-");
        PersonName pn = new PersonName(strArray[0], strArray[1]);
        setValue(pn);
    }

}
