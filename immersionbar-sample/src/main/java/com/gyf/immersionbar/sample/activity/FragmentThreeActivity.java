package com.gyf.immersionbar.sample.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityFragmentOneBinding;
import com.gyf.immersionbar.sample.fragment.three.CategoryThreeFragment;
import com.gyf.immersionbar.sample.fragment.three.HomeThreeFragment;
import com.gyf.immersionbar.sample.fragment.three.MineThreeFragment;
import com.gyf.immersionbar.sample.fragment.three.ServiceThreeFragment;

import java.util.ArrayList;


/**
 * @author geyifeng
 * @date 2017/5/8
 */
public class FragmentThreeActivity extends BaseActivity<ActivityFragmentOneBinding> implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ArrayList<Fragment> mFragments;


    @Override
    protected ActivityFragmentOneBinding createViewBinding() {
        return ActivityFragmentOneBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).navigationBarColor(R.color.colorPrimary).init();
    }

    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        HomeThreeFragment homeThreeFragment = new HomeThreeFragment();
        CategoryThreeFragment categoryThreeFragment = new CategoryThreeFragment();
        ServiceThreeFragment serviceThreeFragment = new ServiceThreeFragment();
        MineThreeFragment mineThreeFragment = new MineThreeFragment();
        mFragments.add(homeThreeFragment);
        mFragments.add(categoryThreeFragment);
        mFragments.add(serviceThreeFragment);
        mFragments.add(mineThreeFragment);
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
                ImmersionBar.with(this).keyboardEnable(false).statusBarDarkFont(false).navigationBarColor(R.color.colorPrimary).init();
                break;
            case 1:
                tabSelected(mBinding.tabBottomContainer.llCategory);
                ImmersionBar.with(this).keyboardEnable(false).statusBarDarkFont(true, 0.2f).navigationBarColor(R.color.btn3).init();
                break;
            case 2:
                tabSelected(mBinding.tabBottomContainer.llService);
                ImmersionBar.with(this).keyboardEnable(false).statusBarDarkFont(false).navigationBarColor(R.color.btn13).init();
                break;
            case 3:
                tabSelected(mBinding.tabBottomContainer.llMine);
                ImmersionBar.with(this).keyboardEnable(true).statusBarDarkFont(true).navigationBarColor(R.color.btn1).init();
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
