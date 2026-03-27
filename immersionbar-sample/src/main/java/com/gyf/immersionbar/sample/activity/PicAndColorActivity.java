package com.gyf.immersionbar.sample.activity;

import androidx.viewbinding.ViewBinding;

import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityPicColorBinding;
import com.gyf.immersionbar.sample.utils.ClickHelper;
import com.gyf.immersionbar.sample.utils.Utils;

/**
 * @author gyf
 * @date 2016/10/24
 */
public class PicAndColorActivity extends BaseActivity<ActivityPicColorBinding> implements SeekBar.OnSeekBarChangeListener {

    @Override
    protected ActivityPicColorBinding createViewBinding() {
        return ActivityPicColorBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarView(R.id.top_view)
                .navigationBarColor(R.color.colorPrimary)
                .fullScreen(true)
                .addTag("PicAndColor")
                .init();
    }

    @Override
    protected void initView() {
        super.initView();
        Glide.with(this).asBitmap().load(Utils.getPic())
                .apply(new RequestOptions().placeholder(R.mipmap.test))
                .into(mBinding.mIv);
    }

    @Override
    protected void setListener() {
        mBinding.seekBar.setOnSeekBarChangeListener(this);
        ClickHelper.setClickListeners(mBinding, this::onClick, R.id.btn_status_color, R.id.btn_navigation_color, R.id.btn_color);
    }

    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btn_status_color) {
            ImmersionBar.with(this).statusBarColor(R.color.colorAccent).init();
        } else if (viewId == R.id.btn_navigation_color) {
            if (ImmersionBar.hasNavigationBar(this)) {
                ImmersionBar.with(this).navigationBarColor(R.color.colorAccent).init();
            } else {
                Toast.makeText(this, "当前设备没有导航栏", Toast.LENGTH_SHORT).show();
            }
        } else if (viewId == R.id.btn_color) {
            ImmersionBar.with(this).getTag("PicAndColor").init();
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        float alpha = (float) progress / 100;
        ImmersionBar.with(this)
                .statusBarColorTransform(R.color.orange)
                .navigationBarColorTransform(R.color.tans)
                .addViewSupportTransformColor(mBinding.toolbar)
                .barAlpha(alpha)
                .init();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
