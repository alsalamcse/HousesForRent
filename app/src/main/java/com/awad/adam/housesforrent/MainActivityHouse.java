package com.awad.adam.housesforrent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityHouse extends AppCompatActivity implements View.OnClickListener {
    private Button RentPartment;
    private Button RentYourHouse;
    private Button Messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_house);

        RentPartment=(Button)findViewById(R.id.btnRentPartment);
        RentYourHouse=(Button)findViewById(R.id.btnRentYourHouse);



    }

    @Override
    public void onClick(View view)
    {
        if (RentPartment==view)
        {
            Intent intent=new Intent(this,rentapartment.class);
            startActivity(intent);
        }
        if (RentYourHouse==view)
        {
            Intent intent=new Intent(this,interyourinfo.class);


        }

    }
}
