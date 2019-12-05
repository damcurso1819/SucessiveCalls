package org.izv.psp208.apppspresttwosucessivecalls1920.model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.izv.psp208.apppspresttwosucessivecalls1920.contract.OnRestListener;
import org.izv.psp208.apppspresttwosucessivecalls1920.model.apiclient.ApiClient;
import org.izv.psp208.apppspresttwosucessivecalls1920.model.data.Table1;
import org.izv.psp208.apppspresttwosucessivecalls1920.model.data.Table2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.izv.psp208.apppspresttwosucessivecalls1920.MainActivity.TAG;

public class Repository {

    private ApiClient apiClient;
    private MutableLiveData<Long> insertIdTable1 = new MutableLiveData<>();
    private MutableLiveData<Long> insertIdTable2 = new MutableLiveData<>();

    private String url = "informatica.ieszaidinvergeles.org:8020";

    public Repository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://" + url + "/appHebra/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiClient = retrofit.create(ApiClient.class);
    }

    public void add(Table1 table1, final OnRestListener restListener){
        Call<Long> call = apiClient.postTable1(table1);
        call.enqueue(new Callback<Long>() {

            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Log.v(TAG, response.body().toString());
                long resultado = response.body();
                insertIdTable1.setValue(resultado);
                if(restListener != null) {
                    restListener.onSuccess(resultado);
                }
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                Log.v(TAG, t.getLocalizedMessage());
                insertIdTable1.setValue(0l);
                //restListener.onError(t.getLocalizedMessage());
            }
        });
    }

    public void add(Table2 table2, final OnRestListener restListener){
        Call<Long> call = apiClient.postTable2(table2);
        call.enqueue(new Callback<Long>() {

            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Log.v(TAG, response.body().toString());
                long resultado = response.body();
                insertIdTable2.setValue(resultado);
                if(restListener != null) {
                    restListener.onSuccess(resultado);
                }
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                Log.v(TAG, t.getLocalizedMessage());
                insertIdTable2.setValue(0l);
            }
        });
    }

    public MutableLiveData<Long> getInsertIdTable1() {
        return insertIdTable1;
    }

    public MutableLiveData<Long> getInsertIdTable2() {
        return insertIdTable2;
    }
}
