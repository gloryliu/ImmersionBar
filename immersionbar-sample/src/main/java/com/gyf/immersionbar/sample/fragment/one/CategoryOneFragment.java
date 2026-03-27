package com.gyf.immersionbar.sample.fragment.one;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.FragmentOneCategoryBinding;
import com.gyf.immersionbar.sample.fragment.BaseImmersionFragment;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class CategoryOneFragment extends BaseImmersionFragment<FragmentOneCategoryBinding> {

    @Override
    protected FragmentOneCategoryBinding createViewBinding() {
        return FragmentOneCategoryBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f)
                .navigationBarColor(R.color.btn3)
                .init();
    }
}
