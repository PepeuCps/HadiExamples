package com.hadi.example.model;

import com.the9tcat.hadi.annotation.Column;
import com.the9tcat.hadi.annotation.Table;

@Table(name="Child")
public class Child {

    @Column(name="id", primary=true, autoincrement=true)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="fatherId")
    private long fatherId;

    public Child() {
        this.name = "";
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFatherId() {
        return fatherId;
    }

    public void setFatherId(long fatherId) {
        this.fatherId = fatherId;
    }
}
