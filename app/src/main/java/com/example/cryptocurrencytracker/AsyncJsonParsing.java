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
import static com.example.cryptocurrencytracker.MainActivity.returnView;

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
            for (int i = 0; i < jsonArray.length (); i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject (i);
                String id = jsonObject1.getString ("id");
                toReturn[i] = id;
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
