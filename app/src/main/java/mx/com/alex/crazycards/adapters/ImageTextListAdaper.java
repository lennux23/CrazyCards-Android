package mx.com.alex.crazycards.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.com.alex.crazycards.R;
import mx.com.alex.crazycards.models.OptionMenu;

/**
 * Created by Rick on 11/08/15.
 */
public class ImageTextListAdaper extends ArrayAdapter {


    private ArrayList<OptionMenu> arrayElements;
    private int resource;
    private Context context;

    public ImageTextListAdaper(Context context, ArrayList arrayElements) {
        super(context,R.layout.itemlist_ico_text, arrayElements);
        this.resource = R.layout.itemlist_ico_text;
        this.arrayElements = arrayElements;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(resource,parent,false);
            holder = new ViewHolder();
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);

        }else{

            holder = (ViewHolder) convertView.getTag();
        }

        OptionMenu optionMenu = arrayElements.get(position);

        holder.icon.setImageDrawable(optionMenu.getIco());
        holder.text.setText(optionMenu.getNameOption());

        return convertView;


    }

    class ViewHolder{

        TextView text;
        ImageView icon;
    }
}
