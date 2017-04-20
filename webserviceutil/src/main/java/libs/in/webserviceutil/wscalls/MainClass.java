package libs.in.webserviceutil.wscalls;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import libs.in.webserviceutil.wscalls.constant.OnHttpResponseReceived;
import libs.in.webserviceutil.wscalls.models.CheckVersionRequestModel;
import libs.in.webserviceutil.wscalls.models.ErrorResponse;

/**
 * Created by apple on 20/04/17.
 */

public class MainClass
{
    private static Object object;
    List<ErrorResponse.errors> errorses = new ArrayList<ErrorResponse.errors>();

    public static Object OnLunch(final Context context, CheckVersionRequestModel checkVersionRequestModel, final String requestType, String API_URL)
    {
        //LsDialog.showProgressDialog(SplashActivity.this);
        OnLounchTask checkVersionTask = new OnLounchTask((Activity) context, requestType, checkVersionRequestModel, API_URL, new OnHttpResponseReceived()
        {
            @Override
            public void onResponseReceived(Object response, HttpResponseStatus responseStatus, int status)
            {

                response = "{\"requestId\":\"03072eb0-e0b4-4bd9-9a59-8a1b02083024\",\"url\":\"https://api-dev-coin-ls.essplapps.in/lucky_stars/api/draw/verify_answer\",\"statusCode\":412,\"errorCode\":172,\"errors\":[{\"displayMessage\":\"Oops. Incorrect answer.\",\"errorMessage\":null,\"errorType\":\"SQL\",\"errorProperty\":\"\"}]}\n";
                Gson gson = new Gson();

                ErrorResponse errorResponse = gson.fromJson(response.toString(), ErrorResponse.class);

                if (errorResponse != null)
                {
                    for (ErrorResponse.errors model : errorResponse.getError())
                    {
                        Toast.makeText(context, model.getDisplayMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                }

               /* if (responseStatus == HttpResponseStatus.RESPONSE_RECEIVED)
                {
                    object = response;
                } else
                {


                }*/
            }

        });
        checkVersionTask.execute();

        return object;
    }
}
