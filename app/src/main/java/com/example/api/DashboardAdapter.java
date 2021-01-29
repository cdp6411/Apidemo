package com.example.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.MyviewHolder> {

    private Context context;
    private User[] namelist;
         public DashboardAdapter(Context context, User[] namelist){
                this.context = context;
                this.namelist = namelist;
        }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_model,parent,false);
            return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
            final User item =namelist[position];
            holder.name.setText(item.getName());
            holder.email.setText(item.getEmail());
            holder.mobile.setText(item.getPhone());
        Glide.with(context)
                .load(item.getPicture())
                .into(holder.imageview);
    }

    @Override
    public int getItemCount() {
        return namelist.length;
    }



    public  class MyviewHolder extends RecyclerView.ViewHolder{
            private ImageView imageview;
            private TextView name,email,mobile;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            imageview=itemView.findViewById(R.id.imageview);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            mobile=itemView.findViewById(R.id.mobile);

        }
    }
}
