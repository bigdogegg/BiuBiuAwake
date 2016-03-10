package com.biubiuawake.app.mvp.view;

import com.biubiuawake.app.Beans.GitBean;

/**
 * Created by Administrator on 2016/3/10 0010.
 */
public interface NetViews {
    void showProgress();
    void hideProgress();
    void getNetData(GitBean gitBean);
    void showGetNetDataError(Throwable e);
}
