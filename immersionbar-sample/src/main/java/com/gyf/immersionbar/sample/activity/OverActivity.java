package com.gyf.immersionbar.sample.activity;

import android.content.Intent;
import android.view.View;


import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.databinding.ActivityOverBinding;
import com.gyf.immersionbar.sample.utils.ClickHelper;


/**
 * @author geyifeng
 * @date 2017/5/8
 */
public class OverActivity extends BaseActivity<ActivityOverBinding> {


    @Override
    protected ActivityOverBinding createViewBinding() {
        return ActivityOverBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        String text = "请看这个页面的Toolbar和状态栏重叠啦，怎么解决呢？" +
                "不急不急，先说说沉浸式的原理吧！" +
                "原理：其实沉浸式就是把整个布局拉伸到全屏显示，这样自然而然就会使得布局的最顶端和状态栏重合了，" +
                "好吧，以下给出五种解决方案，大家根据项目需求自己看着使用哦，不可结合使用。";
        mBinding.text.setText(text);
    }

    @Override
    protected void setListener() {
        super.setListener();
        ClickHelper.setClickListeners(mBinding, this::onClick, R.id.btn_one, R.id.btn_two, R.id.btn_three, R.id.btn_four, R.id.btn_five, R.id.btn_six);
    }

    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btn_one) {
            startActivity(new Intent(this, Over1Activity.class));
        } else if (viewId == R.id.btn_two) {
            startActivity(new Intent(this, Over2Activity.class));
        } else if (viewId == R.id.btn_three) {
            startActivity(new Intent(this, Over3Activity.class));
        } else if (viewId == R.id.btn_four) {
            startActivity(new Intent(this, Over4Activity.class));
        } else if (viewId == R.id.btn_five) {
            startActivity(new Intent(this, Over5Activity.class));
        } else if (viewId == R.id.btn_six) {
            startActivity(new Intent(this, Over6Activity.class));
        }
    }
}
