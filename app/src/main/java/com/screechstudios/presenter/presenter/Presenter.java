package com.screechstudios.presenter.presenter;

import android.os.Handler;

public class Presenter {

    MainView mainView;

    public Presenter(MainView presenterActions) {
        this.mainView = presenterActions;
    }

    /**
     * Business logic
     */
    public void startSomeTask() {

        mainView.showLoading(true);

        //simulate some operation.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mainView.displayResult("All done!");
                mainView.showLoading(false);
            }
        }, 3000);
    }

    /**
     * Even more business logic
     */
    public void getSomeResult() {
        mainView.showToast("Here's your result!");
    }
}
