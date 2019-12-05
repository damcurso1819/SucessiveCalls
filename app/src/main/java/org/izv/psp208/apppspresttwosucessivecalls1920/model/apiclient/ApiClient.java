package org.izv.psp208.apppspresttwosucessivecalls1920.model.apiclient;

import org.izv.psp208.apppspresttwosucessivecalls1920.model.data.Table1;
import org.izv.psp208.apppspresttwosucessivecalls1920.model.data.Table2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiClient {

    @POST("table1")
    Call<Long> postTable1(@Body Table1 table1);

    @POST("table2")
    Call<Long> postTable2(@Body Table2 table2);
}
