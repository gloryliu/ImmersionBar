package com.gyf.immersionbar.sample.activity;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityLoginBinding;

/**
 * @author geyifeng
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding> {


    @Override
    protected ActivityLoginBinding createViewBinding() {
        return ActivityLoginBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).titleBar(R.id.toolbar).keyboardEnable(true).init();
    }

}
