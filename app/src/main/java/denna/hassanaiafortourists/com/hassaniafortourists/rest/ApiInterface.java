package com.maurievents.me.rest;

import com.maurievents.me.model.Event;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

// J'ai changé GET par POST pour plus de transparance

public interface ApiInterface {
    //adress de l'API de la class Config
    @FormUrlEncoded
    @POST(Config.API)
    // Passe les paramètres POST ,
    // cat, km, page, sort, search
    Call<Event> getEvents(@Field("cat") String cat,
                          @Field("km") String km,
                          @Field("page") String page,
                          @Field("sort") String sort);//, @Field("search") String search);


    @FormUrlEncoded
    @POST(Config.API)
    Call<Event> getEvent(@Field("event") String eventid);

    //TODO add interface for getting image


}
