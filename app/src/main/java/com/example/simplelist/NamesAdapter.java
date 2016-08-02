package com.example.simplelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 8/1/2016.
 */
public class NamesAdapter extends ArrayAdapter<String> {

    public NamesAdapter(Context context, ArrayList<String> list) {
        super(context, R.layout.list_item, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater buckysInflater = LayoutInflater.from(getContext());
        View customView = buckysInflater.inflate(R.layout.list_item, parent, false);

        String name = getItem(position);
        TextView buckysText = (TextView) customView.findViewById(R.id.l_item_txt);
        ImageView buckysImage = (ImageView) customView.findViewById(R.id.l_item_img);

        char ch = name.toLowerCase().charAt(0);

        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            buckysImage.setImageResource(R.drawable.ic_thumb_up_black_24dp);
        else buckysImage.setImageResource(R.drawable.ic_thumb_down_black_24dp);
        buckysText.setText(name);
        return customView;
    }
}