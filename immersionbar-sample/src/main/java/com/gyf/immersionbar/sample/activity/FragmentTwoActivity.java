package com.gyf.immersionbar.sample.activity;

import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityFragmentTwoBinding;
import com.gyf.immersionbar.sample.fragment.two.CategoryTwoFragment;
import com.gyf.immersionbar.sample.fragment.two.HomeTwoFragment;
import com.gyf.immersionbar.sample.fragment.two.MineTwoFragment;
import com.gyf.immersionbar.sample.fragment.two.ServiceTwoFragment;


/**
 * @author geyifeng
 * @date 2017/7/20
 */
public class FragmentTwoActivity extends BaseActivity<ActivityFragmentTwoBinding> implements View.OnClickListener {

    private HomeTwoFragment homeTwoFragment;
    private CategoryTwoFragment categoryTwoFragment;
    private ServiceTwoFragment serviceTwoFragment;
    private MineTwoFragment mineTwoFragment;


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
        } else if (viewId == R.id.ll_category) {
            selectedFragment(1);
            tabSelected(mBinding.tabBottomContainer.llCategory);
        } else if (viewId == R.id.ll_service) {
            selectedFragment(2);
            tabSelected(mBinding.tabBottomContainer.llService);
        } else if (viewId == R.id.ll_mine) {
            selectedFragment(3);
            tabSelected(mBinding.tabBottomContainer.llMine);
        }
    }

    private void selectedFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (position) {
            case 0:
                if (homeTwoFragment == null) {
                    homeTwoFragment = new HomeTwoFragment();
                    transaction.add(R.id.content, homeTwoFragment);
                } else {
                    transaction.show(homeTwoFragment);
                }
                break;
            case 1:
                if (categoryTwoFragment == null) {
                    categoryTwoFragment = new CategoryTwoFragment();
                    transaction.add(R.id.content, categoryTwoFragment);
                } else {
                    transaction.show(categoryTwoFragment);
                }
                break;
            case 2:
                if (serviceTwoFragment == null) {
                    serviceTwoFragment = new ServiceTwoFragment();
                    transaction.add(R.id.content, serviceTwoFragment);
                } else {
                    transaction.show(serviceTwoFragment);
                }
                break;
            case 3:
                if (mineTwoFragment == null) {
                    mineTwoFragment = new MineTwoFragment();
                    transaction.add(R.id.content, mineTwoFragment);
                } else {
                    transaction.show(mineTwoFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (homeTwoFragment != null) {
            transaction.hide(homeTwoFragment);
        }
        if (categoryTwoFragment != null) {
            transaction.hide(categoryTwoFragment);
        }
        if (serviceTwoFragment != null) {
            transaction.hide(serviceTwoFragment);
        }
        if (mineTwoFragment != null) {
            transaction.hide(mineTwoFragment);
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
