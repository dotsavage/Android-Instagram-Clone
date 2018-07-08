package com.example.android.instagram.Utils;

/**
 * Created by sehajpalsingh on 08/04/18.
 */

public class StringManipulation {

    public static String expandUsername(String username){
        return username.replace(".", " ");
    }

    public static String condenseUsername(String username){
        return username.replace(" " , ".");
    }
}
