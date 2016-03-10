package com.biubiuawake.app.mvp.model;

/**
 * Created by Administrator on 2016/3/10 0010.
 */
public interface NetModel {
    void loadNetData(String param,NetModelImpl.OnNetRequestListener onNetRequestListener);
}
