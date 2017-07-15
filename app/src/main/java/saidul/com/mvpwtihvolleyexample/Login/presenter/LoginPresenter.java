package saidul.com.mvpwtihvolleyexample.Login.presenter;

import java.util.HashMap;

import saidul.com.mvpwtihvolleyexample.Login.model.InvokeApi;
import saidul.com.mvpwtihvolleyexample.Login.view.LoginView;
import saidul.com.mvpwtihvolleyexample.Login.view.OnRequestComplete;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/15/17.
 */

public class LoginPresenter {

    LoginView view ;

   public LoginPresenter(LoginView loginView){
        this.view = loginView;
   }

    /**
     *
     */
    public void getIpInformation() {
        view.startLoading();
        new InvokeApi( new OnRequestComplete() {
            @Override
            public void onRequestComplete(Object infoData) {
                view.stopLoading();
                view.showIpInfo((HashMap) infoData);
            }

            @Override
            public void onRequestError(String errorMsg) {
                view.showMessage(errorMsg);
            }
        });

    }



}
