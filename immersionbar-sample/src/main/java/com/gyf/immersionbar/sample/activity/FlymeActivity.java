package com.gyf.immersionbar.sample.activity;

import android.widget.Toast;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityFlymeBinding;

/**
 * @author geyifeng
 * @date 2017/5/31
 */
public class FlymeActivity extends BaseActivity<ActivityFlymeBinding> {

    @Override
    protected ActivityFlymeBinding createViewBinding() {
        return ActivityFlymeBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarView(R.id.top_view).init();
    }

    @Override
    protected void setListener() {
        mBinding.btn.setOnClickListener(v -> {
            String s = "#" + mBinding.et.getText().toString();
            if (s.length() == 7) {
                ImmersionBar.with(this).flymeOSStatusBarFontColor(s).init();
            } else {
                Toast.makeText(FlymeActivity.this, "请正确输入6位颜色值", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
