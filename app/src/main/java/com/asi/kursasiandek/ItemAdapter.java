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
import com.asi.kursasiandek.databinding.CardItemBinding;
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
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CardItemBinding cardItemBinding = CardItemBinding.inflate(layoutInflater, parent, false);
        return new ItemAdapter.Holder(cardItemBinding);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.Holder holder, int position) {
        Item item = stackQuestions.getItems().get(position);
        holder.bind(item);

        glide.load(item.getOwner().getProfileImage())
                .apply(new RequestOptions()
                        .fitCenter()
                        .placeholder(R.mipmap.ic_launcher_round))
                .into(holder.binding.itemImage);

        holder.binding.itemImage.setOnClickListener(view -> openWebsite(item.getLink()));
        holder.binding.itemTitle.setOnClickListener(view -> openItemDialog(item.getTitle(), item.toString()));
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
        private final CardItemBinding binding;

        public Holder(CardItemBinding cardItemBinding) {
            super(cardItemBinding.getRoot());
            this.binding = cardItemBinding;
        }

        private void bind(Item item){
            binding.setItem(item);
            binding.executePendingBindings();
        }
    }
}
