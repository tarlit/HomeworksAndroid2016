package com.example.flowers;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerFragment extends Fragment {

    public static final String KEY_GARDEN_INDEX = "garden_index";

    private InfoFragment infoFragment;
    private PictureFragment pictureFragment;
    private TabLayout tabLayout;
    private Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int index = getArguments().getInt(KEY_GARDEN_INDEX);
        getActivity().setTitle(Gardens.names[index]);

        infoFragment = new InfoFragment();
        bundle = new Bundle();
        bundle.putInt(KEY_GARDEN_INDEX, index);
        infoFragment.setArguments(bundle);

        pictureFragment = new PictureFragment();
        bundle = new Bundle();
        bundle.putInt(KEY_GARDEN_INDEX, index);
        pictureFragment.setArguments(bundle);

        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {

            @Override
            public Fragment getItem(int position) {

                if (position == 0) {
                    return infoFragment;
                } else {
                    return pictureFragment;
                }
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Garden Info" : "Garden Picture";
            }

            @Override
            public int getCount() {
                return 2; // host only two fragments
            }
        });

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
