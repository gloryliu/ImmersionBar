package com.gyf.immersionbar.sample.fragment.two;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.FragmentTwoMineBinding;
import com.gyf.immersionbar.sample.fragment.BaseImmersionFragment;

/**
 * @author geyifeng
 * @date 2017/7/20
 */

public class MineTwoFragment extends BaseImmersionFragment<FragmentTwoMineBinding> {

    @Override
    protected FragmentTwoMineBinding createViewBinding() {
        return FragmentTwoMineBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .navigationBarColor(R.color.btn7)
                .init();
    }
}
