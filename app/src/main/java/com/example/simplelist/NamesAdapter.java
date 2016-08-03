package com.example.simplelist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 8/1/2016.
 */
public class NamesAdapter extends ArrayAdapter<Student> {

    public NamesAdapter(Context context, List<Student> list) {
        super(context, R.layout.list_item, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater buckysInflater = LayoutInflater.from(getContext());
        View customView = buckysInflater.inflate(R.layout.list_item, parent, false);

        Student aStudent = getItem(position);
        TextView buckysText = (TextView) customView.findViewById(R.id.l_item_txt);

        double grade = aStudent.grade;

        if( grade < 7.0 ) buckysText.setBackgroundColor(Color.RED);

         buckysText.setText((CharSequence) aStudent.toString());

        return customView;
    }

}