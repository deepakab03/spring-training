/**
 * 
 */
package com.perot.training.dayfive;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import com.perot.training.dayfive.diffpkg.PersonName2AnotherEditor;

/**
 * @author abrahade
 *
 */
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    /* (non-Javadoc)
     * @see org.springframework.beans.PropertyEditorRegistrar#registerCustomEditors(org.springframework.beans.PropertyEditorRegistry)
     */
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        // it is expected that new PropertyEditor instances are created
        registry.registerCustomEditor(PersonName2.class, new PersonName2AnotherEditor());

        // you could register as many custom property editors as are required here...

    }

}
