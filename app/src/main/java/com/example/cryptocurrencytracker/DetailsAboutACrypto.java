package com.example.cryptocurrencytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.jar.Attributes;

public class DetailsAboutACrypto extends AppCompatActivity {

    TextView Viewname;
    TextView ViewCurrentPrice;
    TextView ViewHigh24h;
    TextView Viewath;
    TextView ViewAthDate;
    TextView Viewroi;
    TextView ViewlastUpdated;
    TextView Viewlow24h;
    TextView ViewPriceChange24h;
    TextView ViewTotalSupply;
    TextView ViewMarketCap;
    TextView ViewMarketCapRank;
    TextView ViewMarketCapChange;

    Button Return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_details_about_acrypto);

        Intent intent = getIntent ();
        String name = intent.getStringExtra ("name");
        String currentPrice = intent.getStringExtra ("currentPrice");
        String high24h = intent.getStringExtra ("high24h");
        String ath = intent.getStringExtra("ath");
        String artdate = intent.getStringExtra("artdate");
        String roi = intent.getStringExtra ("roi");
        String lastUpdated = intent.getStringExtra ("lastUpdated");
        String low24h = intent.getStringExtra ("low24h");
        String priceChange24h = intent.getStringExtra ("priceChange24h");
        String totalSupply = intent.getStringExtra ("totalSupply");
        String marketCap = intent.getStringExtra ("marketCap");
        String marketCapRank = intent.getStringExtra ("marketCapRank");
        String marketCapChange24h = intent.getStringExtra ("marketCapChange24h");

        Viewname = (TextView) findViewById (R.id.name);
        ViewCurrentPrice = (TextView) findViewById (R.id.currentPrice);
        ViewHigh24h = (TextView) findViewById (R.id.high24h);
        Viewath = (TextView) findViewById (R.id.ath);
        ViewAthDate = (TextView) findViewById (R.id.athdate);
        Viewroi = (TextView) findViewById (R.id.roi);
        ViewlastUpdated = (TextView) findViewById (R.id.lastUpdated);
        Viewlow24h = (TextView) findViewById (R.id.low24h);
        ViewPriceChange24h = (TextView) findViewById (R.id.priceChange24h);
        ViewTotalSupply =(TextView) findViewById (R.id.totalSupply);
        ViewMarketCap = (TextView) findViewById (R.id.marketCap);
        ViewMarketCapRank = (TextView) findViewById (R.id.marketCapRank);
        ViewMarketCapChange = (TextView) findViewById (R.id.marketCapChange24h);

        Viewname.setText (name);
        ViewCurrentPrice.setText (currentPrice);
        ViewHigh24h.setText (high24h);
        Viewath.setText (ath);
        ViewAthDate.setText (artdate);
        Viewroi.setText (roi);
        ViewlastUpdated.setText (lastUpdated);
        Viewlow24h.setText (low24h);
        ViewPriceChange24h.setText (priceChange24h);
        ViewTotalSupply.setText (totalSupply);
        ViewMarketCap.setText (marketCap);
        ViewMarketCapRank.setText (marketCapRank);
        ViewMarketCapChange.setText (marketCapChange24h);

        Return = (Button) findViewById (R.id.MenuButton);

        Return.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent returnToMenu;
                returnToMenu = new Intent (getApplicationContext (), MainActivity.class);
                startActivity(returnToMenu);
            }
        });



    }

}
