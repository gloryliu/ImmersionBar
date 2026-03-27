package com.gyf.immersionbar.sample.fragment.four;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.FragmentTwoHomeBinding;
import com.gyf.immersionbar.sample.fragment.BaseFragment;
import com.gyf.immersionbar.sample.utils.Utils;


/**
 * @author geyifeng
 * @date 2017/7/20
 */
public class HomeFourFragment extends BaseFragment<FragmentTwoHomeBinding> {

    @Override
    protected FragmentTwoHomeBinding createViewBinding() {
        return FragmentTwoHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        Glide.with(this).asBitmap().load(Utils.getPic())
                .apply(new RequestOptions().placeholder(R.mipmap.test))
                .into(mBinding.mIv);
    }
}
