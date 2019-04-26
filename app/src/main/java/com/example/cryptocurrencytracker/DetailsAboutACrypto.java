package com.example.cryptocurrencytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.jar.Attributes;

public class DetailsAboutACrypto extends AppCompatActivity {

    TextView Viewname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_details_about_acrypto);

        Intent intent = getIntent ();
        String name = intent.getStringExtra ("name");


        Viewname = (TextView) findViewById (R.id.name);
        Viewname.setText (name);


    }

}
