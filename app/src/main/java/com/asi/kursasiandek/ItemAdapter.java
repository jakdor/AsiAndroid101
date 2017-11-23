package com.asi.kursasiandek;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import java.util.Vector;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> {

    private Vector<CardItem> cardItems;
    private RequestManager glide;

    ItemAdapter(Vector<CardItem> cardItems, RequestManager glide){
        this.cardItems = cardItems;
        this.glide = glide;
    }

    @Override
    public ItemAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ItemAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.Holder holder, int position) {
        CardItem cardItem = cardItems.get(position);

        glide.load(cardItem.getImageUrl())
                .apply(new RequestOptions()
                        .fitCenter()
                        .placeholder(R.mipmap.ic_launcher_round))
                .into(holder.image);

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
