package saidul.com.mvpwtihvolleyexample.Login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.HashMap;

import saidul.com.mvpwtihvolleyexample.Login.presenter.LoginPresenter;
import saidul.com.mvpwtihvolleyexample.Login.view.LoginView;
import saidul.com.mvpwtihvolleyexample.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tvIPAddress);

        // create presenter and call get ip information
        LoginPresenter loginPresenter = new LoginPresenter(this);
        loginPresenter.getIpInformation();

    }

    @Override
    public void showIpInfo(HashMap hashMap) {

        Logger.d("i am message form view");
        Logger.d(hashMap);
        textView.setText(""+hashMap.get("ip"));

    }

    @Override
    public void startLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public Context getAppContext() {
        return null;
    }
}
