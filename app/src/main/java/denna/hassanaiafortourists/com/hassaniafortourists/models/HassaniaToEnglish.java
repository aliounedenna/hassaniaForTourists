package  denna.hassanaiafortourists.com.hassaniafortourists.models;

/**
 * Created by Denna on 9/21/2017.
 */

public class HassaniaToEnglish {
   private String idWord;
    private String wdHassania;
    private String wdEnglish;

    public HassaniaToEnglish(String wdHassania, String wdEnglish) {
        this.wdHassania = wdHassania;
        this.wdEnglish = wdEnglish;
    }

    // getter et setter des IDs des mots
    public String getIdWord() {
        return idWord;
    }
    public void setIdWord(String idWord) {
        this.idWord = idWord;
    }
// getter and setter pour le mot en hassania e

    public String getWdHassania() {
        return wdHassania;
    }

    public void setWdEnglish(String wdEnglish) {
        this.wdEnglish = wdEnglish;
    }

    //getter et setter des mots en englais
    public String getWdEnglish() {
        return wdEnglish;
    }
    public void setWdHassania(String wdHassania) {
        this.wdHassania = wdHassania;
    }


}
