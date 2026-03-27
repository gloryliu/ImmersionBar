package com.gyf.immersionbar.sample.activity;

import android.annotation.SuppressLint;
import android.view.View;

import com.gyf.immersionbar.BarParams;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityOver3Binding;
import com.gyf.immersionbar.sample.utils.ClickHelper;

/**
 * @author geyifeng
 * @date 2017/5/8
 */
public class Over3Activity extends BaseActivity<ActivityOver3Binding> {

    @Override
    protected ActivityOver3Binding createViewBinding() {
        return ActivityOver3Binding.inflate(getLayoutInflater());
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).fitsSystemWindows(true)
                .statusBarColor(R.color.colorPrimary)
                .navigationBarColor(R.color.colorPrimary)
                .keyboardEnable(true)
                .init();
    }

    @Override
    protected void setListener() {
        super.setListener();
        ClickHelper.setClickListeners(mBinding, this::onClick, R.id.btn);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        mBinding.text.setText("使用ImmersionBar的fitsSystemWindows方法" +
                "指定fitsSystemWindows为true，然后指定状态栏的颜色，不然状态栏为透明色，很难看，详情参看此页面的实现");
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btn) {
            BarParams barParams = ImmersionBar.with(this).getBarParams();
            if (barParams.fits) {
                ImmersionBar.with(this).fitsSystemWindows(false).transparentStatusBar().init();
                mBinding.btn.setText("fitsSystemWindows动态演示:false");
            } else {
                ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.colorPrimary).init();
                mBinding.btn.setText("fitsSystemWindows动态演示:true");
            }
        }
    }
}
