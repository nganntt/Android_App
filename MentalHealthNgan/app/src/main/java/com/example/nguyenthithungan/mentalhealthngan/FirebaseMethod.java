package com.example.nguyenthithungan.mentalhealthngan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseMethod {
    private static final String TAG = "FirebaseMethod";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAutheStateListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;


    private Context mContext;
    private String userID;
    private String Append = "";

    public FirebaseMethod(Context context){
        mAuth = FirebaseAuth.getInstance();
        mContext = context;
        if (mAuth != null){
            userID = mAuth.getCurrentUser().getUid();

        }

    }



    public static boolean checkIfUserExist(String userName, DataSnapshot dataSnapshot){
        UserInformation user = new UserInformation();
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            user.setName(ds.getValue(UserInformation.class).getName());
            Log.d(TAG,"checkIF userExist user name = " + user.getName().toString());
            if (StringManipulation.expandUser(user.getName()).equals(userName)){
                return true;
            }
        }
        return false;
    }


    /**
     * Register new email and password to firebase
     * @param email
     * @param password
     * @param user
     */
    public void registerNewEmail(final String email, String password, String user){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG,"CreateUserWithEmail:onComplete: " + task.isSuccessful());
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            userID = mAuth.getCurrentUser().getUid();


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(mContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });


    }


    public void addNewUser(String email,String name, String phone){
        UserInformation user = new UserInformation(email,name,phone);
        myRef.child("users").child(userID).setValue(user);

    }
}
