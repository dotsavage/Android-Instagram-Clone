package com.example.android.instagram.Profile;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.instagram.R;
import com.example.android.instagram.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.zip.Inflater;

/**
 * Created by sehajpalsingh on 31/03/18.
 */

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";


    private ImageView mProfilePhoto;

    ImageView backArrow;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile,container,false);

        mProfilePhoto = view.findViewById(R.id.profile_photo);

        backArrow = view.findViewById(R.id.cancel_action);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),OptionActivity.class);
                startActivity(intent);
            }
        });



        setProfileImage();

        return view;
    }



    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting profile image.");
        String imgURL = "www.androidcentral.com/sites/androidcentral.com/files/styles/xlarge/public/article_images/2016/08/ac-lloyd.jpg?itok=bb72IeLf";
        UniversalImageLoader.setImage(imgURL, mProfilePhoto, null, "https://");
    }
}
