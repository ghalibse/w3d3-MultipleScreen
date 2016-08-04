package com.example.simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private NamesAdapter arrayAdapter;

    private ArrayList<Student> students;


    private String dataJSON = "[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.lst_view);

        Type listType = new TypeToken<List<Student>>() {
        }.getType();
        Gson gson = new GsonBuilder().create();

        students = gson.fromJson(dataJSON, listType);

        arrayAdapter = new NamesAdapter(this, students);

        mListView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student aStudent =  arrayAdapter.getItem(i);

                Toast.makeText(getApplicationContext(), aStudent.name.toUpperCase(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
