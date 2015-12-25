package com.screechstudios.presenter.presenter;


public interface MainView {

    void showLoading(boolean loading);

    void displayResult(String result);

    void showToast(String message);
}
