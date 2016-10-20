package com.liu.mymy.adapter;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liu.mymy.R;
import com.liu.mymy.bean.GankMeiziInfo;
import com.liu.mymy.util.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 妹子列表Adapter
 * Created by liu on 2016/10/20.
 */
public class MeiziAdapter extends AbsRecyclerViewAdapter {
    private List<GankMeiziInfo> meizis = new ArrayList<>();

    public MeiziAdapter(RecyclerView recyclerView, List<GankMeiziInfo> meizis) {
        super(recyclerView);
        this.meizis = meizis;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_meizi, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.mTextView.setText(meizis.get(position).desc);
            ImageLoader.getSingleton().disPlayImage(getContext(),meizis.get(position).url,itemViewHolder.ratioImageView);
            ViewCompat.setTransitionName(itemViewHolder.ratioImageView, meizis.get(position).url);
        }
    }

    @Override
    public int getItemCount() {
        return meizis == null ? 0 : meizis.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

        public ImageView ratioImageView;

        public TextView mTextView;

        public View item;

        public ItemViewHolder(View itemView) {

            super(itemView);
            item = itemView;
            ratioImageView = $(R.id.item_iv);
            mTextView = $(R.id.item_tv);
        }
    }

}
