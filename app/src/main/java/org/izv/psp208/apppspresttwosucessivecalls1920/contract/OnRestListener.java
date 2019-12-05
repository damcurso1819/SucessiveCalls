package org.izv.psp208.apppspresttwosucessivecalls1920.contract;

public interface OnRestListener {

    void onError(String message);
    void onSuccess(long id);

}