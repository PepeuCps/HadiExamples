package com.hadi.example.activity;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

import com.hadi.example.R;
import com.hadi.example.model.Child;
import com.hadi.example.model.Father;
import com.hadi.example.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository repository = new Repository(getApplicationContext());

        /* INSERINDO DADOS */

        // PAI 1
        Father father1 = new Father();
        father1.setName("Pai 1");

        List<Child> childsFather1 = new ArrayList<Child>();

        Child child1 = new Child();
        child1.setName("Filho 1 do Pai 1");
        childsFather1.add(child1);

        Child child2 = new Child();
        child2.setName("Filho 2 do Pai 1");
        childsFather1.add(child2);

        Child child3 = new Child();
        child3.setName("Filho 3 do Pai 1");
        childsFather1.add(child3);

        father1.setChilds(childsFather1);
        repository.insertFather(father1);

        // PAI 2
        Father father2 = new Father();
        father1.setName("Pai 2");

        List<Child> childsFather2 = new ArrayList<Child>();

        Child child4 = new Child();
        child4.setName("Filho 1 do Pai 2");
        childsFather2.add(child4);

        Child child5 = new Child();
        child5.setName("Filho 2 do Pai 2");
        childsFather2.add(child5);

        Child child6 = new Child();
        child6.setName("Filho 3 do Pai 2");
        childsFather2.add(child6);

        father2.setChilds(childsFather2);
        repository.insertFather(father2);

        /* RECUPERANDO DADOS */
        List<Father> fathers = repository.getFathers();

        //Associando os filhos aos pais
        repository.associateFathersAndChilds(fathers);

        //Percorrendo a estrutura de pais e filhos
        for(int i = 0; i <= fathers.size()-1; i++) {
            Father father = fathers.get(i);
            Log.i("HADI EXAMPLE", "FATHER ID " + father.getId());
            Log.i("HADI EXAMPLE", "FATHER NAME " + father.getName());
            Log.i("HADI EXAMPLE", "FATHER HAS " + father.getChilds().size() + " CHILDS");

            for(int c = 0; c <= father.getChilds().size()-1; c++) {
                Child child = father.getChilds().get(c);
                Log.i("HADI EXAMPLE", "CHILD ID " + child.getId());
                Log.i("HADI EXAMPLE", "CHILD NAME " + child.getName());
                Log.i("HADI EXAMPLE", "CHILD FATHERID " + child.getFatherId());
            }
        }
    }
}
