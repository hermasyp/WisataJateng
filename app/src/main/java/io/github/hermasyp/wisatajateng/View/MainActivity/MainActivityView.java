package io.github.hermasyp.wisatajateng.View.MainActivity;

import io.github.hermasyp.wisatajateng.Model.MainModel.MainModelImp;

/**
 * Created by herma on 23-May-17.
 */

public interface MainActivityView {

    void onSuccess(MainModelImp result);
    void onError(Throwable err);
}
