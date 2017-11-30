package com.asi.kursasiandek;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asi.kursasiandek.Model.Item;
import com.asi.kursasiandek.Model.StackQuestions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import java.util.Stack;
import java.util.Vector;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> {

    private StackQuestions stackQuestions;
    private RequestManager glide;

    ItemAdapter(StackQuestions stackQuestions, RequestManager glide){
        this.stackQuestions = stackQuestions;
        this.glide = glide;
    }

    @Override
    public ItemAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ItemAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.Holder holder, int position) {
        Item item = stackQuestions.getItems().get(position);

        glide.load(item.getOwner().getProfileImage())
                .apply(new RequestOptions()
                        .fitCenter()
                        .placeholder(R.mipmap.ic_launcher_round))
                .into(holder.image);

        holder.title.setText(item.getTitle());
        holder.message.setText(item.getOwner().getDisplayName());
    }

    @Override
    public int getItemCount() {
        return stackQuestions.getItems().size();
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
