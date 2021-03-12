@AnyMetaDef(name= "StudentMetaDef", metaType = "string", idType = "int",
    metaValues = {
            @MetaValue(value = "B", targetEntity = Boy.class),
            @MetaValue(value = "G", targetEntity = Girl.class)
    }
)
package com.javawebtutor.entity;

import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;
