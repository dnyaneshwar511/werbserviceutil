package libs.in.webserviceutil.wscalls.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by apple on 27/05/15.
 */
public class PreferenceManager
{
    public static final String APPLICATION_PREFERENCE = "SportOPreference";

    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_TOKEN_TYPE = "token_type";
    public static final String KEY_REFRESH_TOKEN = "refresh_token";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_JID = "jid";
    public static final String KEY_DEVICE_TYPE = "device_type";
    public static final String KEY_USERNAME = "user_name";

    public static final String KEY_CONTACTUS_URL = "contactUsUrl";
    public static final String KEY_FAQ_URL = "faqsUrl";
    public static final String KEY_PRIVACY_POLICY_URL = "privacyPolicyUrl";
    public static final String KEY_TERMSOFUSE_URL = "termsOfUseUrl";
    public static final String KEY_USER_PASSWORD = "password";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL_VERIFIED = "emailVerified";
    public static final String KEY_REGISTER_FLAG = "register";


    public static final String KEY_FIRST_INSTALATION = "firstInstalation";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_IS_LOGIN = "login";
    public static final String KEY_PLAYSTORE_RATEAPP = "rateApp";
    public static final String KEY_APP_DOWNLOAD_URL = "appShareUrl";
    public static final String DEVICE_ID = "device_id";
    public static final String KEY_IS_CALL_API = "api";
    public static final String KEY_PROFILE_PIC_URL = "profile_pic_url";
    public static final String KEY_PROFILE_PIC_THUMB_URL = "profile_pic_thumb_url";
    public static final String KEY_SERVICE_TYPE = "service_type";
    public static final String KEY_HOME_GUIDE = "guide_screen";
    public static final String KEY_TERM_CONDITION_URL = "termAndConditionUrl";
    public static final String KEY_GET_APP_SHARE_TEXT = "getAppShareText";
    public static final String KEY_GET_APP_SHARE_URL = "getAppShareUrl";
    public static final String KEY_DRAW_ID_FOR_NOTIFICATION = "draw_id_notification";
    public static final String KEY_DEALS_INTRO = "deals_list_intro";
    public static final String KEY_DEALS_TILES_INTRO = "deals_tile_intro";
    public static final String KEY_DASHBOARD_GUIDE = "dashboard_intro";
    public static final String KEY_EARN_ADDITIONAL_DETAILS = "dashboard_intro";

    /*Refer and Earn*/
    public static final String KEY_REFER_EARN_SHARE_TEXT = "referAndEarnShareText";

    /*Profile*/
    public static final String KEY_USER_FIRST_NAME = "first_name";
    public static final String KEY_USER_LAST_NAME = "last_name";
    public static final String KEY_USER_MOBILE = "mobileno";
    public static final String KEY_USER_EMAILID = "emailid";
    public static final String KEY_USER_CITY = "city";
    public static final String KEY_USER_BIRTHDATE = "birthdate";
    public static final String KEY_USER_GENDER = "gender";
    public static final String KEY_USER_PINCODE = "pincode";
    public static final String KEY_MAX_DRAW_COUNT = "draw_count";
    public static final String KEY_DESCLIAMER_URL = "desc_url";

    public static final String KEY_UNREAD_COUNT = "unread_count";

    public static final String REFERAL_CODE = "referal_code";
    public static final String REFERAL_CODE_SHARE_TEXT = "referal_code_share_text";
    public static final String REFER_EARN_TEXT = "refer_earn_text";

    public static final String USER_MOBILE_NO = "user_Mobile_number";

    public static final String KEY_EMAIL_VERIFY_OPTIONAL = "key email verify optional";

    public static final String HOW_TO_EARN_COIN_URL = "how_to_earn_coin";

    public static final String HOW_TO_REDEEM_STARS_URL = "how_to_redeem_stars";

    public static final String DASHBOARD_INFO_URL = "my_dashboard_info_url";
    public static final String IS_FIRST_TIME = "false";

    public static final String WINNER_URL = "winner_url";
    public static final String LOCATION_PERMISSION = "location_permissions";
    public static final String LAT_LON_PERMISSION = "location_permissions";


    public static boolean savePreference(Context context, String key, String value)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(APPLICATION_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static String getPreference(Context context, String key)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(APPLICATION_PREFERENCE, Context.MODE_PRIVATE);
        String value = sharedPref.getString(key, null);
        return value;

    }

    public static boolean savePreference(Context context, String key, boolean value)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(APPLICATION_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public static boolean getPreferenceBoolean(Context context, String key)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(APPLICATION_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Boolean value = sharedPref.getBoolean(key, false);
        return value;
    }


    public static void ClearPreference(Context mcontext)
    {
        SharedPreferences preferences = mcontext.getSharedPreferences(APPLICATION_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();

    }

}
