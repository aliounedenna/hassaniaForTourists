package denna.hassanaiafortourists.com.hassaniafortourists.rest;

import java.util.List;

import denna.hassanaiafortourists.com.hassaniafortourists.models.Word;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

// J'ai changé GET par POST pour plus de transparance

public interface ApiInterface {
    //adress de l'API de la class Config
    @FormUrlEncoded
    @POST(Config.API)
    Call<List<Word>> getWords(@Field("all") int all);


    @FormUrlEncoded
    @POST(Config.API)
    Call<Word> getWord(@Field("id") int word_id);

}