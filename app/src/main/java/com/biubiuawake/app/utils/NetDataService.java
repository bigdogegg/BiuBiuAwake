package com.biubiuawake.app.utils;

import com.biubiuawake.app.Beans.GitBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2016/3/9 0009.
 */
public interface NetDataService {
    @GET("/users/{user}")
    Observable<GitBean> getUser(@Path("user") String user);
}
