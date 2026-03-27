package com.gyf.immersionbar.sample.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityFragmentOneBinding;
import com.gyf.immersionbar.sample.fragment.one.CategoryOneFragment;
import com.gyf.immersionbar.sample.fragment.one.HomeOneFragment;
import com.gyf.immersionbar.sample.fragment.one.MineOneFragment;
import com.gyf.immersionbar.sample.fragment.one.ServiceOneFragment;

import java.util.ArrayList;


/**
 * @author geyifeng
 * @date 2017/5/8
 */
public class FragmentOneActivity extends BaseActivity<ActivityFragmentOneBinding> implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ArrayList<Fragment> mFragments;


    @Override
    protected ActivityFragmentOneBinding createViewBinding() {
        return ActivityFragmentOneBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        HomeOneFragment homeOneFragment = new HomeOneFragment();
        CategoryOneFragment categoryOneFragment = new CategoryOneFragment();
        ServiceOneFragment serviceOneFragment = new ServiceOneFragment();
        MineOneFragment mineOneFragment = new MineOneFragment();
        mFragments.add(homeOneFragment);
        mFragments.add(categoryOneFragment);
        mFragments.add(serviceOneFragment);
        mFragments.add(mineOneFragment);
    }

    @Override
    protected void initView() {
        mBinding.viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mBinding.viewPager.setOffscreenPageLimit(3);
        mBinding.tabBottomContainer.llHome.setSelected(true);
    }

    @Override
    protected void setListener() {
        mBinding.tabBottomContainer.llHome.setOnClickListener(this);
        mBinding.tabBottomContainer.llCategory.setOnClickListener(this);
        mBinding.tabBottomContainer.llService.setOnClickListener(this);
        mBinding.tabBottomContainer.llMine.setOnClickListener(this);
        mBinding.viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.ll_home) {
            mBinding.viewPager.setCurrentItem(0);
            tabSelected(mBinding.tabBottomContainer.llHome);
        } else if (viewId == R.id.ll_category) {
            mBinding.viewPager.setCurrentItem(1);
            tabSelected(mBinding.tabBottomContainer.llCategory);
        } else if (viewId == R.id.ll_service) {
            mBinding.viewPager.setCurrentItem(2);
            tabSelected(mBinding.tabBottomContainer.llService);
        } else if (viewId == R.id.ll_mine) {
            mBinding.viewPager.setCurrentItem(3);
            tabSelected(mBinding.tabBottomContainer.llMine);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                tabSelected(mBinding.tabBottomContainer.llHome);
                break;
            case 1:
                tabSelected(mBinding.tabBottomContainer.llCategory);
                break;
            case 2:
                tabSelected(mBinding.tabBottomContainer.llService);
                break;
            case 3:
                tabSelected(mBinding.tabBottomContainer.llMine);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void tabSelected(LinearLayout linearLayout) {
        mBinding.tabBottomContainer.llHome.setSelected(false);
        mBinding.tabBottomContainer.llCategory.setSelected(false);
        mBinding.tabBottomContainer.llService.setSelected(false);
        mBinding.tabBottomContainer.llMine.setSelected(false);
        linearLayout.setSelected(true);
    }

    private class MyAdapter extends FragmentPagerAdapter {
        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
