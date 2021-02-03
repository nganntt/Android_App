package com.example.ngannguyen.readdatafirebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowUserInformation  extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private String userID;
    private ListView mListView;
    private FirebaseAuth mAuth;

    private static final String TAG = "LoginAtivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_information);

        mListView = (ListView)findViewById(R.id.list_view) ;
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase= FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();



        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());

                    Toast.makeText(ShowUserInformation.this,"Successfully signed in with: " + user.getEmail(),Toast.LENGTH_SHORT).show();
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    Toast.makeText(ShowUserInformation.this, "Successfully signed out",Toast.LENGTH_SHORT).show();

                }
                // ...
            }
        };



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(TAG,"onDataChange listener, userID=" +userID);
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }




    public void showData(DataSnapshot dataSnapshot){
        Log.d(TAG,"show data ");
        for(DataSnapshot ds: dataSnapshot.getChildren()){
            UserInformation userInformation = new UserInformation();

            userInformation.setName(ds.child(userID).getValue(UserInformation.class).getName());

            userInformation.setEmail(ds.child(userID).getValue(UserInformation.class).getEmail());
            userInformation.setPhone(ds.child(userID).getValue(UserInformation.class).getPhone());

            Log.d(TAG,"show info name: " + userInformation.getName());
            Log.d(TAG,"show info email: " + userInformation.getEmail());
            Log.d(TAG,"show info phone: " + userInformation.getPhone());

            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(userInformation.getName());
            arrayList.add(userInformation.getEmail());
            arrayList.add(userInformation.getPhone());
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

            mListView.setAdapter(arrayAdapter);

        }

    }




    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


}
