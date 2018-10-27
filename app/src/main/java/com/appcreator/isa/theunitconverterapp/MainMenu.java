package com.appcreator.isa.theunitconverterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainMenu extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void goToLength (View view)

    {
        Button btn = (Button)findViewById(R.id.distances);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainMenu.this, MainActivity.class));
            }
        });
    }

    public void goToTemp (View view)

    {
        Button btn = (Button)findViewById(R.id.temperature);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainMenu.this, MainActivityTemperature.class));
            }
        });
    }

    public void goToFrequency (View view)

    {
        Button btn = (Button)findViewById(R.id.frequency);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainMenu.this, MainActivityFrequency.class));
            }
        });
    }

    public void goToDataRate (View view)

    {
        Button btn = (Button)findViewById(R.id.datarate);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainMenu.this, MainActivityDatarate.class));
            }
        });
    }



}
