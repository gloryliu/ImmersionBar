package com.gyf.immersionbar.sample.fragment.five;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;


import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityFragmentTwoBinding;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author geyifeng
 * @date 2017/8/12
 */
public class MainFragment extends BaseFiveFragment<ActivityFragmentTwoBinding> implements View.OnClickListener {

    private SupportFragment[] mFragments = new SupportFragment[4];

    public static final int HOME = 0;
    public static final int CATEGORY = 1;
    public static final int SERVICE = 2;
    public static final int MINE = 3;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportFragment homeFiveFragment = findChildFragment(HomeFiveFragment.class);
        if (homeFiveFragment == null) {
            mFragments[HOME] = HomeFiveFragment.newInstance();
            mFragments[CATEGORY] = CategoryFiveFragment.newInstance();
            mFragments[SERVICE] = ServiceFiveFragment.newInstance();
            mFragments[MINE] = MineFiveFragment.newInstance();

            loadMultipleRootFragment(R.id.content, HOME,
                    mFragments[HOME],
                    mFragments[CATEGORY],
                    mFragments[SERVICE],
                    mFragments[MINE]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.findFragmentByTag自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[HOME] = homeFiveFragment;
            mFragments[CATEGORY] = findChildFragment(CategoryFiveFragment.class);
            mFragments[SERVICE] = findChildFragment(ServiceFiveFragment.class);
            mFragments[MINE] = findChildFragment(MineFiveFragment.class);
        }
    }

    @Override
    protected ActivityFragmentTwoBinding createViewBinding() {
        return ActivityFragmentTwoBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        tabSelected(mBinding.tabBottomContainer.llHome);
    }

    @Override
    protected void setListener() {
        mBinding.tabBottomContainer.llHome.setOnClickListener(this);
        mBinding.tabBottomContainer.llCategory.setOnClickListener(this);
        mBinding.tabBottomContainer.llService.setOnClickListener(this);
        mBinding.tabBottomContainer.llMine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.ll_home) {
            showHideFragment(mFragments[HOME]);
            tabSelected(mBinding.tabBottomContainer.llHome);
        } else if (viewId == R.id.ll_category) {
            showHideFragment(mFragments[CATEGORY]);
            tabSelected(mBinding.tabBottomContainer.llCategory);
        } else if (viewId == R.id.ll_service) {
            showHideFragment(mFragments[SERVICE]);
            tabSelected(mBinding.tabBottomContainer.llService);
        } else if (viewId == R.id.ll_mine) {
            showHideFragment(mFragments[MINE]);
            tabSelected(mBinding.tabBottomContainer.llMine);
        }
    }

    private void tabSelected(LinearLayout linearLayout) {
        mBinding.tabBottomContainer.llHome.setSelected(false);
        mBinding.tabBottomContainer.llCategory.setSelected(false);
        mBinding.tabBottomContainer.llService.setSelected(false);
        mBinding.tabBottomContainer.llMine.setSelected(false);
        linearLayout.setSelected(true);
    }
}
