package com.gyf.immersionbar.sample.activity;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityFragmentBinding;
import com.gyf.immersionbar.sample.utils.ClickHelper;

/**
 * @author geyifeng
 * @date 2017/7/19
 */
public class FragmentActivity extends BaseActivity<ActivityFragmentBinding> {


    @Override
    protected ActivityFragmentBinding createViewBinding() {
        return ActivityFragmentBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).titleBar(R.id.toolbar).init();
    }

    @Override
    protected void setListener() {
        super.setListener();
        ClickHelper.setClickListeners(mBinding, this::onClick,R.id.btn_one, R.id.btn_two, R.id.btn_three, R.id.btn_four, R.id.btn_five);
    }

    public void onClick(@NonNull View view) {
        int viewId = view.getId();
        if (viewId == R.id.btn_one) {
            startActivity(new Intent(this, FragmentOneActivity.class));
        } else if (viewId == R.id.btn_two) {
            startActivity(new Intent(this, FragmentTwoActivity.class));
        } else if (viewId == R.id.btn_three) {
            startActivity(new Intent(this, FragmentThreeActivity.class));
        } else if (viewId == R.id.btn_four) {
            startActivity(new Intent(this, FragmentFourActivity.class));
        } else if (viewId == R.id.btn_five) {
            startActivity(new Intent(this, FragmentFiveActivity.class));
        }
    }
}
