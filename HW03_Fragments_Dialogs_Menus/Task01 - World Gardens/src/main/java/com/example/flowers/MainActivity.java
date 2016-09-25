package com.example.flowers;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.IGardenSelected {

    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";

    private ListFragment listFragment;
    private ListFragment savedFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        savedFragment = (ListFragment) getSupportFragmentManager()
                .findFragmentByTag(LIST_FRAGMENT);

        if (savedFragment == null) {
            listFragment = new ListFragment();
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeholder, listFragment, LIST_FRAGMENT);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onListGardenSelected(int index) {

        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_GARDEN_INDEX, index);
        viewPagerFragment.setArguments(bundle);

        FragmentManager frManager = getSupportFragmentManager();
        FragmentTransaction frTransaction = frManager.beginTransaction();
        frTransaction.replace(R.id.placeholder, viewPagerFragment, VIEWPAGER_FRAGMENT);
        frTransaction.addToBackStack(null);
        frTransaction.commit();
    }
}
