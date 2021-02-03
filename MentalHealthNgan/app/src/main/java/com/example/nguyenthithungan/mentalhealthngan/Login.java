package com.example.nguyenthithungan.mentalhealthngan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.support.annotation.NonNull;


public class Login extends AppCompatActivity{

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAutheStateListener;



    private static final String TAG = "LoginAtivity";

    private Context mContext;
    private ProgressBar mProgressBar;
    private EditText mEmail, mPassword;
    private TextView mPleaseWait;
    private Button btnLogin;
    private TextView mLinkSignUp;
    private Button btnView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        btnView = (Button)findViewById(R.id.btnView);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar_id_login);
        mEmail = (EditText) findViewById(R.id.input_email_login);
        mPassword = (EditText) findViewById(R.id.input_password_login);

        mPleaseWait = (TextView) findViewById(R.id.please_wait_id_login);

        mProgressBar.setVisibility(View.GONE);
        mPleaseWait.setVisibility(View.GONE);

        setupFirebaseAuth();
        init();


    }

    private void init(){
        btnLogin = (Button) findViewById(R.id.btn_login);
        mLinkSignUp = (TextView) findViewById(R.id.link_sigup);

        // set onClickListener for signup Text
        mLinkSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Navigation to register page");
                Intent mIntent = new Intent(Login.this, RegisterNewUser.class);
                startActivity(mIntent);
            }
        });



        // set onClickListener for button login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                if (isStringNull(email) && isStringNull(password)){
                    Toast.makeText(mContext, "You must fill out all the fields", Toast.LENGTH_LONG).show();
                }else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mPleaseWait.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                                    if (!task.isSuccessful()) {
                                        Log.w(TAG, "signInWithEmail:failed", task.getException());

                                        Toast.makeText(Login.this, getString(R.string.auth_failed),
                                                Toast.LENGTH_SHORT).show();
                                        mProgressBar.setVisibility(View.GONE);
                                        mPleaseWait.setVisibility(View.GONE);
                                    }
                                    else{
                                        Log.d(TAG, "signInWithEmail: successful login");
                                        Toast.makeText(Login.this, getString(R.string.auth_success),
                                                Toast.LENGTH_SHORT).show();
                                        mProgressBar.setVisibility(View.GONE);
                                        mPleaseWait.setVisibility(View.GONE);


                                    }

                                    // ...
                                }
                            });


                }

            }
        });

        /**
         * if user in login page and navigate to register page
         */
  /*      if (mAuth.getCurrentUser() != null){
            Intent intent = new Intent(Login.this, RegisterNewUser.class);
            startActivity(intent);

        }    */

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "on Click View User information button");
                Intent mIntent = new Intent (Login.this, ShowUserInformation.class);
                startActivity(mIntent);
            }
        });
    }
    private boolean isStringNull (String string){
        if(string.equals("")){
            return true;
        }else {
            return false;
        }
    }


    /**
     * Setup the firebase auth object
     */
    private void setupFirebaseAuth(){
        Log.d(TAG, "setupFirebaseAuth: setting up firebase auth.");

        mAuth = FirebaseAuth.getInstance();

        mAutheStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }



    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAutheStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAutheStateListener != null) {
            mAuth.removeAuthStateListener(mAutheStateListener);
        }
    }
}
