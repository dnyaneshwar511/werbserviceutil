package libs.in.webserviceutil.wscalls;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;

import com.google.gson.Gson;

import libs.in.webserviceutil.wscalls.constant.Constants;
import libs.in.webserviceutil.wscalls.constant.OnHttpResponseReceived;
import libs.in.webserviceutil.wscalls.constant.URLConstants;
import libs.in.webserviceutil.wscalls.models.CheckVersionRequestModel;

/**
 * AuthenticateRequestModel
 * Created by apple on 28/07/15.
 */
public class OnLounchTask extends BaseAsyncTask
{

    private OnHttpResponseReceived onHttpResponseReceived;
    private CheckVersionRequestModel requestModel;

    private Activity activity = null;
    private boolean isNetworkAvailable = true;

    public OnLounchTask(Activity activity, CheckVersionRequestModel requestModel, OnHttpResponseReceived onHttpResponseReceived)
    {
        this.requestModel = requestModel;
        this.onHttpResponseReceived = onHttpResponseReceived;
        this.activity = activity;
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        if (activity != null)
        {
            /*if (!ConnectionUtils.isInternetAvailable(activity))
            {
                isNetworkAvailable = false;
            }*/
        }
    }

    @Override
    protected Void doInBackground(Void... params)
    {
        if (!isNetworkAvailable)
        {
            this.response = Constants.NO_INTERNET;
            this.responseStatus = HttpResponseStatus.NO_NEWTWORK_ERROR;
            return null;
        } else
        {
            request_type = BaseAsyncTask.REQUEST_TYPE_POST;
//            request_type = BaseAsyncTask.REQUEST_TYPE_GET;
            url = URLConstants.URL_ON_LUNCH;
            baseActivity = activity;
            Gson gson = new Gson();
            body = gson.toJson(requestModel);
            return super.doInBackground(params);
        }
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);
        onHttpResponseReceived.onResponseReceived(response, responseStatus, responseCode);
        // Gson gson = new Gson();
        /*if (responseStatus != null)
        {
            if (!responseStatus.equals(HttpResponseStatus.RESPONSE_RECEIVED))
            {
                if (responseStatus == HttpResponseStatus.NO_NEWTWORK_ERROR)
                {
                    LsDialog.showDialog(activity, activity.getString(R.string.no_internet_available), "");
                } else if (response != null)
                {
                    Gson gson = new Gson();
                    if (responseCode != 401)
                    {
                        ErrorResponse model = gson.fromJson(response.toString(), ErrorResponse.class);
                        if (model != null)
                        {
                            if (model.getError() != null)
                            {
                                if (model.getError().size() > 0 && model.getError().get(0).getDisplayMessage() != null)
                                {
                                    response = model.getError().get(0).getDisplayMessage();
                                } else
                                {
                                    if (model.getError().size() > 0 && model.getError().get(0).getErrorMessage() != null)
                                    {
                                        response = model.getError().get(0).getErrorMessage();
                                    } else
                                    {
                                        response = "Something went wrong";
                                    }
                                }
                            } else
                            {
                                response = "Something went wrong";
                            }
                        } else
                        {
                            response = "Something went wrong";
                        }
                        String title = activity.getResources().getString(R.string.app_name);
                        if (responseStatus == HttpResponseStatus.BAD_REQUEST)
                        {
                            Utility.showDialog(activity, title, response);
                        } else if (responseStatus == HttpResponseStatus.INTERNAL_SERVER_ERROR)
                        {
                            Utility.showDialog(activity, title, response);
                        } else if (responseStatus == HttpResponseStatus.UNABLE_TO_CONNECT)
                        {
                            Utility.showDialog(activity, title, response);
                        } else if (responseStatus == HttpResponseStatus.Forbidden)
                        {
                            Utility.showDialog(activity, title, response);
                        } else if (responseStatus == HttpResponseStatus.INVALID_URL_ENCODING)
                        {
                            Utility.showDialog(activity, title, response);
                        } else if (responseStatus == HttpResponseStatus.USER_NOT_FOUND)
                        {
                            Utility.showDialog(activity, title, response);
                        }
                    }
                }
            }
        }
    }*/
    }
}
