package io.github.hermasyp.wisatajateng.Presenter.DetailsPresenter;

import com.google.gson.Gson;

import io.github.hermasyp.wisatajateng.Model.DetailsModel.DetailsModelImp;
import io.github.hermasyp.wisatajateng.Utills.OkHttpTime;
import io.github.hermasyp.wisatajateng.Utills.RxOkhttp;
import io.github.hermasyp.wisatajateng.View.DetailsActivity.DetailsActivityView;
import okhttp3.Request;
import rx.Observable;

/**
 * Created by herma on 23-May-17.
 */

public class DetailsPresenterImp implements DetailsPresenter {
    DetailsModelImp model;
    DetailsActivityView view;

    public DetailsPresenterImp(DetailsActivityView view) {
        this.model = new DetailsModelImp();
        this.view = view;
    }

    @Override
    public Observable<DetailsModelImp> getResult(String id) {
        Request request = model.build(id);
        return RxOkhttp.streamStrings(OkHttpTime.client,request).map(stringJson ->
                new Gson().fromJson(stringJson,DetailsModelImp.class));
    }
}
