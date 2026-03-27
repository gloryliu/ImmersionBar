package com.gyf.immersionbar.sample.fragment.three;

import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.FragmentOneServiceBinding;
import com.gyf.immersionbar.sample.fragment.BaseFragment;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class ServiceThreeFragment extends BaseFragment<FragmentOneServiceBinding> {

    @Override
    protected FragmentOneServiceBinding createViewBinding() {
        return FragmentOneServiceBinding.inflate(getLayoutInflater());
    }
}
