package com.gyf.immersionbar.sample.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.SeekBar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.AppManager;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityPicBinding;
import com.gyf.immersionbar.sample.utils.Utils;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * @author gyf
 * @date 2016/10/24
 */
public class PicActivity extends SwipeBackActivity {

    private ActivityPicBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        mBinding = ActivityPicBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        ImmersionBar.with(this)
                .titleBar(mBinding.seekBar, false)
                .transparentBar()
                .init();
        Glide.with(this).asBitmap().load(Utils.getFullPic())
                .apply(new RequestOptions().placeholder(R.drawable.pic_all))
                .into(mBinding.mIv);
        mBinding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float alpha = (float) progress / 100;
                mBinding.textView.setText("透明度:" + alpha + "f");
                ImmersionBar.with(PicActivity.this)
                        .addViewSupportTransformColor(mBinding.seekBar, R.color.colorPrimary)
                        .navigationBarColorTransform(R.color.orange)
                        .barAlpha(alpha)
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
    }
}
