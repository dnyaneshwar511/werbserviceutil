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
    private static Object object;

    public static Object OnLunch(final Context context, CheckVersionRequestModel checkVersionRequestModel, final String requestType, String API_URL)
    {
        //LsDialog.showProgressDialog(SplashActivity.this);
        OnLounchTask checkVersionTask = new OnLounchTask((Activity) context, requestType, checkVersionRequestModel, API_URL, new OnHttpResponseReceived()
        {
            @Override
            public void onResponseReceived(Object response, HttpResponseStatus responseStatus, int status)
            {
                object = response;
            }

        });
        checkVersionTask.execute();

        return object;
    }
}
