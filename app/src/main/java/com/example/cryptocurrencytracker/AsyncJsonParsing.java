package com.example.cryptocurrencytracker;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.cryptocurrencytracker.MainActivity.dataToDisplay;

public class AsyncJsonParsing extends AsyncTask<Void, Void, Void> {
    private static final String Host_URL = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false\n";
    private String bufferdata = "";
    private String[] toReturn;


    @Override
    protected Void doInBackground(Void... voids) {

        URL url = null;
        try {
            url = new URL(Host_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection ();
            httpURLConnection.setRequestMethod ("GET");
            httpURLConnection.connect ();
            InputStream inputStream = httpURLConnection.getInputStream ();
            BufferedReader bufferedReader = new BufferedReader (new InputStreamReader ((inputStream)));
            String line = "";
            while (line != null){
                line = bufferedReader.readLine ();
                bufferdata = bufferdata+line;
            }
            JSONArray jsonArray = new JSONArray (bufferdata);
            String[] toReturn = new String[jsonArray.length ()];
            int j = 0;
            for (int i = 0; i < jsonArray.length (); i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject (i);
                String id = jsonObject1.getString ("id");
                toReturn[i] = id;
                String symbol = jsonObject1.getString ("symbol");
                toReturn[i] += "," + symbol;
                String name = jsonObject1.getString ("name");
                toReturn[i] += "," + name;
                String image = jsonObject1.getString ("image");
                toReturn[i] += "," + image;
                String current_price = jsonObject1.getString ("current_price");
                toReturn[i] += "," + current_price;
                String market_cap = jsonObject1.getString ("market_cap");
                toReturn[i] += "," + market_cap;
                String market_cap_rank = jsonObject1.getString ("market_cap_rank");
                toReturn[i] += "," + market_cap_rank;
                String total_volume = jsonObject1.getString ("total_volume");
                toReturn[i] += "," + total_volume;
                String high_24h = jsonObject1.getString ("high_24h");
                toReturn[i] += "," + high_24h;
                String low_24h = jsonObject1.getString ("low_24h");
                toReturn[i] += "," + low_24h;
                String price_change_24h = jsonObject1.getString ("price_change_24h");
                toReturn[i] += "," + price_change_24h;
                String price_change_percentage_24h = jsonObject1.getString ("price_change_percentage_24h");
                toReturn[i] += "," + price_change_percentage_24h;
                String market_cap_change_24h = jsonObject1.getString ("market_cap_change_24h");
                toReturn[i] += "," + market_cap_change_24h;
                String market_cap_change_percentage_24h = jsonObject1.getString ("market_cap_change_percentage_24h");
                toReturn[i] += "," + market_cap_change_percentage_24h;
                String circulating_supply = jsonObject1.getString ("circulating_supply");
                toReturn[i] += "," + circulating_supply;
                String total_supply = jsonObject1.getString ("total_supply");
                toReturn[i] += "," + total_supply;
                String ath = jsonObject1.getString ("ath");
                toReturn[i] += "," + ath;
                String ath_change_percentage = jsonObject1.getString ("ath_change_percentage");
                toReturn[i] += "," + ath_change_percentage;
                String ath_date = jsonObject1.getString ("ath_date");
                toReturn[i] += "," + ath_date;
                String roi = jsonObject1.getString ("roi");
                toReturn[i] += "," + roi;
                String last_updated = jsonObject1.getString ("last_updated");
                toReturn[i] += "," + last_updated;



                bufferedReader.close ();
                dataToDisplay = toReturn;
            }
        } catch (IOException e) {
            e.printStackTrace ( );
        } catch (JSONException e) {
            e.printStackTrace ( );
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute (aVoid);
        MainActivity.setmAdapter ();
    }
}
