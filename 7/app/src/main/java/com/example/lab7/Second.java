package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Second extends AppCompatActivity {

    private ListView list1, list2;
    private ArrayList<String> arrayList1, arrayList2;
    private EditText editText;
    private ArrayAdapter<String> adapter1, adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        list1 = (ListView)findViewById(R.id.listview1);
        list2 = (ListView)findViewById(R.id.listview2);
        editText = (EditText)findViewById(R.id.edittext);

        arrayList1 = new ArrayList<String>();
        adapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList1);

        arrayList2 = new ArrayList<String>();
        adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList2);

        list1.setAdapter(adapter1);
        list2.setAdapter(adapter2);
    }
    public void Btn(View v) {
        switch (v.getId()) {
            case R.id.btnAdd1:
                arrayList1.add(editText.getText().toString());
                // next thing you have to do is check if your adapter has changed
                adapter1.notifyDataSetChanged();
                break;
            case R.id.btnAdd2:
                arrayList2.add(editText.getText().toString());
                // next thing you have to do is check if your adapter has changed
                adapter2.notifyDataSetChanged();
                break;
            case R.id.btnBack:
                super.onBackPressed();
                break;
        }
    }
}