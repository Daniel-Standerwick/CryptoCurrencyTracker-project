package com.example.cryptocurrencytracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyViewHolder(View v) {
            super (v);
            textView = v.findViewById (R.id.itemView);
        }

        public TextView getTextView() {
            return textView;
        }

    }
    public MyAdapter(String[] myDataset){
      mDataset = myDataset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext ())
                .inflate (R.layout.textviewsingle, viewGroup, false);

        return new MyViewHolder (v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.textView.setText (mDataset[i]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
