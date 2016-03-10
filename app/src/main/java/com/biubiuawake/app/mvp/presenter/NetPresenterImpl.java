package com.biubiuawake.app.mvp.presenter;

import com.biubiuawake.app.Beans.GitBean;
import com.biubiuawake.app.mvp.model.NetModel;
import com.biubiuawake.app.mvp.model.NetModelImpl;
import com.biubiuawake.app.mvp.view.NetViews;

/**
 * Created by Administrator on 2016/3/10 0010.
 */
public class NetPresenterImpl implements NetPresenter,NetModelImpl.OnNetRequestListener{
    private NetViews mNetViews;
    private NetModel mNetModel;
    public NetPresenterImpl(NetViews netViews){
        this.mNetViews = netViews;
        mNetModel = new NetModelImpl();
    }
    @Override
    public void loadNetData(String param) {
        mNetViews.showProgress();
        mNetModel.loadNetData(param,this);
    }

    @Override
    public void onSuccess(GitBean gitBean) {
        mNetViews.hideProgress();
        mNetViews.getNetData(gitBean);
    }

    @Override
    public void onError(Throwable e) {
        mNetViews.hideProgress();
        mNetViews.showGetNetDataError(e);
    }
}
