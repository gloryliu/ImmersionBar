package com.gyf.immersionbar.sample.fragment.five;

import android.os.Bundle;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.FragmentTwoCategoryBinding;

/**
 * @author geyifeng
 * @date 2017/7/20
 */
public class CategoryFiveFragment extends BaseFiveFragment<FragmentTwoCategoryBinding> {

    public static CategoryFiveFragment newInstance() {
        Bundle args = new Bundle();
        CategoryFiveFragment fragment = new CategoryFiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).navigationBarColor(R.color.btn1).init();
    }

    @Override
    protected FragmentTwoCategoryBinding createViewBinding() {
        return FragmentTwoCategoryBinding.inflate(getLayoutInflater());
    }
}
