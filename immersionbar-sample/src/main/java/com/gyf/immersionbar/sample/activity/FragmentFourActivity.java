package com.gyf.immersionbar.sample.activity;

import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityFragmentTwoBinding;
import com.gyf.immersionbar.sample.fragment.four.CategoryFourFragment;
import com.gyf.immersionbar.sample.fragment.four.HomeFourFragment;
import com.gyf.immersionbar.sample.fragment.four.MineFourFragment;
import com.gyf.immersionbar.sample.fragment.four.ServiceFourFragment;

/**
 * @author geyifeng
 * @date 2017/7/20
 */
public class FragmentFourActivity extends BaseActivity<ActivityFragmentTwoBinding> implements View.OnClickListener {

    private HomeFourFragment homeFourFragment;
    private CategoryFourFragment categoryFourFragment;
    private ServiceFourFragment serviceFourFragment;
    private MineFourFragment mineFourFragment;

    protected int getLayoutId() {
        return R.layout.activity_fragment_two;
    }

    @Override
    protected ActivityFragmentTwoBinding createViewBinding() {
        return ActivityFragmentTwoBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        selectedFragment(0);
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
            selectedFragment(0);
            tabSelected(mBinding.tabBottomContainer.llHome);
            ImmersionBar.with(this).keyboardEnable(false).statusBarDarkFont(false).navigationBarColor(R.color.colorPrimary).init();
        } else if (viewId == R.id.ll_category) {
            selectedFragment(1);
            tabSelected(mBinding.tabBottomContainer.llCategory);
            ImmersionBar.with(this).keyboardEnable(true).statusBarDarkFont(true, 0.2f).navigationBarColor(R.color.btn1).init();
        } else if (viewId == R.id.ll_service) {
            selectedFragment(2);
            tabSelected(mBinding.tabBottomContainer.llService);
            ImmersionBar.with(this).keyboardEnable(false).statusBarDarkFont(true, 0.2f).navigationBarColor(R.color.btn2).init();
        } else if (viewId == R.id.ll_mine) {
            selectedFragment(3);
            tabSelected(mBinding.tabBottomContainer.llMine);
            ImmersionBar.with(this).keyboardEnable(true).statusBarDarkFont(false).navigationBarColor(R.color.btn7).init();
        }
    }

    private void selectedFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (position) {
            case 0:
                if (homeFourFragment == null) {
                    homeFourFragment = new HomeFourFragment();
                    transaction.add(R.id.content, homeFourFragment);
                } else {
                    transaction.show(homeFourFragment);
                }
                break;
            case 1:
                if (categoryFourFragment == null) {
                    categoryFourFragment = new CategoryFourFragment();
                    transaction.add(R.id.content, categoryFourFragment);
                } else {
                    transaction.show(categoryFourFragment);
                }
                break;
            case 2:
                if (serviceFourFragment == null) {
                    serviceFourFragment = new ServiceFourFragment();
                    transaction.add(R.id.content, serviceFourFragment);
                } else {
                    transaction.show(serviceFourFragment);
                }
                break;
            case 3:
                if (mineFourFragment == null) {
                    mineFourFragment = new MineFourFragment();
                    transaction.add(R.id.content, mineFourFragment);
                } else {
                    transaction.show(mineFourFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (homeFourFragment != null) {
            transaction.hide(homeFourFragment);
        }
        if (categoryFourFragment != null) {
            transaction.hide(categoryFourFragment);
        }
        if (serviceFourFragment != null) {
            transaction.hide(serviceFourFragment);
        }
        if (mineFourFragment != null) {
            transaction.hide(mineFourFragment);
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
