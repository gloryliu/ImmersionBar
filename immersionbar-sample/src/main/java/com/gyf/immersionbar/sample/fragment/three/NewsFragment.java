package com.gyf.immersionbar.sample.fragment.three;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.gyf.immersionbar.sample.databinding.FragmentNewsBinding;
import com.gyf.immersionbar.sample.fragment.BaseFragment;

/**
 * @author geyifeng
 * @date 2019-05-05 17:35
 */
public class NewsFragment extends BaseFragment<FragmentNewsBinding> {

    private String mTitle = "";

    public static NewsFragment newInstance(String title) {
        NewsFragment newsFragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        newsFragment.setArguments(bundle);
        return newsFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mTitle = arguments.getString("title");
        }
    }

    @Override
    protected FragmentNewsBinding createViewBinding() {
        return FragmentNewsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        super.initView();
        mBinding.tvContent.setText(mTitle);
    }
}
