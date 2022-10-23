package com.example.lab5;

import android.app.LauncherActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private EditText editText;
    private Button button1, button2, button3, button4;
    private ArrayAdapter<String> arad;  //ссылка на стандартный строковый адаптер –
    //объект класса ArrayAdapter<String>
    private ListView lw;  //ссылка на ListView
    private Integer position;
    private View curView=null;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.et);
        button1= (Button) findViewById(R.id.but_1);
        button2= (Button) findViewById(R.id.but_2);
        button3= (Button) findViewById(R.id.but_3);
        button4= (Button) findViewById(R.id.but_4);
        arad=new ArrayAdapter<String>(this,R.layout.le); //создаем стандартный строковый адаптер,
        //второй параметр конструктора – файл
        // с разметкой для элемента списка
        lw=(ListView)findViewById(R.id.lw); //получаем ссылку на ListView
        lw.setAdapter(arad); //устанавливаем для списка адаптер
        arad.add("first"); // через метод add адаптера добавляем в список первую строку
        arad.add("second");
        lw.setOnItemClickListener(this);
    }

    public void onAdd(View view){
        arad.add(editText.getText().toString());
        button2.setEnabled(true);
        button3.setEnabled(true);
    }

    public void onClear(View view){
        arad.clear();
        if(arad.isEmpty()){
            button2.setEnabled(false);
            button3.setEnabled(false);
        }
    }

    public void onEdit(View view){
        //String s = arad.getItem(position);//получаем ссылку на последнюю выбранную из списка строку (все строки
        //из списка хранятся в адаптере).
        //curP – сохраненная на уровне класса позиция последней выбранной строки
        //arad.remove(s);  //удаляем строку, на которую указывает ссылка, используя метод адаптера remove
        arad.remove(arad.getItem(position));
        arad.insert(editText.getText().toString(), position); //вставка новой версии строки из EditText
        //на место только что удаленной.
        //Используется метод адаптера insert
    }

    public void onDel(View view){
        arad.remove(arad.getItem(position));
        if(arad.isEmpty()){
            button2.setEnabled(false);
            button3.setEnabled(false);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String s=arad.getItem(position);
        this.position=position;
        view.setBackgroundColor(Color.GREEN);
        if(curView!=null)
            curView.setBackgroundColor(Color.WHITE);
        curView=view;
    }
}