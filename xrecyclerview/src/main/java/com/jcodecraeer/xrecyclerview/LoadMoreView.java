package com.jcodecraeer.xrecyclerview;

import android.view.View;

/**
 * @author dengyuhan
 *         created 2018/7/4 14:25
 */
public interface LoadMoreView {

    /**
     * 正常
     */
    int NORMAL = 0;
    /**
     * 加载中..
     */
    int LOADING = 1;
    /**
     * 异常
     */
    int ERROR = 2;
    /**
     * 加载到最底了
     */
    int THE_END = 3;

    void setState(int state);

    View getView();
}
