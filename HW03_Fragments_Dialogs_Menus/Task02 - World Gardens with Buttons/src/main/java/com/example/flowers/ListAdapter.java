package com.example.flowers;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends RecyclerView.Adapter {
    private final ListFragment.IGardenSelected mListener;

    public ListAdapter(ListFragment.IGardenSelected listener) {
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Gardens.names.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Button mButton;
        private int mIndex;

        public ListViewHolder(View itemView) {
            super(itemView);

            mButton = (Button) itemView.findViewById((R.id.itemButton));
            mButton.setOnClickListener(this);
        }

        public void bindView(int position) {
            mIndex = position;

            mButton.setText(Gardens.names[position]);
        }

        @Override
        public void onClick(View view) {
            mListener.onListGardenSelected(mIndex);
        }
    }
}
