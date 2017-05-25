package io.github.hermasyp.wisatajateng.Presenter.MainPresenter;

import com.google.gson.Gson;

import io.github.hermasyp.wisatajateng.Model.MainModel.MainModel;
import io.github.hermasyp.wisatajateng.Model.MainModel.MainModelImp;
import io.github.hermasyp.wisatajateng.Utills.OkHttpTime;
import io.github.hermasyp.wisatajateng.Utills.RxOkhttp;
import io.github.hermasyp.wisatajateng.View.MainActivity.MainActivityView;
import okhttp3.Request;
import rx.Observable;

/**
 * Created by herma on 23-May-17.
 */

public class MainPresenterImp implements MainPresenter{

    MainModel mainModel;
    MainActivityView mainActivityView;

    public MainPresenterImp(MainActivityView mainActivityView) {
        mainModel = new MainModelImp();
        this.mainActivityView = mainActivityView;
    }

    @Override
    public Observable<MainModelImp> getResult() {
        Request request = mainModel.build();
        return RxOkhttp.streamStrings(OkHttpTime.client,request).map(stringJson ->
                new Gson().fromJson(stringJson,MainModelImp.class));
    }
}
