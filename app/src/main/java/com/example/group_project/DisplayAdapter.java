package com.example.group_project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.MyViewHolder> {

    private final Context context;
    Activity activity;
    private final ArrayList<String> SubId, SubName, SubDate, SubPrice, SubType;

    DisplayAdapter(Activity activity, Context context,
                   ArrayList<String> SubId,
                   ArrayList<String> SubName,
                   ArrayList<String> SubDate,
                   ArrayList<String> SubPrice,
                   ArrayList<String> SubType){
        this.activity = activity;
        this.context = context;
        this.SubId = SubId;
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
        //holder.name.setText(String.valueOf(SubId.get(position)));
        holder.name.setText(String.valueOf(SubName.get(position)));
        holder.date.setText(String.valueOf(SubDate.get(position)));
        holder.price.setText(String.valueOf(SubPrice.get(position)));
        holder.type.setText(String.valueOf(SubType.get(position)));
        holder.mainLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, UpdateActivity.class);
            intent.putExtra("id", String.valueOf(SubId.get(position)));
            intent.putExtra("name", String.valueOf(SubName.get(position)));
            intent.putExtra("date", String.valueOf(SubDate.get(position)));
            intent.putExtra("price", String.valueOf(SubPrice.get(position)));
            intent.putExtra("type", String.valueOf(SubType.get(position)));
            activity.startActivityForResult(intent, 1);
        });

    }



    @Override
    public int getItemCount(){
        return SubName.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, date, price, type;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.RowName);
            date = itemView.findViewById(R.id.RowDate);
            price= itemView.findViewById(R.id.RowPrice);
            type = itemView.findViewById(R.id.RowType);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }


}
