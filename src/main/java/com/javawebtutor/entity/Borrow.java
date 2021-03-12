package com.javawebtutor.entity;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Any(metaColumn = @Column(name = "ITEM_TYPE"))
    @AnyMetaDef(idType = "int", metaType = "string",
            metaValues = {
                    @MetaValue(targetEntity = Book.class, value = "B"),
                    @MetaValue(targetEntity = VHS.class, value = "V"),
                    @MetaValue(targetEntity = DVD.class, value = "D")
            })
    @JoinColumn(name="item_id")
    private Object item;

    public Borrow() {
    }

    public Borrow(int id, Object item) {
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
