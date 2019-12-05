package org.izv.psp208.apppspresttwosucessivecalls1920.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.izv.psp208.apppspresttwosucessivecalls1920.contract.OnRestListener;
import org.izv.psp208.apppspresttwosucessivecalls1920.model.Repository;
import org.izv.psp208.apppspresttwosucessivecalls1920.model.data.Table1;
import org.izv.psp208.apppspresttwosucessivecalls1920.model.data.Table2;

public class AppViewModel extends AndroidViewModel {

    private Repository repository;

    public AppViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    public void add(String name1, String name2, OnRestListener restListener) {
        Table1 table1 = new Table1(0, name1);
        //add(table1, );

        /*Table2 table2 = new Table2(0,0, name2);
        //...
        long id = 1;
        table2.setIdtable1(id);
        add(table2);*/

    }

    public void add(Table1 table1, OnRestListener restListener) {
        repository.add(table1, restListener);
    }

    public void add(Table2 table2, OnRestListener restListener) {
        repository.add(table2, restListener);
    }

    public void add(Table1 table1) {
        repository.add(table1, null);
    }

    public void add(Table2 table2) {
        repository.add(table2, null);
    }

    public LiveData<Long> getInsertIdTable1() {
        return repository.getInsertIdTable1();
    }

    public LiveData<Long> getInsertIdTable2() {
        return repository.getInsertIdTable2();
    }

}