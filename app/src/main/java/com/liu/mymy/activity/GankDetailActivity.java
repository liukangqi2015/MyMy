package com.liu.mymy.activity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liu.mymy.R;
import com.liu.mymy.base.BaseActivity;
import com.liu.mymy.network.TANetWorkUtil;
import com.liu.mymy.util.ShareUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 干货详情Activity
 * Created by liu on 2016/10/25.
 */
public class GankDetailActivity extends BaseActivity {
    public static final String DESC = "desc";
    public static final String URL = "url";
    @BindView(R.id.gank_toolbar)
    Toolbar gankToolbar;
    @BindView(R.id.gank_pb)
    ProgressBar gankPb;
    @BindView(R.id.gank_webView)
    WebView gankWebView;
    @BindView(R.id.title_tv)
    TextView titleTv;

    private String desc, url;

    @Override
    protected void setLayout() {
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gank_detail;
    }

    @Override
    protected void initView() {
        initIntent();
        initToolBar();
        initWebView();
    }

    private void initIntent() {
        desc = getIntent().getStringExtra(DESC);
        url = getIntent().getStringExtra(URL);
    }

    private void initToolBar() {
        gankToolbar.setNavigationIcon(R.drawable.ic_back);
        gankToolbar.setBackgroundResource(R.color.colorPrimary);
        gankToolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });
        gankToolbar.inflateMenu(R.menu.menu_gank_android);
        gankToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (R.id.action_share==item.getItemId()){
                   share();
                }
                return false;
            }
        });
        titleTv.setText(desc);

    }

    private void share(){
        ShareUtil.shareLink(url,desc,GankDetailActivity.this);
    }

    private void initWebView() {
        WebSettings webSettings = gankWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);
    }

    @Override
    protected void setListener() {
        gankWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        gankWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    gankPb.setVisibility(View.GONE);
                } else {
                    if (View.VISIBLE == gankPb.getVisibility()) {
                        gankPb.setVisibility(View.VISIBLE);
                    }
                    gankPb.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    @Override
    protected void loadData() {
        gankWebView.loadUrl(url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (gankWebView != null) {
            if (gankWebView != null) {
                ((ViewGroup) gankWebView.getParent()).removeView(gankWebView);
                gankWebView.destroy();
                gankWebView = null;
            }
        }
    }

    @Override
    public void onConnect(TANetWorkUtil.netType type) {

    }

    @Override
    public void onDisConnect() {

    }
}
