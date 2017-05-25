package io.github.hermasyp.wisatajateng.Model.DetailsModel;

import okhttp3.Request;

/**
 * Created by herma on 23-May-17.
 */

public interface DetailModel {
    Request build(String id);
}
