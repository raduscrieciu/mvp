package com.screechstudios.presenter;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.screechstudios.presenter.presenter.MainView;
import com.screechstudios.presenter.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements MainView {

    private TextView textView;
    private ProgressDialog progress;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the presenter.
        presenter = new Presenter(this);

        textView = (TextView) findViewById(R.id.textView);
        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //execute some business logic
                presenter.startSomeTask();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //execute some additional business logic
                presenter.getSomeResult();
            }
        });
    }

    @Override
    public void showLoading(boolean loading) {
        if (loading) {
            progress.show();
        } else {
            progress.dismiss();
        }
    }

    @Override
    public void displayResult(String result) {
        textView.setText(result);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
