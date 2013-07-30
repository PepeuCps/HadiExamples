package com.hadi.example.repository;

import android.content.Context;

import com.hadi.example.model.Child;
import com.hadi.example.model.Father;
import com.the9tcat.hadi.DefaultDAO;

import java.util.List;

public class Repository {
    private DefaultDAO dao;

    public Repository(Context context) {
        dao = new DefaultDAO(context);
    }

    public void insertFather(Father father) {
        long id = dao.insert(father);
        if(id > 0) {
            for (int i = 0; i <= father.getChilds().size()-1; i++) {
                Child child = father.getChilds().get(i);
                child.setFatherId(id);
                dao.insert(child);
            }
        }
    }

    public List<Child> getChilds(long fatherId) {
        return (List<Child>)dao.select(Child.class, false, " fatherId = ? ", new String[] { String.valueOf(fatherId) }, null, null, null, null);
    }

    public List<Father> getFathers() {
        return (List<Father>)dao.select(Father.class, false, null, null, null, null, null, null);
    }

    public List<Father> associateFathersAndChilds(List<Father> fathers) {
        for (int i = 0; i <= fathers.size()-1; i++) {
            Father father = fathers.get(i);
            father.setChilds(getChilds(father.getId()));
        }
        return fathers;
    }
}
