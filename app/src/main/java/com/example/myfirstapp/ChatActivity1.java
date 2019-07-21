package com.example.myfirstapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.ListActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChatActivity1 extends AppCompatActivity {
    ListView simpleList;
    ArrayList<String> arr;
    DatabaseReference data,data1,data2;
    int counter=0,num1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat1);
        simpleList = (ListView)findViewById(R.id.simpleListView);
        arr=new ArrayList<String>();
        data= FirebaseDatabase.getInstance().getReference("phone");
        data1=FirebaseDatabase.getInstance().getReference("chat");
        data2=FirebaseDatabase.getInstance().getReference("chatroom");
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    arr.add(ds.child("phone").getValue(String.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.textView, arr);
        simpleList.setAdapter(arrayAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {String click= arr.get(position);
                Phone ph2=new Phone(click);
                Common.friend=ph2.getPhone();
                data1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists())
                        {
                            counter= (int) dataSnapshot.getChildrenCount();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
data1.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot ds:dataSnapshot.getChildren())
        {
            if((Common.currentphone.equals(ds.child("number1").getValue().toString())&&Common.friend.equals(ds.child("number2").getValue().toString()))||(Common.friend.equals(ds.child("number1").getValue().toString())&&Common.currentphone.equals(ds.child("number2").getValue().toString()))){
                num1++;
                Common.id=Integer.toString(num1);
            }

        }
        if(num1==0)
        {
            chat chat=new chat(Common.currentphone,Common.friend);
            data1.child(Integer.toString(counter+1)).setValue(chat);
            chat_room chat_room=new chat_room("WELCOME");
            data2.child(Integer.toString(counter+1)).setValue(chat_room);
            Common.id=Integer.toString(counter+1);
        }
        Intent i=new Intent(ChatActivity1.this,ChatRoom.class);
        startActivity(i);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});

            }
        });

    }
}
