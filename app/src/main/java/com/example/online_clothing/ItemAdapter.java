package com.example.online_clothing;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    List<ItemModel> itemModeList;
    Context context;

    public ItemAdapter(List<ItemModel> itemModeList, Context context) {
        this.itemModeList = itemModeList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemview,viewGroup,false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        final ItemModel itemModel= itemModeList.get(i);

        itemViewHolder.itemimageview.setImageResource(itemModel.getImagename());
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ViewItems.class);
                intent.putExtra("itemname",itemModel.getItemname());
                intent.putExtra("itemprice",itemModel.getPrice());
                intent.putExtra("itemdescription",itemModel.getDescription());
                intent.putExtra("image",itemModel.getImagename());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemModeList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView itemimageview;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemimageview=itemView.findViewById(R.id.imagecard);

        }
    }
}
