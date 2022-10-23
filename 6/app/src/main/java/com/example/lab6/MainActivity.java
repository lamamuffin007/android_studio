package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSecondActivity(View view){
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }
    public void openThirdActivity(View view){
        Intent intent = new Intent(this, Third.class);
        startActivity(intent);
    }
}
