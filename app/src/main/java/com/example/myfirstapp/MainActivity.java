package com.example.myfirstapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText a;
    TextView b;
    Button c;
    ToggleButton d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=(EditText)findViewById(R.id.a);
        b=(TextView)findViewById(R.id.d);
        c=(Button)findViewById(R.id.b);
        d=(ToggleButton)findViewById(R.id.c);
        final Random random=new Random();
       d.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(d.isChecked())
                   a.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
               else
                   a.setInputType(InputType.TYPE_CLASS_TEXT);
           }
       });
        Toast.makeText(MainActivity.this,"ENTER SOME ALPHABET!\nSEE SOMETHING!",Toast.LENGTH_SHORT).show();
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (a.getText().toString())
                {
                    case "a":
                    case "A":b.setText(a.getText().toString());
                        b.setGravity(Gravity.LEFT);
                        b.setTextSize(random.nextInt(265));
                    b.setTextColor(Color.rgb(random.nextInt(265),random.nextInt(265),random.nextInt(265)));
                break;
                    case "b":
                    case "B":b.setText(a.getText().toString());
                        b.setGravity(Gravity.CENTER);
                        b.setTextSize(random.nextInt(265));
                        b.setTextColor(Color.rgb(random.nextInt(265),random.nextInt(265),random.nextInt(265)));
                        break;
                    case "C":
                    case "c":b.setText(a.getText().toString());
                        b.setGravity(Gravity.RIGHT);
                        b.setTextSize(random.nextInt(265));
                        b.setTextColor(Color.rgb(random.nextInt(265),random.nextInt(265),random.nextInt(265)));
                        break;
                    case "D":
                    case "d":b.setText(a.getText().toString());
                        b.setGravity(Gravity.LEFT);
                        b.setTextSize(random.nextInt(265));
                        b.setTextColor(Color.rgb(random.nextInt(265),random.nextInt(265),random.nextInt(265)));
                        break;
                    case "E":
                    case "e":b.setText(a.getText().toString());
                        b.setGravity(Gravity.CENTER);
                        b.setTextSize(random.nextInt(265));
                        b.setTextColor(Color.rgb(random.nextInt(265),random.nextInt(265),random.nextInt(265)));
                        break;
                    case "F":
                    case "f":b.setText(a.getText().toString());
                        b.setGravity(Gravity.RIGHT);
                        b.setTextSize(random.nextInt(265));
                        b.setTextColor(Color.rgb(random.nextInt(265),random.nextInt(265),random.nextInt(265)));
                        break;
                    case "G":
                    case "g":
                        b.setText(a.getText().toString());
                        b.setGravity(Gravity.LEFT);
                        b.setTextSize(random.nextInt(265));
                        b.setTextColor(Color.rgb(random.nextInt(265),random.nextInt(265),random.nextInt(265)));
                        break;
                    case "H":
                    case "h":b.setText(a.getText().toString());
                        b.setGravity(Gravity.CENTER);
                        b.setTextSize(random.nextInt(265));
                        b.setTextColor(Color.rgb(random.nextInt(265),random.nextInt(265),random.nextInt(265)));
                        break;
                        default:b.setText(a.getText().toString());
                            b.setGravity(Gravity.RIGHT);
                            b.setTextSize(random.nextInt(265));
                            b.setTextColor(Color.rgb(random.nextInt(265),random.nextInt(265),random.nextInt(265)));
                            break;
                }
            }
        });
    }
}
