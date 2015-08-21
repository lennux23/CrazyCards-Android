package mx.com.alex.crazycards.models;

/**
 * Created by mobilestudio06 on 20/08/15.
 */
public class ImagesVerbs {
    private int idVerb;
    private String ima1;
    private String ima2;
    private String ima3;
    private String ima4;

    public int getIdVerb() {
        return idVerb;
    }

    public void setIdVerb(int idVerb) {
        this.idVerb = idVerb;
    }

    public String getIma1() {
        return ima1;
    }

    public void setIma1(String ima1) {
        this.ima1 = ima1;
    }

    public String getIma2() {
        return ima2;
    }

    public void setIma2(String ima2) {
        this.ima2 = ima2;
    }

    public String getIma3() {
        return ima3;
    }

    public void setIma3(String ima3) {
        this.ima3 = ima3;
    }

    public String getIma4() {
        return ima4;
    }

    public void setIma4(String ima4) {
        this.ima4 = ima4;
    }

    public ImagesVerbs(int idVerb, String ima1, String ima2, String ima3, String ima4) {
        this.idVerb = idVerb;
        this.ima1 = ima1;
        this.ima2 = ima2;
        this.ima3 = ima3;
        this.ima4 = ima4;
    }
}
