package com.biubiuawake.app.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.biubiuawake.app.Beans.GitBean;
import com.biubiuawake.app.R;
import com.biubiuawake.app.mvp.presenter.NetPresenterImpl;
import com.biubiuawake.app.mvp.view.NetViews;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements NetViews{
    @Bind(R.id.pb)
    ProgressBar pb;
    @Bind(R.id.content)
    TextView tv;
    @Bind(R.id.editText)
    EditText et;
    private NetPresenterImpl mNetPresenterImpl;
    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
    @Override
    protected void init() {
        mNetPresenterImpl = new NetPresenterImpl(this);
    }
    @OnClick(R.id.Button01)
    void clickButton() {
        InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(getCurrentFocus().getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        String param = String.valueOf(et.getText()).trim();
        if(TextUtils.isEmpty(param)){
            param = "bigdogegg";
        }
        mNetPresenterImpl.loadNetData(param);
    }
    @Override
    public void showProgress() {
        pb.setVisibility(View.VISIBLE);
    }
    @Override
    public void hideProgress() {
        pb.setVisibility(View.GONE);
    }
    @Override
    public void getNetData(GitBean gitBean) {
        tv.setText(gitBean.toString());
    }
    @Override
    public void showGetNetDataError(Throwable e) {

    }
}
