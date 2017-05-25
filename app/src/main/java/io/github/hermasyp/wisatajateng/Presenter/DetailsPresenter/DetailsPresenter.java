package io.github.hermasyp.wisatajateng.Presenter.DetailsPresenter;

import io.github.hermasyp.wisatajateng.Model.DetailsModel.DetailsModelImp;
import rx.Observable;

/**
 * Created by herma on 23-May-17.
 */

public interface DetailsPresenter {
    Observable<DetailsModelImp> getResult(String id);
}
