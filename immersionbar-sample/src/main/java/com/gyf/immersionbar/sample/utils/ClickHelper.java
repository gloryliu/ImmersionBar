package com.gyf.immersionbar.sample.utils;

import android.view.View;

import androidx.viewbinding.ViewBinding;

/**
 * @author cake
 * @date 2026/3/27 09:12
 * @desc
 */
public class ClickHelper {
    // 批量设置点击事件
    public static void setClickListeners(View.OnClickListener listener, View... views) {
        for (View view : views) {
            view.setOnClickListener(listener);
        }
    }

    // 通过ID批量设置（需要binding）
    public static void setClickListeners(ViewBinding binding,
                                         View.OnClickListener listener,
                                         int... viewIds) {
        for (int id : viewIds) {
            View view = binding.getRoot().findViewById(id);
            if (view != null) {
                view.setOnClickListener(listener);
            }
        }
    }

    // 链式调用设置
    public static <T extends View> T onClick(T view, View.OnClickListener listener) {
        view.setOnClickListener(listener);
        return view;
    }
}
