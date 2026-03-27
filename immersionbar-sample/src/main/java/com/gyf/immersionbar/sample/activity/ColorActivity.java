package com.gyf.immersionbar.sample.activity;

import android.annotation.SuppressLint;
import android.widget.SeekBar;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityColorBinding;

/**
 * @author geyifeng
 * @date 2017/5/8
 */
public class ColorActivity extends BaseActivity<ActivityColorBinding> {

    @Override
    protected ActivityColorBinding createViewBinding() {
        return ActivityColorBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarView(R.id.top_view)
                .statusBarColor(R.color.colorPrimary)
                .navigationBarColor(R.color.btn8)
                .init();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void setListener() {
        mBinding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float alpha = (float) progress / 100;
                mBinding.textView.setText("透明度:" + alpha + "f");
                ImmersionBar.with(ColorActivity.this).barAlpha(alpha)
                        .statusBarColorTransform(R.color.btn14)
                        .navigationBarColorTransform(R.color.btn3)
                        .addViewSupportTransformColor(mBinding.toolbar)
                        .addViewSupportTransformColor(mBinding.btn1, R.color.btn1, R.color.btn4)
                        .addViewSupportTransformColor(mBinding.btn2, R.color.btn3, R.color.btn12)
                        .addViewSupportTransformColor(mBinding.btn3, R.color.btn5, R.color.btn10)
                        .addViewSupportTransformColor(mBinding.line1, R.color.darker_gray, R.color.btn5)
                        .init();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
