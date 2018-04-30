package com.awad.adam.housesforrent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class message extends AppCompatActivity {
    private TextView etSam;
    private TextView etMax;
    private TextView etLinda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        etSam=(TextView)findViewById(R.id.etSam);
        etMax=(TextView)findViewById(R.id.etMax);
        etLinda=(TextView)findViewById(R.id.etLinda);




    }
}
