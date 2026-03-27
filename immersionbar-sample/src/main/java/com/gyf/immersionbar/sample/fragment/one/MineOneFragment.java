package com.gyf.immersionbar.sample.fragment.one;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.FragmentOneMineBinding;
import com.gyf.immersionbar.sample.fragment.BaseImmersionFragment;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class MineOneFragment extends BaseImmersionFragment<FragmentOneMineBinding> {

    @Override
    protected FragmentOneMineBinding createViewBinding() {
        return FragmentOneMineBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .navigationBarColor(R.color.btn1)
                .navigationBarDarkIcon(true)
                .init();
    }
}
