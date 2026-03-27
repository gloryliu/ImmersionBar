package com.gyf.immersionbar.sample.fragment.dialog;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.DialogBinding;

/**
 * 全屏DialogFragment
 *
 * @author geyifeng
 * @date 2017/7/28
 */
public class FullDialogFragment extends BaseDialogFragment<DialogBinding> {

    @Override
    public void onStart() {
        super.onStart();
        mWindow.setWindowAnimations(R.style.RightAnimation);
    }

    @Override
    protected DialogBinding createViewBinding() {
        return DialogBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .titleBar(mBinding.toolbar)
                .statusBarDarkFont(true)
                .navigationBarColor(R.color.btn3)
                .keyboardEnable(true)
                .init();
    }
}
