package com.example.gqueste.gqueste;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Gabriel QUESTE on 29/01/2016.
 */
public interface HenriPotierService {

    @GET("books")
    Call<List<Book>> listBooks();
}
