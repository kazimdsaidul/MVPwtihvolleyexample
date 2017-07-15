package saidul.com.mvpwtihvolleyexample.Login.model;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import java.util.HashMap;

import saidul.com.mvpwtihvolleyexample.Login.view.OnRequestComplete;
import saidul.com.mvpwtihvolleyexample.applcaiton.AppController;
import saidul.com.mvpwtihvolleyexample.url.AllUrl;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/15/17.
 */

public class InvokeApi {
    OnRequestComplete requestComplete;

    public InvokeApi(OnRequestComplete onRequestComplete) {
        this.requestComplete = onRequestComplete;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, AllUrl.loginURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Logger.json(response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    HashMap hashMap = new HashMap();
                    hashMap.put("ip", jsonObject.getString("ip"));
                    hashMap.put("country", jsonObject.getString("country"));
                    hashMap.put("location", jsonObject.getString("loc"));
                    requestComplete.onRequestComplete(hashMap);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logger.json(error.toString());
                requestComplete.onRequestError(error.toString());
            }
        });


        // Add the request to the RequestQueue.
        AppController.getInstance().getRequestQueue().add(stringRequest);

    }


}
