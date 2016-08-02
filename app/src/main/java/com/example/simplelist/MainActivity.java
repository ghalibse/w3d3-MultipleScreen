package com.example.simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private TextView mTextView;
    private EditText mEditText;
    private Button mButton;

    private  NamesAdapter arrayAdapter;



    private String[] mData = {"Chris", "Mike", "Aldo", "Karles", "Libu",
                                            "Dog", "Pig", "Cats", "Bird", "Cow"};

    private ArrayList<String> dataList = new ArrayList<String>(Arrays.asList(mData));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList.addAll(Arrays.asList(mData));
        mListView = (ListView) findViewById(R.id.lst_view);

        mTextView = (TextView) findViewById(R.id.txtView);
        mEditText = (EditText) findViewById(R.id.EditView);
        mButton = (Button) findViewById(R.id.btn1);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = mEditText.getText().toString();
                mTextView.setText(newName);
                dataList.add(newName);
            }
        });

        arrayAdapter = new NamesAdapter(this, dataList);

        mListView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }
}
