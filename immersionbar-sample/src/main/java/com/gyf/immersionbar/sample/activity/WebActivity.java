package com.gyf.immersionbar.sample.activity;

import android.view.ViewGroup;
import android.view.ViewParent;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityWebBinding;

/**
 * @author geyifeng
 * @date 2017/6/19
 */
public class WebActivity extends BaseActivity<ActivityWebBinding> {

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).titleBar(R.id.toolbar)
                //解决软键盘与底部输入框冲突问题
                .keyboardEnable(true)
                .init();
    }

    @Override
    protected void initView() {
        mBinding.web.loadUrl("file:///android_asset/input_webview.html");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (mBinding.web != null) {
                ViewParent parent = mBinding.web.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(mBinding.web);
                }
                mBinding.web.stopLoading();
                // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
                mBinding.web.getSettings().setJavaScriptEnabled(false);
                mBinding.web.clearHistory();
                mBinding.web.clearView();
                mBinding.web.removeAllViews();
                mBinding.web.destroy();
            }
        } catch (Exception ignored) {
        }
    }

    @Override
    protected ActivityWebBinding createViewBinding() {
        return ActivityWebBinding.inflate(getLayoutInflater());
    }
}
