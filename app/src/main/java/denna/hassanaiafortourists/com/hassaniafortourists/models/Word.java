package denna.hassanaiafortourists.com.hassaniafortourists.models;

import com.google.gson.annotations.SerializedName;


/**
 * Created by Denna on 9/21/2017.
 */


public class Words {

    @SerializedName("_id")
    private String _id;
    @SerializedName("wdHassaniya")
    private String wdHassania;
    @SerializedName("wdEnglish")
    private String wdEnglish;


    public Words() {
    }

    public Words(String has, String eng) {
        this.wdHassania = has;
        this.wdEnglish = eng;
    }

    public String get_id() {
        return _id != null ? _id : "";
    }

    public void set_id(String _i) {
        this._id = _id;
    }

    public String getWdHassania() {
        return wdHassania != null ? wdHassania : "";
    }

    public void setWdHassania(String wdHassania) {
        this.wdHassania = wdHassania;
    }

    public String getWdEnglish() {
        return wdEnglish != null ? wdEnglish : "";
    }

    public void setWdEnglish(String wdEnglish) {
        this.wdEnglish = wdEnglish;
    }


}
