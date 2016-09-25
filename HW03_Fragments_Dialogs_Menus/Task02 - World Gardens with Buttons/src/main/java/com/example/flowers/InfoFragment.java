package com.example.flowers;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoFragment extends Fragment {

    private static final String KEY_CHECKED_BOX = "key_checked_box";

    private LinearLayout mInfoLinearLayout;
    private TextView mItemInfoText;
    private CheckBox mCheckBox;
    private boolean isChecked;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int index = getArguments().getInt(ViewPagerFragment.KEY_GARDEN_INDEX);
        View view = inflater.inflate(R.layout.item_info, container, false);

        mInfoLinearLayout = (LinearLayout) view.findViewById(R.id.infoLayout);
        String info = Gardens.info[index];
        mCheckBox = new CheckBox(getActivity());

        if (savedInstanceState != null && savedInstanceState.getBoolean(KEY_CHECKED_BOX)) {
            isChecked = savedInstanceState.getBoolean(KEY_CHECKED_BOX);
        }
        setUpTextViewCheckBox(info, mInfoLinearLayout, isChecked);

        return view;
    }

    private void setUpTextViewCheckBox(String info, ViewGroup container, boolean isChecked) {

        mItemInfoText = new TextView(getActivity());
        mItemInfoText.setText(info);
        mItemInfoText.setTextSize(24f);
        container.addView(mItemInfoText);

        mCheckBox.setText("Ще отида задължително!");
        mCheckBox.setTextColor(Color.parseColor("#8BC34A"));
        mCheckBox.setTextSize(20f);
        container.addView(mCheckBox);

        if (isChecked) {
            mCheckBox.toggle();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean stateOfCheckBox = false;

        stateOfCheckBox = mCheckBox.isChecked();
        outState.putBoolean(KEY_CHECKED_BOX, stateOfCheckBox);

        super.onSaveInstanceState(outState);
    }
}
