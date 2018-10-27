package com.appcreator.isa.theunitconverterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;

import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityTemperature extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_temp);

    }
    private double c2f(double c)
    {
        return (c*9)/5+32;
    }
    //Fahrenhiet to Celcius method
    private double f2c(double f)
    {
        return (f-32)*5/9;
    }
    public void add(View v)
    {

        Button check =  (Button) findViewById(R.id.button1);
        check.setOnClickListener(new OnClickListener() {


                                     @Override
                                     public void onClick(View v) {

                                         EditText result = (EditText) findViewById(R.id.editText_result);

                                         EditText et1 = (EditText) findViewById(R.id.editText1);

                                         RadioButton cb = (RadioButton) findViewById(R.id.cb);
                                         RadioButton fb = (RadioButton) findViewById(R.id.fb);

                                         String str = et1.getText().toString().trim();
                                         boolean valid = true;
                                         double val = 0;

                                         try {
                                             val = Double.parseDouble(str);
                                         } catch (NumberFormatException e) {
                                             valid = false;
                                         }
                                         if (valid) {
                                             // use the number
                                             if (et1.getText().toString().trim().length() > 0) {
                                                 if (cb.isChecked())
                                                 {
                                                     double a = Double.parseDouble(String.valueOf(et1.getText()));
                                                     result.setText(f2c(a) + " degree C");
                                                     fb.setChecked(true);

                                                 }   else if (fb.isChecked())
                                                 {
                                                     double a = Double.parseDouble(String.valueOf(et1.getText()));
                                                     result.setText(c2f(a) + " degree F");
                                                     //fb.setChecked(false);
                                                     cb.setChecked(true);
                                                 }
                                             }


                                         } else {
                                             Toast.makeText(MainActivityTemperature.this, "Input is invalid", Toast.LENGTH_SHORT).show();
                                         }

                                     }
                                 });
    }
    public void goBackMainMenu (View view)
    {
        Button btn = (Button)findViewById(R.id.back);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivityTemperature.this, MainMenu.class));
            }
        });
    }
}




