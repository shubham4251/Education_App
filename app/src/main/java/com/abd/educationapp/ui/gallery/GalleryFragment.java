package com.abd.educationapp.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.abd.educationapp.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    String exp;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final Button shareButton = root.findViewById(R.id.shareButton);
        final EditText expEditText = root.findViewById(R.id.experience);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                if(expEditText.getText().toString().isEmpty()){
                     exp = "This app is fabulous";
                }
                else exp =expEditText.getText().toString();
                String shareBody = "Download this App now:- https://play.google.com/store/apps/details?id=com.whatsapp&hl=en"+"\n"+"My Experience: "+exp;
                String shareSub = "Education App";

                shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(shareIntent,"Share Using"));
            }
        });
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}