package com.gyf.immersionbar.sample.fragment.four;

import com.gyf.immersionbar.sample.databinding.FragmentTwoServiceBinding;
import com.gyf.immersionbar.sample.fragment.BaseFragment;

/**
 * @author geyifeng
 * @date 2017/7/20
 */
public class ServiceFourFragment extends BaseFragment<FragmentTwoServiceBinding> {

    @Override
    protected FragmentTwoServiceBinding createViewBinding() {
        return FragmentTwoServiceBinding.inflate(getLayoutInflater());
    }
}
