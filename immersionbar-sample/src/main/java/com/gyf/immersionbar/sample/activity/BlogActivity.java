package com.gyf.immersionbar.sample.activity;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityGitHubBinding;

import static android.view.KeyEvent.KEYCODE_BACK;

/**
 * @author geyifeng
 * @date 2017/8/3
 */

public class BlogActivity extends BaseActivity<ActivityGitHubBinding> {

    private String blog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        blog = getIntent().getBundleExtra("bundle").getString("blog");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        if ("github".equals(blog)) {
            mBinding.webGit.loadUrl("https://github.com/gyf-dev/ImmersionBar");
        } else {
            mBinding.webGit.loadUrl("https://www.jianshu.com/p/2a884e211a62");
        }
        mBinding.webGit.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }
        });
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        if ("github".equals(blog)) {
            ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.github_color).init();
        } else {
            ImmersionBar.with(this).fitsSystemWindows(true).statusBarColorInt(Color.WHITE).statusBarDarkFont(true, 0.2f).init();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && mBinding.webGit.canGoBack()) {
            mBinding.webGit.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (mBinding.webGit != null) {
                ViewParent parent = mBinding.webGit.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(mBinding.webGit);
                }
                mBinding.webGit.stopLoading();
                // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
                mBinding.webGit.getSettings().setJavaScriptEnabled(false);
                mBinding.webGit.clearHistory();
                mBinding.webGit.clearView();
                mBinding.webGit.removeAllViews();
                mBinding.webGit.destroy();
            }
        } catch (Exception ignored) {
        }
    }

    @Override
    protected ActivityGitHubBinding createViewBinding() {
        return ActivityGitHubBinding.inflate(getLayoutInflater());
    }
}
