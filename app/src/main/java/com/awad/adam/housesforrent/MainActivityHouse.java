package com.awad.adam.housesforrent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.awad.adam.housesforrent.data.Product;
import com.awad.adam.housesforrent.data.ProductAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.widget.AdapterView.*;

public class MainActivityHouse extends AppCompatActivity implements AdapterView.OnClickListener {

    private Button RentPartment;
    private FirebaseAuth Auth;
    private FirebaseUser user;
    private Button RentYourHouse;
    private ListView list;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_house);
        productAdapter=new ProductAdapter(this,R.layout.prodcut_item);
        RentPartment=(Button)findViewById(R.id.btnRentHouse);
        RentYourHouse=(Button)findViewById(R.id.btnRentYourHouse);
        list=(ListView)findViewById(R.id.list);
        Auth=FirebaseAuth.getInstance();
        user=Auth.getCurrentUser();
        readAndListen();


    }
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.AddItem:
                Intent i = new Intent(this, AddItemActivity.class);
                startActivity(i);
                break;
        }
        return true;
    }

    private void readAndListen() {

        FirebaseUser user = Auth.getCurrentUser();
        String email = user.getEmail();
        email = email.replace('.', '*');
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("mylist").orderByChild("email").equalTo(email).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                productAdapter.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Product p = ds.getValue(Product.class);
                    Log.d("SL", p.toString());
                    productAdapter.add(p);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

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
            Intent intent1=new Intent(this,interyourinfo.class);
            startActivity(intent1);


        }

    }
}
