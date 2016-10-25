package com.liu.mymy.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.liu.mymy.R;
import com.liu.mymy.base.BaseFragment;
import com.liu.mymy.util.ImageLoader;

import butterknife.BindView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * 妹子图片详情Fragment
 * Created by liu on 2016/10/19.
 */
public class MeiziDetailFragment extends BaseFragment implements RequestListener<String,GlideDrawable>{
    public static final String URL="url";
    @BindView(R.id.meizi)
    ImageView meiziIV;
    @BindView(R.id.tv_image_error)
    TextView tvImageError;

    private String url;

    private PhotoViewAttacher mPhotoViewAttacher;

    public static MeiziDetailFragment newInstance(String url){
        MeiziDetailFragment meiziDetailFragment=new MeiziDetailFragment();
        Bundle bundle=new Bundle();
        bundle.putString(URL,url);
        meiziDetailFragment.setArguments(bundle);
        return meiziDetailFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_meizi_details;
    }

    @Override
    protected void init(View view, Bundle savedInstanceState) {
        url=getArguments().getString(URL);

        ImageLoader.getSingleton().disPlayImage(getHoldingActivity(),url,this);
    }


    @Override
    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
        tvImageError.setVisibility(View.VISIBLE);
        return false;
    }

    @Override
    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
        meiziIV.setImageDrawable(resource);
        mPhotoViewAttacher=new PhotoViewAttacher(meiziIV);
        tvImageError.setVisibility(View.GONE);
        return false;
    }


}
