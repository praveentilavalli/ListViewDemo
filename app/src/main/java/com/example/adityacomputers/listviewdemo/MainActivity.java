package com.example.adityacomputers.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    ListView monthlistview;
    Button ascbtn,descbtn;
    String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
    ArrayAdapter<String>arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ascbtn=(Button)findViewById(R.id.ascbtn);
        descbtn=(Button)findViewById(R.id.descbtn);
        monthlistview=(ListView)findViewById(R.id.monthlv);
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.row_item,R.id.textView,months);
        monthlistview.setAdapter(arrayAdapter);
        ascbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortAscending();
                arrayAdapter.notifyDataSetChanged();
            }
        });
        descbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortDescending();
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
    public void sortDescending()
    {
        for(int i=0;i<months.length;i++)
        {
            int pos=i;
            for(int j=i+1;j<months.length;j++)
            {
                if(months[j].compareTo(months[pos])>0)
                {
                    pos=j;
                }
            }
            String temp=months[i];
            months[i]=months[pos];
            months[pos]=temp;
        }
    }
    public void sortAscending()
    {
        for(int i=0;i<months.length;i++)
        {
            int pos=i;
            for(int j=i+1;j<months.length;j++)
            {
                if(months[j].compareTo(months[pos])<0)
                {
                    pos=j;
                }
            }
            String temp=months[i];
            months[i]=months[pos];
            months[pos]=temp;
        }
    }
}
