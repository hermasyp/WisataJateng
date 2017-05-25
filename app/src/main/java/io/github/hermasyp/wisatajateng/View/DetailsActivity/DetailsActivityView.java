package io.github.hermasyp.wisatajateng.View.DetailsActivity;

import io.github.hermasyp.wisatajateng.Model.DetailsModel.DetailsModelImp;

/**
 * Created by herma on 23-May-17.
 */

public interface DetailsActivityView {
    void onSuccess(DetailsModelImp result);
    void onError(Throwable err);
}
