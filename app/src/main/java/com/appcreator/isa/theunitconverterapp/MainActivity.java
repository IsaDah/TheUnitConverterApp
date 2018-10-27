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


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitsdistance,R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        Spinner from = (Spinner)findViewById(R.id.spinner_from);
        Spinner to = (Spinner)findViewById(R.id.spinner_to);

        from.setAdapter(adapter);
        to.setAdapter(adapter);

    }

    public void goBackMainMenu (View view)
    {
        Button btn = (Button)findViewById(R.id.back);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, MainMenu.class));
            }
        });
    }

    public void convert(View view)
    {
        Button check =  (Button) findViewById(R.id.button_convert);
        check.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Spinner fromSpinner, toSpinner;
                EditText  toEditText;
                toEditText = (EditText) findViewById(R.id.editText_to);
                EditText fromEditText = (EditText) findViewById(R.id.editText_from);;


                fromSpinner = (Spinner) findViewById(R.id.spinner_from);
                toSpinner = (Spinner) findViewById(R.id.spinner_to);
                String fromString = (String) fromSpinner.getSelectedItem();
                String toString = (String) toSpinner.getSelectedItem();

                Converter.UnitsDistance fromUnit = Converter.UnitsDistance.fromString(fromString);
                Converter.UnitsDistance toUnit = Converter.UnitsDistance.fromString(toString);

                Converter converter = new Converter(fromUnit, toUnit);


                String str = fromEditText.getText().toString().trim();
                boolean valid = true;
                double val = 0;

                try {
                    val = Double.parseDouble(str);
                }
                catch(NumberFormatException e)
                {
                    valid = false;
                }

                if( valid )
                {
                    // use the number
                    if (fromEditText.getText().toString().trim().length() > 0 )
                    {
                        double input = Double.valueOf(fromEditText.getText().toString().trim());
                        double result = converter.convert(input);
                        toEditText.setText(String.valueOf(result));
                    }
                }
                else
                    {
                    // handle invalid entry
                        Toast.makeText(MainActivity.this, "Input is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}