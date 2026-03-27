package com.gyf.immersionbar.sample.fragment.dialog;

import android.content.res.Configuration;
import androidx.appcompat.widget.Toolbar;
import android.view.Gravity;
import android.view.ViewGroup;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.DialogBinding;

/**
 * 左边DialogFragment
 *
 * @author geyifeng
 * @date 2017/7/28
 */
public class LeftDialogFragment extends BaseDialogFragment<DialogBinding> {

    @Override
    public void onStart() {
        super.onStart();
        mWindow.setGravity(Gravity.TOP | Gravity.START);
        mWindow.setWindowAnimations(R.style.LeftAnimation);
        mWindow.setLayout(mWidthAndHeight[0] / 2, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).titleBar(mBinding.toolbar)
                .navigationBarColor(R.color.btn11)
                .keyboardEnable(true)
                .navigationBarWithKitkatEnable(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                .init();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mWindow.setLayout(mWidthAndHeight[0] / 2, ViewGroup.LayoutParams.MATCH_PARENT);
        ImmersionBar.with(this)
                .navigationBarWithKitkatEnable(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
                .init();
    }

    @Override
    protected DialogBinding createViewBinding() {
        return DialogBinding.inflate(getLayoutInflater());
    }
}
