package com.example.myfirstapp;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Menu extends ListActivity {
    String classes[]={"ENTER","GAMING ZONE","QUIZ","BOOKING","ENTERTAINMENT","CALCULATOR","SNAKE GAME","CHAT APP"};
   DatabaseReference data;
    int total=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_dropdown_item_1line,classes));

    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String click=classes[position];
        switch (click){
            case "ENTER":
                Intent i=new Intent(Menu.this,MainActivity.class);
                startActivity(i);
                break;
            case "GAMING ZONE":
                Intent j=new Intent(Menu.this,Gaming.class);
                startActivity(j);
                break;
            case "QUIZ":
                Intent k=new Intent(Menu.this,Quiz.class);
                startActivity(k);
                break;
            case "BOOKING":
                Intent m=new Intent(Menu.this,Booking.class);
                startActivity(m);
                break;
            case "ENTERTAINMENT":
                Intent p=new Intent();
                p.setAction(Intent.ACTION_VIEW);
                p.addCategory(Intent.CATEGORY_BROWSABLE);
                p.setData(Uri.parse("https://www.youtube.com"));
                startActivity(p);
                break;

            case "CALCULATOR":
                Intent y=new Intent(Menu.this,cal.class);
                startActivity(y);
                break;
            case "SNAKE GAME":
                Intent z=new Intent(Menu.this, SnakeActivity.class);
                startActivity(z);
                break;
            case "CHAT APP":
                showAler();
        }
    }

    private void showAler() {
        AlertDialog.Builder builder=new AlertDialog.Builder(Menu.this);
        builder.setTitle("ENTER PHONE NO:");
        final EditText phone=new EditText(Menu.this);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        phone.setLayoutParams(lp);
        builder.setView(phone);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            data= FirebaseDatabase.getInstance().getReference("phone");
            data.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                        total= (int) dataSnapshot.getChildrenCount();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            data.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(phone.length()==10)
                    {
                        Phone Ph=new Phone(phone.getText().toString());
                        data.child(Integer.toString(total+1)).setValue(Ph);
                        Common.currentphone=Ph.getPhone();
                        Intent i=new Intent(Menu.this,ChatActivity1.class);
                        startActivity(i);
                    }
                    else Toast.makeText(Menu.this,"ENTER VALID PHONE",Toast.LENGTH_LONG).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            }
        });
        builder.setNegativeButton("ALREADY REGISTERED", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showD();
            }
        });
        builder.show();


    }
    private void showD() {
        AlertDialog.Builder builder=new AlertDialog.Builder(Menu.this);
        builder.setTitle("ENTER PHONE NO:");
        final EditText phone=new EditText(Menu.this);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        phone.setLayoutParams(lp);
        builder.setView(phone);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                data= FirebaseDatabase.getInstance().getReference("phone");
                data.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int num=0;
                        for(DataSnapshot ds:dataSnapshot.getChildren())
                        {
                            String pho=ds.child("phone").getValue(String.class);
                            if(pho.equals(phone.getText().toString()))
                            { Phone Ph=new Phone(phone.getText().toString());

                                Intent i=new Intent(Menu.this,ChatActivity1.class);
                                Common.currentphone=Ph.getPhone();
                                startActivity(i);
                                num++;

                                break;
                            }


                        }
                        if(num==0)
                            Toast.makeText(Menu.this,"NOT REGISTERED",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();


    }


}
