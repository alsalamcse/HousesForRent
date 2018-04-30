package com.awad.adam.housesforrent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class interyourinfo extends AppCompatActivity implements View.OnClickListener{

    private EditText etCity;
    private EditText etCost;
    private EditText etpeople;
    private Button btnAddTorentTist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interyourinfo);

        etCity=(EditText)findViewById(R.id.etcity);
        etCost=(EditText)findViewById(R.id.etcost);
        etpeople=(EditText)findViewById(R.id.etpeople);
        btnAddTorentTist=(Button)findViewById(R.id.btnAddTorentTist);

    }


    @Override
    public void onClick(View view)
    {
        if (btnAddTorentTist==view)
        {
            Intent i = new Intent(this,MainActivityHouse .class);
            startActivity(i);
        }

    }
}