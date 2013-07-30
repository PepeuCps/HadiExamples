package com.hadi.example.model;

import com.the9tcat.hadi.annotation.Column;
import com.the9tcat.hadi.annotation.Table;

import java.util.ArrayList;
import java.util.List;

@Table(name="Father")
public class Father {

    @Column(name="id", primary=true, autoincrement=true)
    private long id;

    @Column(name="name")
    private String name;

    private List<Child> childs;

    public Father() {
        this.name = "";
        this.childs = new ArrayList<Child>();
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

    public List<Child> getChilds() {
        return childs;
    }

    public void setChilds(List<Child> childs) {
        this.childs = childs;
    }
}
