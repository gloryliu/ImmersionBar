package com.gyf.immersionbar.sample.fragment.four;


import com.gyf.immersionbar.sample.databinding.FragmentTwoCategoryBinding;
import com.gyf.immersionbar.sample.fragment.BaseFragment;

/**
 * @author geyifeng
 * @date 2017/7/20
 */
public class CategoryFourFragment extends BaseFragment<FragmentTwoCategoryBinding> {

    @Override
    protected FragmentTwoCategoryBinding createViewBinding() {
        return FragmentTwoCategoryBinding.inflate(getLayoutInflater());
    }
}
