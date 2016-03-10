package com.biubiuawake.app.mvp.model;

import com.biubiuawake.app.Beans.GitBean;
import com.biubiuawake.app.utils.MainRetrofit;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/3/10 0010.
 */
public class NetModelImpl implements NetModel{

    @Override
    public void loadNetData(String param, final OnNetRequestListener onNetRequestListener) {
        MainRetrofit.instance.getNetDataService()
                .getUser(param)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GitBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetRequestListener.onError(e);
                    }

                    @Override
                    public void onNext(GitBean gitBean) {
                        onNetRequestListener.onSuccess(gitBean);
                    }
                });
    }

    public interface OnNetRequestListener{
        void onSuccess(GitBean gitBean);
        void onError(Throwable e);
    }
}
