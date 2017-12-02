package com.asi.kursasiandek;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.asi.kursasiandek.Model.Item;
import com.asi.kursasiandek.Model.StackQuestions;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> {

    private StackQuestions stackQuestions;
    private RequestManager glide;
    private Context context;

    ItemAdapter(StackQuestions stackQuestions, RequestManager glide, Context context){
        this.stackQuestions = stackQuestions;
        this.glide = glide;
        this.context = context;
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

        holder.image.setOnClickListener(view -> openWebsite(item.getLink()));

        holder.title.setOnClickListener(view -> openItemDialog(item.getTitle(), item.toString()));

        holder.title.setText(item.getTitle());
        holder.message.setText(item.getOwner().getDisplayName());
    }

    @Override
    public int getItemCount() {
        return stackQuestions.getItems().size();
    }

    private void openWebsite(String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(browserIntent);
    }

    private void openItemDialog(String title, String content){
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.stack_item_dialog);
        dialog.show();

        TextView dialogTitle = dialog.findViewById(R.id.dialog_title);
        TextView dialogContent = dialog.findViewById(R.id.dialog_content);
        dialogTitle.setText(title);
        dialogContent.setText(content);
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
