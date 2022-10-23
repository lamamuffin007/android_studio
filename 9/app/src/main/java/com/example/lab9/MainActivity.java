package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2, editText3;
    private SharedPreferences preferences; //ссылка на объект-настройку

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText)findViewById(R.id.edittext1);
        editText2 = (EditText)findViewById(R.id.edittext2);
        editText3 = (EditText)findViewById(R.id.edittext3);

        preferences = getSharedPreferences(  //метод getSharedPreferences возвращает объект-настройку
                //с именем, которое содержится в первом параметре.
                getString(R.string.preferences), //имя настройки здесь берется из строкового ресурса
                MODE_PRIVATE //скрытый режим – только наше приложение может читать этот файл-настройку
        );
    }

    @Override
    protected void onResume() { //обработчик события, которое помещает активность на передний план
        super.onResume(); //вызов обработчика базового класса

        if(preferences.contains(getString(R.string.str1_element)))
            editText1.setText(preferences.getString(getString(R.string.str1_element), ""));

        if(preferences.contains(getString(R.string.str2_element)))
            editText2.setText(preferences.getString(getString(R.string.str2_element), ""));

        String intElKey = getString(R.string.int_element); //получаем из строкового ресурса ключ
        if(preferences.contains(intElKey))
            editText3.setText(String.valueOf(preferences.getInt(intElKey, 5)));
    }

    @Override
    protected void onPause() { //обработчик события, которое убирает активность с переднего плана
        super.onPause(); //вызов обработчика базового класса

        //с помощью метода edit объекта-активности
        //получаем объект-редактор editor
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(getString(R.string.str1_element), editText1.getText().toString());
        editor.putString(getString(R.string.str2_element), editText2.getText().toString());
        editor.putInt(getString(R.string.int_element), Integer.parseInt(editText3.getText().toString()));
        editor.commit(); //применяем изменения настройки
    }
}
