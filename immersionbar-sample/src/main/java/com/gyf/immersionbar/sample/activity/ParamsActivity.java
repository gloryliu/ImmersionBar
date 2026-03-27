package com.gyf.immersionbar.sample.activity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityParamsBinding;

/**
 * @author geyifeng
 */
public class ParamsActivity extends BaseActivity<ActivityParamsBinding> {

    private boolean mIsHideStatusBar = false;


    @Override
    protected ActivityParamsBinding createViewBinding() {
        return ActivityParamsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).titleBar(mBinding.mToolbar)
                .setOnNavigationBarListener((show, type) -> {
                    initView();
                    Toast.makeText(this, "导航栏" + (show ? "显示了" : "隐藏了"), Toast.LENGTH_SHORT).show();
                })
                .navigationBarColor(R.color.btn13).init();
    }

    @Override
    protected void initData() {
        super.initData();
        mBinding.mToolbar.setTitle(getIntent().getCharSequenceExtra("title"));
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        super.initView();
        mBinding.mTvStatus.setText(getText(getTitle(mBinding.mTvStatus) + ImmersionBar.getStatusBarHeight(this)));
        mBinding.mTvHasNav.setText(getText(getTitle(mBinding.mTvHasNav) + ImmersionBar.hasNavigationBar(this)));
        mBinding.mTvNav.setText(getText(getTitle(mBinding.mTvNav) + ImmersionBar.getNavigationBarHeight(this)));
        mBinding.mTvNavWidth.setText(getText(getTitle(mBinding.mTvNavWidth) + ImmersionBar.getNavigationBarWidth(this)));
        mBinding.mTvAction.setText(getText(getTitle(mBinding.mTvAction) + ImmersionBar.getActionBarHeight(this)));
        mBinding.mTvHasNotch.post(() -> mBinding.mTvHasNotch.setText(getText(getTitle(mBinding.mTvHasNotch) + ImmersionBar.hasNotchScreen(this))));
        mBinding.mTvNotchHeight.post(() -> mBinding.mTvNotchHeight.setText(getText(getTitle(mBinding.mTvNotchHeight) + ImmersionBar.getNotchHeight(this))));
        mBinding.mTvFits.setText(getText(getTitle(mBinding.mTvFits) + ImmersionBar.checkFitsSystemWindows(findViewById(android.R.id.content))));
        mBinding.mTvStatusDark.setText(getText(getTitle(mBinding.mTvStatusDark) + ImmersionBar.isSupportStatusBarDarkFont()));
        mBinding.mTvNavigationDark.setText(getText(getTitle(mBinding.mTvNavigationDark) + ImmersionBar.isSupportNavigationIconDark()));
        mBinding.mTvGesture.setText(getText(getTitle(mBinding.mTvGesture) + ImmersionBar.isGesture(this)));
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void setListener() {
        super.setListener();
        mBinding.mBtnStatus.setOnClickListener(v -> {
            if (!mIsHideStatusBar) {
                ImmersionBar.hideStatusBar(getWindow());
                mIsHideStatusBar = true;
            } else {
                ImmersionBar.showStatusBar(getWindow());
                mIsHideStatusBar = false;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(mBinding.mTvInsets, (view, windowInsetsCompat) -> {
            mBinding.mTvInsets.setText(getText(getTitle(mBinding.mTvInsets) + windowInsetsCompat.getSystemWindowInsetTop()));
            return windowInsetsCompat.consumeSystemWindowInsets();
        });
    }

    private SpannableString getText(String text) {
        String[] split = text.split(" {3}");
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(ContextCompat.getColor(this, R.color.btn3));
        spannableString.setSpan(colorSpan, text.length() - split[1].length(), text.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    private String getTitle(TextView textView) {
        String[] split = textView.getText().toString().split(" {3}");
        return split[0] + "   ";
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        initView();
    }
}
