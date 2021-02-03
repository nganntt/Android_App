package com.example.nguyenthithungan.mentalhealthngan;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterNewUser extends AppCompatActivity {
    private static final String TAG = "RegisterNewUser";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAutheStateListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    // variable of widget
    private Context mContext;
    private ProgressBar mProgressBar;
    private EditText mEmail, mPassword, mFullName;
    private TextView mPleaseWait;
    private Button btnRegister;
    private String email, password, usernam;

    private FirebaseMethod firebaseMethod;
    String append = "";
    String phone = "12344566";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_new_user);
        mContext = RegisterNewUser.this;
        firebaseMethod = new FirebaseMethod(mContext);
        mFirebaseDatabase= FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();


        initWiget();
        mProgressBar.setVisibility(View.GONE);
        mPleaseWait.setVisibility(View.GONE);


        init();
        setupFirebaseAuth();

    }


    /**
     * Check iput of email, pass and userName
     * @param email
     * @param pass
     * @param userName
     * @return
     */

    private boolean checkInput(final String email, String pass, String userName){
        Log.d(TAG, "check Input email, pass, userName");
        if (email.equals("") || pass.equals("")|| userName.equals("")){
            Toast.makeText(mContext,"all fileds must be filled out",Toast.LENGTH_LONG).show();
            return false;
        }else {
            return true;
        }
    }

    public void init(){
        Log.d(TAG,"Init method of register new user");
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEmail.getText().toString();
                password = mPassword.getText().toString();
                usernam = mFullName.getText().toString();

                if (checkInput(email,password,usernam)){
                    mProgressBar.setVisibility(View.VISIBLE);
                    mPleaseWait.setVisibility(View.VISIBLE);
                    // insert new email to authentication
                    firebaseMethod.registerNewEmail(email,password,usernam);

                }
            }
        });

    }


    /**
     * Init wiget
     */

    private void initWiget(){
        mProgressBar = (ProgressBar)findViewById(R.id.progress_bar_id_register);
        mPleaseWait = (TextView) findViewById(R.id.please_wait_register_id);
        mEmail = (EditText) findViewById(R.id.input_email_register);
        mPassword = (EditText) findViewById(R.id.input_password_register);
        mFullName = (EditText) findViewById(R.id.input_full_name);
        btnRegister = (Button) findViewById(R.id.btn_register);
        mContext = RegisterNewUser.this;
        mProgressBar.setVisibility(View.GONE);
        mPleaseWait.setVisibility(View.GONE);

    }


    /**
     * setup firebase
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
                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            //1st check username is not already use
                            if(firebaseMethod.checkIfUserExist(usernam,dataSnapshot)){
                                append = myRef.push().getKey().substring(3,10);
                                Log.d(TAG,"onDataChange: username already exists. appending a random string to name");

                            }
                            firebaseMethod.addNewUser(email,usernam,phone);


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
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


