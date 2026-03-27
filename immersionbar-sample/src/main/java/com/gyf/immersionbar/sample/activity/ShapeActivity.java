package com.gyf.immersionbar.sample.activity;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityShapeBinding;

/**
 * @author geyifeng
 * @date 2017/6/6
 */
public class ShapeActivity extends BaseActivity<ActivityShapeBinding> {


    @Override
    protected ActivityShapeBinding createViewBinding() {
        return ActivityShapeBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).titleBar(R.id.toolbar)
                .navigationBarColor(R.color.shape1)
                .init();
    }
}
