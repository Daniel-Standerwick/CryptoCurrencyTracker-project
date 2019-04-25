package com.example.cryptocurrencytracker;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private Button Search;
    private EditText Symbol;
    private Resources res;
    public static String[] dataToDisplay;
    public static String[][] organizedData;
    public static RecyclerView returnView;
    public static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String id;
    private String symbol;
    private String name;
    private String image;
    private String currentPrice;
    private String marketCap;
    private String marketCapRank;
    private String high24h;
    private String low24h;
    private String priceChange24h;
    private String priceChangePercentage24h;
    private String marketCapChange24h;
    private String marketCapChangePercentage24h;
    private String circulatingSupply;
    private String totalSupply;
    private String ath;
    private String athChangePercentage;
    private String athDate;
    private String roi;
    private String lastUpdated;


    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        res = getResources ();
        Search = (Button) findViewById (R.id.search_button);
        Symbol = (EditText) findViewById (R.id.SymbolEditText);
        dataToDisplay = res.getStringArray (R.array.CryptoData);
        returnView = (RecyclerView) findViewById (R.id.ReturnView);

        returnView.setHasFixedSize (false);
        layoutManager = new LinearLayoutManager (this);
        returnView.setLayoutManager (layoutManager);
        //dataToDisplay = loadArray (dataToDisplay);

        AsyncJsonParsing data = new AsyncJsonParsing ();
        data.execute ();
        Search.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                dataToDisplay = loadArray (dataToDisplay);
                setmAdapter ();

            }
        });



    }

    public static void setmAdapter(){
        mAdapter = new MyAdapter(dataToDisplay);
        returnView.setAdapter (mAdapter);
    }

    public String[] loadArray(String[] data)
    {
        String[] toReturn;
        String[] arrayToLoad;

        id = (String) getString (R.string.id);
        symbol = (String) getString (R.string.symbol);
        name = (String) getString (R.string.name);
        image = (String) getString (R.string.image);
        currentPrice = (String) getString (R.string.current_price);
        marketCap = (String) getString (R.string.market_cap);
        marketCapRank = (String) getString (R.string.market_cap_rank);
        high24h = (String) getString (R.string.high_24h);
        low24h = (String) getString (R.string.low_24h);
        priceChange24h = (String) getString (R.string.price_change_24h);
        priceChangePercentage24h = (String) getString (R.string.price_change_percentage_24h);
        marketCapChange24h = (String) getString (R.string.market_cap_change_24h);
        marketCapChangePercentage24h = (String) getString (R.string.market_cap_change_percentage_24h);
        circulatingSupply = (String) getString (R.string.circulating_supply);
        totalSupply = (String) getString (R.string.total_supply);
        ath = (String) getString (R.string.ath);
        athChangePercentage = (String) getString (R.string.ath_change_percentage);
        athDate = (String) getString (R.string.ath_date);
        roi = (String) getString (R.string.roi);
        lastUpdated = (String) getString (R.string.last_updated);

        arrayToLoad = new String[]{id, symbol, image, currentPrice, marketCap, marketCapRank, high24h, low24h,
                               priceChange24h, priceChangePercentage24h, marketCapChange24h,
                               marketCapChangePercentage24h, circulatingSupply, totalSupply,
                               ath, athChangePercentage, athDate, roi, lastUpdated};


        organizedData = new String[data.length][arrayToLoad.length];
        toReturn = new String[data.length];
        String coinInfo;
        for(int i = 0; i < data.length; i++)
        {
            coinInfo = data[i];
            for(int j = 0; j < arrayToLoad.length; j++)
            {
                int end;
                if (coinInfo.contains (",")){
                    end = coinInfo.indexOf (",");
                    organizedData[i][j] = arrayToLoad[j] + " " +
                            coinInfo.substring (0, (end));
                    coinInfo = coinInfo.substring (end+1);

                    toReturn[i] += organizedData [i][j] + "\n";

                } else {organizedData[i][j] = coinInfo;}
            }
        }


        return toReturn;
    }




}
