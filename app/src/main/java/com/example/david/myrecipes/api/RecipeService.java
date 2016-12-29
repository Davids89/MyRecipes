package com.example.david.myrecipes.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by david on 28/12/16.
 */

public interface RecipeService {
    @GET("search")
    Call<RecipeSearchResponse> search(@Query("key") String key,
                                      @Query("sort") String sort,
                                      @Query("count") int count,
                                      @Query("page") int page);
}
