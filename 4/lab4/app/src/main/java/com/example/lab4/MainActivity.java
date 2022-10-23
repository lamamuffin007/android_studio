package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private TextView textView;
    private Button button1,button2, button3, button4;

    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_main);
        editText1=(EditText)findViewById(R.id.et1);
        editText2=(EditText)findViewById(R.id.et2);
        textView= (TextView) findViewById(R.id.tv_4);
        button1= (Button)findViewById(R.id.but_1);
        button2= (Button)findViewById(R.id.but_2);
        button3=(Button)findViewById(R.id.but_3);
        button4= (Button)findViewById(R.id.but_4);
    }

    public void onBut_1 (View view){
        int n=Integer.valueOf(editText1.getText().toString());  //Преобразование из строкового типа в целый
        int m=Integer.valueOf(editText2.getText().toString());  //Преобразование из строкового типа в целый

        int res = n + m;
        String ress = String.valueOf(n) + "+" + String.valueOf(m) + " = " +  String.valueOf(res);
        textView.setText( ress);
    }

    public void onBut_2 (View view){
        int n=Integer.valueOf(editText1.getText().toString());  //Преобразование из строкового типа в целый
        int m=Integer.valueOf(editText2.getText().toString());  //Преобразование из строкового типа в целый
        int res = n - m;
        String ress = String.valueOf(n) + "-" + String.valueOf(m) + " = " +  String.valueOf(res);
        textView.setText( ress);
    }

    public void onBut_3 (View view){
        int n=Integer.valueOf(editText1.getText().toString());  //Преобразование из строкового типа в целый
        int m=Integer.valueOf(editText2.getText().toString());  //Преобразование из строкового типа в целый
        int res = n * m;
        String ress = String.valueOf(n) + "*" + String.valueOf(m) + " = " +  String.valueOf(res);
        textView.setText( ress);
    }

    public void onBut_4 (View view){
        int n=Integer.valueOf(editText1.getText().toString());  //Преобразование из строкового типа в целый
        int m=Integer.valueOf(editText2.getText().toString());  //Преобразование из строкового типа в целый
        int res = n / m;
        String ress = String.valueOf(n) + "/" + String.valueOf(m) + " = " +  String.valueOf(res);
        textView.setText( ress);
    }
}
