package com.example.lab10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.core.content.ContextCompat;

public class ColorsAdapter extends BaseAdapter {
    private String[] names; // массив строк для вывода в элементы

    ColorsAdapter(String[] names) {
        this.names=names;
    }

    @Override
    public int getCount() {
        return names.length;  //возвращаем длину массива строк
    }

    @Override
    public Object getItem(int position) {
        return names[position]; //возвращаем элемент списка по его позиции в списке, в нашем случае
        //элементом списка является строка
    }

    @Override
    public long getItemId(int position) {
        return position; //возвращаем идентификатор элемента списка, в данном случае считаем, что
        //идентификатор совпадает с позицией элемента
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_items, parent, false);
        }
        TextView textView = (TextView) convertView; //преобразуем класс объекта – элемента разметки к TextView
        textView.setText(names[position]);  //в элемент, находящийся в списке на позиции position, помещаем
                                            //текст из элемента массива строк с индексом position
                                            //устанавливаем цвет в зависимости от position
        if (position % 2 == 0 )
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.color1));
        else
        if (position % 2 == 1 )
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.color2));
        else
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.color3));
        return convertView;
    }
}
