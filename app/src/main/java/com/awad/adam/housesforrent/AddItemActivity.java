package com.awad.adam.housesforrent;

import android.app.DatePickerDialog;
import android.provider.ContactsContract;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.awad.adam.housesforrent.data.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class AddItemActivity extends AppCompatActivity {
    private EditText etName, etAmount, etPrice;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        etName = (EditText) findViewById(R.id.etName);
        etAmount = (EditText) findViewById(R.id.etAmount);
        etPrice = (EditText) findViewById(R.id.etPrice);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });

    }

    public EditText getEtName() {
        return etName;
    }

    public void setEtName(EditText etName) {
        this.etName = etName;
    }

    public EditText getEtAmount() {
        return etAmount;
    }

    public void setEtAmount(EditText etAmount) {
        this.etAmount = etAmount;
    }

    public EditText getEtPrice() {
        return etPrice;
    }

    public void setEtPrice(EditText etPrice) {
        this.etPrice = etPrice;
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }

    public void dataHandler() {

        String stName = etName.getText().toString();
        String stAmount = etAmount.getText().toString();
        String stPrice = etPrice.getText().toString();

        double amount = Double.parseDouble(stAmount);
        double price = Double.parseDouble(stPrice);

        Product p = new Product();
        p.setAmount(stAmount);
        p.setName(stName);
        p.setPrice(stPrice);


        FirebaseAuth auth = FirebaseAuth.getInstance().getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String email = user.getEmail();
        email = email.replace('.', '*');
        DatabaseReference refernce;
        refernce = FirebaseDatabase.getInstance().getReference();
        p.setEmail(email);
        String key = refernce.child("myList").push().getKey();
        p.setKeyId(key);
        refernce.child("myList").child(key).setValue(p).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(AddItemActivity.this,"Add Product Successful",Toast.LENGTH_LONG).show();
                    finish();
                }
                else
                {
                    Toast.makeText(AddItemActivity.this,"Add Product Faild",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
