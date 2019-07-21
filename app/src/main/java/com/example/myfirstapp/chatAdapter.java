package com.example.myfirstapp;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.chatHolder> {
    private ArrayList<String> data;
    public chatAdapter(ArrayList<String> data) {
        this.data=data;
    }

    @NonNull
    @Override
    public chatHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.chatlayout,viewGroup,false);
        return new chatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chatHolder chatHolder, int i) {
String title= data.get(i);
chatHolder.txt.setText(title);
chatHolder.setItemClickListener(new itemClickListener() {
    @Override
    public void onClick(View view, int position, boolean isLongClick) {
        Toast.makeText(view.getContext(),data.get(position),Toast.LENGTH_SHORT).show();
    }
});
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class chatHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        TextView txt;
        private itemClickListener itemClickListener;
        public chatHolder(@NonNull View itemView) {

            super(itemView);
            txt=itemView.findViewById(R.id.txt);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }
        public void setItemClickListener(itemClickListener itemClickListener){
            this.itemClickListener=itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true);
            return true;
        }
    }
}
