package com.gyf.immersionbar.sample.fragment.three;

import com.gyf.immersionbar.sample.databinding.FragmentOneMineBinding;
import com.gyf.immersionbar.sample.fragment.BaseFragment;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class MineThreeFragment extends BaseFragment<FragmentOneMineBinding> {

    @Override
    protected FragmentOneMineBinding createViewBinding() {
        return FragmentOneMineBinding.inflate(getLayoutInflater());
    }
}
