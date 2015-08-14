package mx.com.alex.crazycards.models;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

import mx.com.alex.crazycards.R;

/**
 * Created by mobilestudio06 on 11/08/15.
 */
public class OptionMenu {
    private Drawable ico;
    private String nameOption;

    public OptionMenu(Drawable ico, String nameOption) {
        this.ico = ico;
        this.nameOption = nameOption;
    }

    public Drawable getIco() {
        return ico;
    }

    public void setIco(Drawable ico) {
        this.ico = ico;
    }

    public String getNameOption() {
        return nameOption;
    }

    public void setNameOption(String nameOption) {
        this.nameOption = nameOption;
    }

    public static ArrayList<OptionMenu> getMenu(Context context){
        ArrayList<OptionMenu> option = new ArrayList<OptionMenu>();

        option.add(new OptionMenu(context.getResources().getDrawable(R.mipmap.ic_home),context.getString(R.string.menu_home)));
        option.add(new OptionMenu(context.getResources().getDrawable(R.mipmap.ic_home),context.getString(R.string.menu_play)));
        option.add(new OptionMenu(context.getResources().getDrawable(R.mipmap.ic_home),context.getString(R.string.menu_follow)));
        option.add(new OptionMenu(context.getResources().getDrawable(R.mipmap.ic_home),context.getString(R.string.menu_logout)));

        return option;

    }
}
