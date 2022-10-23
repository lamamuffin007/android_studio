package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> name = new ArrayList<>();
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) { //восстанавливаем массив строк из ресурса
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView)findViewById(R.id.listView);

        ColorsAdapter adapter = new ColorsAdapter(getResources().getStringArray(R.array.list));
        listview.setAdapter(adapter);
    }
}
