package com.gyf.immersionbar.sample.fragment.two;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.FragmentTwoHomeBinding;
import com.gyf.immersionbar.sample.fragment.BaseImmersionFragment;
import com.gyf.immersionbar.sample.utils.Utils;


/**
 * @author geyifeng
 * @date 2017/7/20
 */

public class HomeTwoFragment extends BaseImmersionFragment<FragmentTwoHomeBinding> {

    @Override
    protected FragmentTwoHomeBinding createViewBinding() {
        return FragmentTwoHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .navigationBarColor(R.color.colorPrimary)
                .keyboardEnable(false)
                .init();
    }

    @Override
    protected void initView() {
        super.initView();
        Glide.with(this).asBitmap().load(Utils.getPic())
                .apply(new RequestOptions().placeholder(R.mipmap.test))
                .into(mBinding.mIv);
    }
}
