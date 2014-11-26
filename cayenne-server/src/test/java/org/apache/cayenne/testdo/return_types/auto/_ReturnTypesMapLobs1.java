package org.apache.cayenne.testdo.return_types.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _ReturnTypesMapLobs1 was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ReturnTypesMapLobs1 extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    @Deprecated
    public static final String CLOB_COLUMN_PROPERTY = "clobColumn";

    public static final String AAAID_PK_COLUMN = "AAAID";

    public static final Property<String> CLOB_COLUMN = new Property<String>("clobColumn");

    public void setClobColumn(String clobColumn) {
        writeProperty("clobColumn", clobColumn);
    }
    public String getClobColumn() {
        return (String)readProperty("clobColumn");
    }

}