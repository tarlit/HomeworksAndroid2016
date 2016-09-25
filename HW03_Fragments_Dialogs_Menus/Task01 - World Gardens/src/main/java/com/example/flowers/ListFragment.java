package com.example.flowers;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFragment extends Fragment {

    public interface IGardenSelected {
        void onListGardenSelected(int index);
    }

    RecyclerView listRecyclerView;
    ListAdapter listAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        IGardenSelected listener = (IGardenSelected) getActivity();
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listRecyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);
        listAdapter = new ListAdapter(listener);
        listRecyclerView.setAdapter(listAdapter);

        layoutManager = new LinearLayoutManager(getActivity());
        listRecyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
