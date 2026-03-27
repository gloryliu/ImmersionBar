package com.gyf.immersionbar.sample.activity;

import android.view.LayoutInflater;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.sample.R;
import com.gyf.immersionbar.sample.adapter.EditAdapter;
import com.gyf.immersionbar.sample.databinding.ActivityAllEditBinding;

import java.util.ArrayList;

/**
 * @author geyifeng
 */
public class AllEditActivity extends BaseActivity<ActivityAllEditBinding> {


    private ArrayList<String> mData = new ArrayList<>();

    @Override
    protected ActivityAllEditBinding createViewBinding() {
        return ActivityAllEditBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).titleBar(R.id.toolbar).keyboardEnable(true).init();
    }

    @Override
    protected void initData() {
        super.initData();
        for (int i = 0; i < 20; i++) {
            mData.add(String.valueOf(i));
        }
    }

    @Override
    protected void initView() {
        super.initView();
        EditAdapter adapter = new EditAdapter();
        adapter.addHeaderView(LayoutInflater.from(this).inflate(R.layout.item_edit_header, mBinding.recyclerView, false));
        adapter.addFooterView(LayoutInflater.from(this).inflate(R.layout.item_edit_footer, mBinding.recyclerView, false));
        adapter.setNewData(mData);
        mBinding.recyclerView.setAdapter(adapter);
    }
}
