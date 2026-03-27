package com.gyf.immersionbar.sample.fragment.four;


import com.gyf.immersionbar.sample.databinding.FragmentTwoMineBinding;
import com.gyf.immersionbar.sample.fragment.BaseFragment;

/**
 * @author geyifeng
 * @date 2017/7/20
 */
public class MineFourFragment extends BaseFragment<FragmentTwoMineBinding> {

    @Override
    protected FragmentTwoMineBinding createViewBinding() {
        return FragmentTwoMineBinding.inflate(getLayoutInflater());
    }
}
