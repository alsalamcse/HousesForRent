package com.awad.adam.housesforrent;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText etmail;
    private EditText etpass;
    private Button signin;
    private Button signup;
    private FirebaseAuth Auth;
    private FirebaseUser FirebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etmail=(EditText)findViewById(R.id.etmail);
        etpass=(EditText)findViewById(R.id.etpass);
        signin=(Button)findViewById(R.id.btnSignin);
        signup=(Button)findViewById(R.id.btnSignup);
        signin.setOnClickListener(this);
        signup.setOnClickListener(this);
        Auth=FirebaseAuth.getInstance();
        FirebaseUser=Auth.getCurrentUser();
    }


        private void dataHandler() {
            String email = etmail.getText().toString();
            String passw = etpass.getText().toString();
            signIn(email, passw);
        }

        private void signIn(String email, String passw) {
            Auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "signIn Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getBaseContext(), MainActivityHouse.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "signIn failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        task.getException().printStackTrace();
                    }
                }
            });
        }
        public void onClick(View view) {
            if (view==signin){
                dataHandler();
            }
            if (view==signup){
                Intent i = new Intent(this,signup.class);
                startActivity(i);
            }
        }

    }

