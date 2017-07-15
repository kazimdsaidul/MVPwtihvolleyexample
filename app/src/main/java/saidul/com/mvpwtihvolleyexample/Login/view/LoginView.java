package saidul.com.mvpwtihvolleyexample.Login.view;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/15/17.
 */

public interface LoginView {

    void showIpInfo(HashMap hashMap);

    void startLoading();

    void stopLoading();

    void showMessage(String msg);

    Context getAppContext();

}
