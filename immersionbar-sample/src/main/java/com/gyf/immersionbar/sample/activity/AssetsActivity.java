package com.gyf.immersionbar.sample.activity;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.databinding.ActivityAssetsBinding;

/**
 * @author geyifeng
 * @date 2019/3/25 2:47 PM
 */
public class AssetsActivity extends BaseActivity<ActivityAssetsBinding> {

    @Override
    protected ActivityAssetsBinding createViewBinding() {
        return ActivityAssetsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor("#F56A3D").keyboardEnable(true).init();
    }
}
