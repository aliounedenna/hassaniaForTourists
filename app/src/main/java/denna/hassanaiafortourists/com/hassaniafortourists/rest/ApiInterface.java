package denna.hassanaiafortourists.com.hassaniafortourists.rest;

import java.util.List;

import denna.hassanaiafortourists.com.hassaniafortourists.models.Word;
import retrofit2.Call;
import retrofit2.http.GET;

// J'ai changé GET par POST pour plus de transparance

public interface ApiInterface {
    //adress de l'API de la class Config
    //@FormUrlEncoded
    @GET(Config.API)
    Call<List<Word>> getWords();


    // @FormUrlEncoded
    @GET(Config.API)
    Call<Word> getWord(String word_id);

}
