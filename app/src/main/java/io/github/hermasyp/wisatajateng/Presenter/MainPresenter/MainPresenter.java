package io.github.hermasyp.wisatajateng.Presenter.MainPresenter;

import io.github.hermasyp.wisatajateng.Model.MainModel.MainModelImp;
import rx.Observable;

/**
 * Created by herma on 23-May-17.
 */

public interface MainPresenter {

    Observable<MainModelImp> getResult();
}
