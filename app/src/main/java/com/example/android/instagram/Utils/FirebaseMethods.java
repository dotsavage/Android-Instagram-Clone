package com.example.android.instagram.Utils;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.instagram.Models.User;
import com.google.firebase.database.DataSnapshot;

/**
 * Created by sehajpalsingh on 08/04/18.
 */

public class FirebaseMethods extends AppCompatActivity {

    private static final String TAG = "FirebaseMethods";


    public boolean checkIfUsernameExist(String username, DataSnapshot dataSnapshot){
        Log.d(TAG, "checkIfUsernameExists: checking if " + username + " already exists.");

        User user = new User();

        for (DataSnapshot ds: dataSnapshot.getChildren()){
            Log.d(TAG, "checkIfUsernameExists: datasnapshot: " + ds);

            user.setUsername(ds.getValue(User.class).getUsername());
            Log.d(TAG, "checkIfUsernameExists: username: " + user.getUsername());

            if(StringManipulation.expandUsername(user.getUsername()).equals(username)){
                Log.d(TAG, "checkIfUsernameExists: FOUND A MATCH: " + user.getUsername());
                return true;
            }
        }
        return false;
    }


}
