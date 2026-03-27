package com.gyf.immersionbar.sample.fragment.five;

import android.os.Bundle;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.FragmentTwoServiceBinding;

/**
 * @author geyifeng
 * @date 2017/7/20
 */
public class ServiceFiveFragment extends BaseFiveFragment<FragmentTwoServiceBinding> {

    public static ServiceFiveFragment newInstance() {
        Bundle args = new Bundle();
        ServiceFiveFragment fragment = new ServiceFiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .navigationBarColor(R.color.btn2)
                .keyboardEnable(false)
                .statusBarDarkFont(true, 0.2f)
                .navigationBarDarkIcon(true)
                .init();
    }

    @Override
    protected FragmentTwoServiceBinding createViewBinding() {
        return FragmentTwoServiceBinding.inflate(getLayoutInflater());
    }
}
