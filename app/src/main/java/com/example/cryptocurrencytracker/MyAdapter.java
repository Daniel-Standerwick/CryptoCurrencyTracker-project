package com.example.cryptocurrencytracker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.cryptocurrencytracker.MainActivity.clickedSymbol;
import static com.example.cryptocurrencytracker.MainActivity.dataToDisplay;
import static com.example.cryptocurrencytracker.MainActivity.organizedData;
import static com.example.cryptocurrencytracker.MainActivity.rawOrganizedData;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;
    private int count = -1;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public static TextView textView;

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
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {

        View v = LayoutInflater.from(viewGroup.getContext ())
                .inflate (R.layout.textviewsingle, viewGroup, false);

        v.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                String typedSym = rawOrganizedData[count][1];
                for(int j = 0; j < dataToDisplay.length; j++) {
                    if (rawOrganizedData[count][1].equals (typedSym)) {
                        Intent symbSearch;
                        symbSearch = new Intent (MainActivity.context, DetailsAboutACrypto.class);
                        symbSearch.putExtra ("name",rawOrganizedData[count][2]);
                        symbSearch.putExtra ("currentPrice",organizedData[count][4]);
                        symbSearch.putExtra ("high24h",organizedData[count][7]);
                        symbSearch.putExtra ("ath",organizedData[count][15]);
                        symbSearch.putExtra ("athdate",organizedData[count][17]);
                        symbSearch.putExtra ("roi",organizedData[count][18]);
                        symbSearch.putExtra ("lastUpdated",organizedData[count][19]);
                        symbSearch.putExtra ("low24h",organizedData[count][8]);
                        symbSearch.putExtra ("priceChange24h",organizedData[count][9]);
                        symbSearch.putExtra ("totalSupply",organizedData[count][14]);
                        symbSearch.putExtra ("marketCap",organizedData[count][5]);
                        symbSearch.putExtra ("marketCapRank",organizedData[count][6]);
                        symbSearch.putExtra ("marketCapChange24h",organizedData[count][10]);
                        v.getContext ().startActivity(symbSearch);
                    }
                }
            }
        });
        count++;
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
