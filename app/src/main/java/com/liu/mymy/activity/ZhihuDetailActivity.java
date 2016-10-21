package com.liu.mymy.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.liu.mymy.R;
import com.liu.mymy.api.RetrofitHelper;
import com.liu.mymy.base.BaseActivity;
import com.liu.mymy.bean.ZhiHuStory;
import com.liu.mymy.util.ImageLoader;
import com.liu.mymy.util.WebUtil;

import java.lang.reflect.InvocationTargetException;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 知乎日报详情Activity
 * Created by liu on 2016/10/21.
 */
public class ZhihuDetailActivity extends BaseActivity {
    public static final String ID = "id";
    public static final String TITLE = "title";

    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.wv_zhihu)
    WebView wvZhihu;

    //知乎日报ID
    private String id;
    //知乎日报标题
    private String title;
    //知乎日报地址
    private String url;

    //网页的HTML内容
    private String mBody;
    //网页的CSS样式
    private String[] css;

    @Override
    protected void setLayout() {
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhihu_detail;
    }

    @Override
    protected void initView() {
        initIntent();
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        initWebView();
    }

    private void initIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getStringExtra(ID);
            title = intent.getStringExtra(TITLE);
        }

    }

    private void initWebView() {
        WebSettings settings = wvZhihu.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        //settings.setUseWideViewPort(true);造成文字太小
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCachePath(getCacheDir().getAbsolutePath() + "/webViewCache");
        settings.setAppCacheEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wvZhihu.setWebChromeClient(new WebChromeClient());
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadData() {
        collapsingToolbarLayout.setTitle(title);

        getWebData();
    }

    /**
     * 加载WebView的内容
     */
    private void getWebData() {
        RetrofitHelper
                .getZhiHuAPI()
                .getZhihuStory(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ZhiHuStory>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ZhiHuStory zhiHuStory) {
                            showStory(zhiHuStory);
                    }
                });
    }

    private void showStory(ZhiHuStory zhiHuStory) {
        ImageLoader.getSingleton().disPlayImage(this, zhiHuStory.getImage(), iv);
        url=zhiHuStory.getShareUrl();
        mBody=zhiHuStory.getBody();
        css=zhiHuStory.getCss();
        if (TextUtils.isEmpty(mBody)){
            wvZhihu.loadUrl(url);
        }else {
            String data = WebUtil.buildHtmlWithCss(mBody, css,false);
            wvZhihu.loadDataWithBaseURL(WebUtil.BASE_URL, data, WebUtil.MIME_TYPE, WebUtil.ENCODING, WebUtil.FAIL_URL);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        try {
            wvZhihu.getClass().getMethod("onResume").invoke(wvZhihu, (Object[]) null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            wvZhihu.getClass().getMethod("onPause").invoke(wvZhihu, (Object[]) null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {

        //webview内存泄露
        if (wvZhihu != null) {
            ((ViewGroup) wvZhihu.getParent()).removeView(wvZhihu);
            wvZhihu.destroy();
            wvZhihu = null;
        }
        super.onDestroy();

    }

}
