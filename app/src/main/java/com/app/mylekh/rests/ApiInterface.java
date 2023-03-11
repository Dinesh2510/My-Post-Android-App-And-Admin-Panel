package com.app.mylekh.rests;

import com.app.mylekh.callbacks.CallbackCategories;
import com.app.mylekh.callbacks.CallbackHome;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {

    String CACHE = "Cache-Control: max-age=0";
    String AGENT = "Data-Agent: Your Recipes App";

    @Headers({CACHE, AGENT})
    @GET("GetAllPostList.php")
    Call<CallbackHome> getHome();

    @Headers({CACHE, AGENT})
    @GET("GetAllCategoryList.php")
    Call<CallbackCategories> getAllCategories();

    @Headers({CACHE, AGENT})
    @GET("GetAllCategoryPostList.php")
    Call<CallbackHome> getPostByCategory(
            @Query("category_id") String id
    );


}
