package com.asi.kursasiandek;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> {

    private Vector<CardItem> cardItems;

    ItemAdapter(Vector<CardItem> cardItems){
        this.cardItems = cardItems;
    }

    @Override
    public ItemAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ItemAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.Holder holder, int position) {
        CardItem cardItem = cardItems.get(position);

        holder.title.setText(cardItem.getTitle());
        holder.message.setText(cardItem.getMessage());
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    static class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_image)
        ImageView image;
        @BindView(R.id.item_title)
        TextView title;
        @BindView(R.id.item_message)
        TextView message;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
