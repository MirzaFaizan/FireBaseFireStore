package com.developmethis.partyflashlight.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;

import java.util.List;

/**
 * Created by Faizan Ejaz on 2/5/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

private Context context;
private List<item> itemList;

    public ItemAdapter(Context context, List<item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.listcard,null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        item Item = itemList.get(position);

        holder.nam.setText(Item.getIname());
        holder.size.setText(Item.getIsize());
        holder.desc.setText(Item.getIdesc());
        holder.price.setText(String.valueOf(Item.getIprice()));
        holder.no.setText(String.valueOf(Item.getIno()));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView nam,no,desc,price,size;
        public ItemViewHolder(View itemView) {
            super(itemView);

            nam=itemView.findViewById(R.id.name);
            no=itemView.findViewById(R.id.itemno);
            price=itemView.findViewById(R.id.price);
            desc=itemView.findViewById(R.id.desc);
            size=itemView.findViewById(R.id.size);

        }
    }
}
