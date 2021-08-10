package com.example.group_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.MyViewHolder> {

    Context context;
    ArrayList SubName, SubDate, SubPrice, SubType;

    DisplayAdapter(Context context, ArrayList SubName, ArrayList SubDate, ArrayList SubPrice, ArrayList SubType){
        this.context = context;
        this.SubName = SubName;
        this.SubDate = SubDate;
        this.SubPrice = SubPrice;
        this.SubType = SubType;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_row, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        holder.name.setText(String.valueOf(SubName.get(position)));
        holder.date.setText(String.valueOf(SubDate.get(position)));
        holder.price.setText(String.valueOf(SubPrice.get(position)));
        holder.type.setText(String.valueOf(SubType.get(position)));

    }

    @Override
    public int getItemCount(){
        return SubName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, date, price, type;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.RowName);
            date = itemView.findViewById(R.id.RowDate);
            price= itemView.findViewById(R.id.RowPrice);
            type = itemView.findViewById(R.id.RowType);
        }

    }


}
