package com.gyf.immersionbar.sample.fragment.three;

import com.gyf.immersionbar.sample.adapter.NewsAdapter;
import com.gyf.immersionbar.sample.databinding.FragmentThreeCategoryBinding;
import com.gyf.immersionbar.sample.fragment.BaseFragment;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class CategoryThreeFragment extends BaseFragment<FragmentThreeCategoryBinding> {

    private String[] mTabName = {"关注", "头条", "视频", "娱乐", "体育", "新时代", "要闻", "知否", "段子", "本地", "公开课", "财经", "科技", "汽车"};


    @Override
    protected FragmentThreeCategoryBinding createViewBinding() {
        return FragmentThreeCategoryBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        super.initView();
        for (String s : mTabName) {
            mBinding.tabLayout.addTab(mBinding.tabLayout.newTab().setText(s));
        }
        mBinding.viewPager.setAdapter(new NewsAdapter(getChildFragmentManager(), mTabName));
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);
    }
}
