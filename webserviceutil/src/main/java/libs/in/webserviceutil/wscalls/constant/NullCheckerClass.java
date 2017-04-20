package libs.in.webserviceutil.wscalls.constant;

/**
 * Created by admin on 01-02-2017.
 */
public class NullCheckerClass
{

    public static String checkIsNull(String paramValue) {
        if (paramValue != null) {
            paramValue= paramValue;
        } else {
            paramValue = "";
        }
        return paramValue;
    }


    public static Boolean checkIsNull(Boolean paramValue) {
        if (paramValue != null) {
            paramValue = paramValue;
        } else {
            paramValue  = false  ;
        }
        return paramValue;
    }
}
