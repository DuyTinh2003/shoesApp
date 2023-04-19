package com.example.shoesapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shoesapp.R;
import com.example.shoesapp.model.Shoe;

import java.util.ArrayList;

public class PopularShoeAdapter extends RecyclerView.Adapter<PopularShoeAdapter.ViewHolder> {
    private  ArrayList<Shoe> listPro;
    private Context context;

    public PopularShoeAdapter(Context context,ArrayList<Shoe> listPro) {
        this.listPro = listPro;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_card_shoe,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(listPro.get(position).getName());
        Glide.with(context).load(listPro.get(position).getImage()).into(holder.img);
        holder.price.setText(listPro.get(position).getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return listPro.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView img;
        TextView price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_shoe);
            img = itemView.findViewById(R.id.imgShoe);
            price = itemView.findViewById(R.id.price_shoe);
        }
    }
}
