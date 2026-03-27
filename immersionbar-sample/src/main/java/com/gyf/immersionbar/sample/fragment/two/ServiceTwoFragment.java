package com.gyf.immersionbar.sample.fragment.two;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.FragmentTwoServiceBinding;
import com.gyf.immersionbar.sample.fragment.BaseImmersionFragment;

/**
 * @author geyifeng
 * @date 2017/7/20
 */
public class ServiceTwoFragment extends BaseImmersionFragment<FragmentTwoServiceBinding> {

    @Override
    protected FragmentTwoServiceBinding createViewBinding() {
        return FragmentTwoServiceBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f)
                .navigationBarColor(R.color.btn2)
                .navigationBarDarkIcon(true)
                .keyboardEnable(false)
                .init();
    }
}
