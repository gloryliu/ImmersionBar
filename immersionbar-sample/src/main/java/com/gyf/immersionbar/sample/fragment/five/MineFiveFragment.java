package com.gyf.immersionbar.sample.fragment.five;

import android.os.Bundle;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.FragmentTwoMineBinding;

/**
 * @author geyifeng
 * @date 2017/7/20
 */
public class MineFiveFragment extends BaseFiveFragment<FragmentTwoMineBinding> {

    public static MineFiveFragment newInstance() {
        Bundle args = new Bundle();
        MineFiveFragment fragment = new MineFiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).navigationBarColor(R.color.btn7).init();
    }

    @Override
    protected FragmentTwoMineBinding createViewBinding() {
        return FragmentTwoMineBinding.inflate(getLayoutInflater());
    }

}
