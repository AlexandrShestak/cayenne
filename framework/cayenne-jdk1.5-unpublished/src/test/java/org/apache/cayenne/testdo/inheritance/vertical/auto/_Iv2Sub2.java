package org.apache.cayenne.testdo.inheritance.vertical.auto;

import org.apache.cayenne.testdo.inheritance.vertical.Iv2Root;

/**
 * Class _Iv2Sub2 was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Iv2Sub2 extends Iv2Root {

    public static final String NAME_PROPERTY = "name";
    public static final String SUB2ATTR_PROPERTY = "sub2Attr";

    public static final String ID_PK_COLUMN = "ID";

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }

    public void setSub2Attr(String sub2Attr) {
        writeProperty("sub2Attr", sub2Attr);
    }
    public String getSub2Attr() {
        return (String)readProperty("sub2Attr");
    }

}