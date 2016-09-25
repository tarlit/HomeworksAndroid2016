package com.example.flowers;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PictureFragment extends Fragment {

    //private LinearLayout pictureLinearLayout;
    private ImageView mItemPicture;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int index = getArguments().getInt(ViewPagerFragment.KEY_GARDEN_INDEX);
        View view = inflater.inflate(R.layout.item_picture, container, false);

        //pictureLinearLayout = (LinearLayout) view.findViewById(R.id.pictureLayout);
        mItemPicture = (ImageView) view.findViewById(R.id.big_picture);
        mItemPicture.setImageResource(Gardens.picturesIds[index]);

        return view;
    }
}
