package mx.com.alex.crazycards.models;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Date;

import mx.com.alex.crazycards.database.DatabaseAdapter;

/**
 * Created by mobilestudio06 on 11/08/15.
 */
public class Verb {

    public static final String TABLE_NAME = "Verb";
    public static final String ID_VERB = "idVerb";
    public static final String VERB_ENGLISH = "verbEnglish";
    public static final String VERB_SPANISH = "verbSpanish";
    public static final String URL_IMAGE = "urlImgTrue";



    private int idVerb;
    private String verbEnglish;
    private String verbSpanish;
    private String urlImgTrue;


    public int getIdVerb() {
        return idVerb;
    }

    public void setIdVerb(int idVerb) {
        this.idVerb = idVerb;
    }

    public String getVerbEnglish() {
        return verbEnglish;
    }

    public void setVerbEnglish(String verbEnglish) {
        this.verbEnglish = verbEnglish;
    }

    public String getVerbSpanish() {
        return verbSpanish;
    }

    public void setVerbSpanish(String verbSpanish) {
        this.verbSpanish = verbSpanish;
    }

    public String getUrlImgTrue() {
        return urlImgTrue;
    }

    public void setUrlImgTrue(String urlImgTrue) {
        this.urlImgTrue = urlImgTrue;
    }


    public Verb(int idVerb,String verbEnglish, String verbSpanish, String urlImgTrue) {
        this.idVerb = idVerb;
        this.verbEnglish = verbEnglish;
        this.verbSpanish = verbSpanish;
        this.urlImgTrue = urlImgTrue;
    }

    public static ArrayList<Verb> getVerbs(Context context) {
        ArrayList<Verb> verbs= new ArrayList<Verb>();

        try {
            Cursor cursor = DatabaseAdapter.getDB(context).query(TABLE_NAME,null,null,null,null,null,null,null);
            if (cursor!=null){
                for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                    int idVerb =  cursor.getInt(cursor.getColumnIndexOrThrow(ID_VERB));
                    String verbEnglish = cursor.getString(cursor.getColumnIndexOrThrow(VERB_ENGLISH));
                    String verbSpanish = cursor.getString(cursor.getColumnIndexOrThrow(VERB_SPANISH));
                    String urlImgTrue = cursor.getString(cursor.getColumnIndexOrThrow(URL_IMAGE));


                    verbs.add(new Verb(idVerb, verbEnglish,verbSpanish,urlImgTrue));
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return verbs;
    }
}
