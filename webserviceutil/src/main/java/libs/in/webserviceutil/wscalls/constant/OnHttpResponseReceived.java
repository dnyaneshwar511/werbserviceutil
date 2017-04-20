package libs.in.webserviceutil.wscalls.constant;

import libs.in.webserviceutil.wscalls.HttpResponseStatus;

/**
 * Created by apple on 25/05/15.
 */
public interface OnHttpResponseReceived
{
    void onResponseReceived(Object response, HttpResponseStatus responseStatus, int responseCode);
}
