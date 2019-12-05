package org.izv.psp208.apppspresttwosucessivecalls1920;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.izv.psp208.apppspresttwosucessivecalls1920.contract.OnRestListener;
import org.izv.psp208.apppspresttwosucessivecalls1920.model.data.Table1;
import org.izv.psp208.apppspresttwosucessivecalls1920.model.data.Table2;
import org.izv.psp208.apppspresttwosucessivecalls1920.view.AppViewModel;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "xyzyz";

    private AppViewModel model;
    private Button btAdd;
    private EditText etText1, etText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = ViewModelProviders.of(this).get(AppViewModel.class);

        model.getInsertIdTable1().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                if(aLong > 0) {
                    addTable2(aLong, etText2.getText().toString());
                } else {
                    btAdd.setEnabled(true);
                }
            }
        });

        model.getInsertIdTable2().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                if(aLong > 0) {
                    etText1.setText("");
                    etText2.setText("");
                }
                btAdd.setEnabled(true);
            }
        });

        etText1 = findViewById(R.id.etText1);
        etText2 = findViewById(R.id.etText2);
        btAdd = findViewById(R.id.btAdd);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btAdd.setEnabled(false);
                addTable1(etText1.getText().toString());
            }
        });

        //insertData();
        /*
        model.add(table1);
        Thread.sleep(3000);
        //...
        long id = 1;
        Table2 table2 = new Table2(0, id, name2);
        model.add(table2);*/
    }

    private void addTable2(long idTable1, String toString) {
        Table2 table2 = new Table2();
        table2.setIdtable1(idTable1);
        table2.setName(toString);
        model.add(table2);
    }

    private void addTable1(String toString) {
        Table1 table1 = new Table1();
        table1.setName(toString);
        model.add(table1);
    }

    private void insertData() {
        String name1 = "dam";
        final String name2 = "daw";
        Table1 table1 = new Table1();
        table1.setName(name1);

        //1º pintar 'ProgressBar' e 'inhabilitar' la interfaz de usuario
        model.add(table1, new OnRestListener() {

            @Override
            public void onError(String message) {
                //aquí hago lo que sea
            }

            @Override
            public void onSuccess(long id) {
                insertData2(name2, id);
            }
        });
    }

    private void insertData2(String name, long id) {
        Table2 table2 = new Table2();
        table2.setName(name);
        table2.setIdtable1(id);

        //1º pintar 'ProgressBar' e 'inhabilitar' la interfaz de usuario
        model.add(table2, new OnRestListener() {

            @Override
            public void onError(String message) {
                //aquí hago lo que sea
            }

            @Override
            public void onSuccess(long id) {
                //quitar 'ProgressBar' y habilitar la interfaz
            }
        });
    }
}