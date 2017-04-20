package libs.in.webserviceutil.wscalls;

import android.app.Activity;
import android.content.Context;

import libs.in.webserviceutil.wscalls.constant.OnHttpResponseReceived;
import libs.in.webserviceutil.wscalls.models.CheckVersionRequestModel;

/**
 * Created by apple on 20/04/17.
 */

public class MainClass
{
    public static void OnLunch(final Context context, CheckVersionRequestModel checkVersionRequestModel, String requestType, String API_URL)
    {
        //LsDialog.showProgressDialog(SplashActivity.this);
        OnLounchTask checkVersionTask = new OnLounchTask((Activity) context, requestType, checkVersionRequestModel, API_URL, new OnHttpResponseReceived()
        {

            @Override
            public void onResponseReceived(Object response, HttpResponseStatus responseStatus, int status)
            {

                if (responseStatus == HttpResponseStatus.RESPONSE_RECEIVED)
                {

                }


            }


        });
        checkVersionTask.execute();

    }

}
