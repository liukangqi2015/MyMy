package com.liu.mymy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liu.mymy.R;


public class SimpleCardFragment extends Fragment {
    private static final String TAG="SimpleCardFragment";
    private String mTitle;

    public static SimpleCardFragment getInstance(String title) {
        SimpleCardFragment sf = new SimpleCardFragment();
        sf.mTitle = title;
        return sf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG+"-"+mTitle,"onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG+"-"+mTitle,"onCreateView");
        View v = inflater.inflate(R.layout.fr_simple_card, null);
        TextView card_title_tv = (TextView) v.findViewById(R.id.card_title_tv);
        card_title_tv.setText(mTitle);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG+"-"+mTitle,"onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG+"-"+mTitle,"onPause");
    }
}