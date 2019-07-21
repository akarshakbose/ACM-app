package com.example.myfirstapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Quiz extends AppCompatActivity {
Spinner a,b,c,d;
String e,f,g,h;
Button i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        a=(Spinner)findViewById(R.id.issue);
        b=(Spinner)findViewById(R.id.issue1);
        c=(Spinner)findViewById(R.id.issue2);
        d=(Spinner)findViewById(R.id.issue3);
        i=(Button)findViewById(R.id.button3);
        String[] option={"1906","1932","1910","1921"};
        String[] option1={"Rajendra prasad","Pranav Mukherjee","A.B.Vajpayee","APJ Abdul Kalam"};
        String[] option2={"Nile","Ganaga","Brahmaputra"};
        String[] option3={"Mount Everest","Kanchejunga","Mount isa"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,option);
        a.setAdapter(adapter);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,option1);
        b.setAdapter(adapter1);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,option2);
        c.setAdapter(adapter2);
        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,option3);
        d.setAdapter(adapter3);
       a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                e=parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                f=parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                g=parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        d.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                h=parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter=0;
                if(e.equals("1906"))
                    counter++;
                if(f.equals("A.B.Vajpayee"))
                    counter++;
                if(g.equals("Nile"))
                    counter++;
                if(h.equals("Mount Everest"))
                    counter++;
                showMessage("Marks",Integer.toString(counter));
            }
        });
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
