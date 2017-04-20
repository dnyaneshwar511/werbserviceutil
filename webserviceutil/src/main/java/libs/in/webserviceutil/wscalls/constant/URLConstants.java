package libs.in.webserviceutil.wscalls.constant;

/**
 * Created by admin on 13-03-2016.
 */
public class URLConstants
{

    // Development url
    //HTTPS
//    public static final String SERVER_URL = "https://api-dev-ls.essplapps.in/lucky_stars";
    public static final String SERVER_URL = "https://api-dev-coin-ls.essplapps.in/lucky_stars";

    public static final String WINNER_URL = "http://www.luckystarsapp.com/winnersDemoAPI/winners.php";

    public static final String URL_NO_INTERNETCONNECTION = "http://ecom-dev-ls.essplapps.in/no-net.html";

    // public static final String SERVER_URL ="http://api-dev-ls-cache.essplapps.in/lucky_stars";


    //HTTP
/*    public static final String SERVER_URL = "http://api.dev.ls.essplapps.in:80/lucky_stars";*/

    // Pre Production url

    // public static final String SERVER_URL = "http://api.pp.ls.essplapps.in/lucky_stars";

    //without deal object
    public static final String URL_DRAW_LIST = SERVER_URL + "/api/draw/list/";
    //    public static final String URL_DRAW_LIST_OPEN_CALL_Old = SERVER_URL + "/opcall/draw/new/";
    public static final String URL_DRAW_LIST_OPEN_CALL = SERVER_URL + "/opcall/draw/refined_by";

    //with deal object
    //   public static final String URL_DRAW_LIST_WITH_DEAL = SERVER_URL + "/opcall/draw/new/";


    public static final String URL_GET_PRODUCT_PIC = SERVER_URL + "/api/product/pic/";

    public static final String URL_DRAW_PARTICIPATE = SERVER_URL + "/api/draw/participate?drawId=";

    public static final String URL_VALIDATE_REGISTER = SERVER_URL + "/oauth/validate_register";
    public static final String URL_REQUEST_OTP = SERVER_URL + "/oauth/send_otp_mobile?";
    public static final String URL_USER_SIGN_UP_VALIDATE_OTP = SERVER_URL + "/oauth/verify_otp_mobile?";
    public static final String URL_USER_GENERATE_TOKEN = SERVER_URL + "_oauth/oauth/token?";
    public static final String URL_USER_RESET_TOKEN = SERVER_URL + "/oauth/reset_tokens";
    public static final String URL_USER_GENERATE_REFRESH_TOKEN = SERVER_URL + "_oauth/oauth/token?";
    public static final String URL_REGISTER = SERVER_URL + "/oauth/register";
    public static final String URL_SOCIAL_MEDIA_REGISTER = SERVER_URL + "/oauth/login_social_media";


    public static final String URL_CUSTOMERSUPPORT = SERVER_URL + "/customer_support";
    public static final String URL_CUSTOMERSUPPORT_UPLOAD_PIC = SERVER_URL + "/customer_support/upload_pic";
    public static final String URL_FORGOT_EMAIL_ADDRESS = SERVER_URL + "/oauth/forgot_password_email?";
    public static final String URL_SET_PASSWORD = SERVER_URL + "/oauth/set_password_emailId?";
    public static final String URL_CHECK_VERSION = SERVER_URL + "/configuration/check_version";
    public static final String URL_APP_CONGIG = SERVER_URL + "/configuration/api_config";

    //History
    public static final String URL_GET_HISTORY = SERVER_URL + "/opcall/history/";
    public static final String URL_GET_WINEER = SERVER_URL + "/opcall/declared/list/";
    public static final String URL_GET_WINEER_ALL = SERVER_URL + "/opcall/winners/";
    public static final String URL_GET_QUESTIONS = SERVER_URL + "/api/draw/question/";
    public static final String URL_DEVICE_REGISTER = SERVER_URL + "/user_device";
    public static final String URL_VERIFY_ANSWER = SERVER_URL + "/api/draw/verify_answer?";
    public static final String URL_NOTIFICATION = SERVER_URL + "/opcall/notification/list?";
    public static final String URL_HISTORY_DETAILS = SERVER_URL + "/api/draw/participate?drawId";


    //Address

    public static final String URL_ADD_ADDRESS = SERVER_URL + "/api/user_address";
    public static final String URL_UPDATE_ADDRESS = SERVER_URL + "/api/user_address";
    public static final String URL_GET_ADDRESS_LIST = SERVER_URL + "/api/user_address/list";
    public static final String URL_SET_ADDRESS_DEFAULT = SERVER_URL + "/api/user_address/set_default?";
    public static final String URL_DELETE_ADDRESS = SERVER_URL + "/api/user_address/";
    public static final String URL_UPDATE_DEVICE_REGISTER = SERVER_URL + "/user_device";

    //Winner
    public static final String URL_MAP_ADDRESS = SERVER_URL + "/api/draw/freebie/map_address?";
    public static final String URL_FRABBIE_LIST = SERVER_URL + "/opcall/freebies/list/";
    public static final String URL_DECLINED_FRABBIE = SERVER_URL + "/api/draw/freebie/declined?";


    //social-media
    public static final String URL_SOCIAL_MEDIA = SERVER_URL + "/oauth/login_social_media";


    public static final String URL_GET_PRODUCT_PIC_BY_PIC_ID = SERVER_URL + "/api/product/pic_by_product_pic_id/";


    //Notification Delete
    public static final String URL_NOTIFICATION_DELETE = SERVER_URL + "/api/notification";
    public static final String URL_NOTIFICATION_DELETE_ALL = SERVER_URL + "/api/notification/delete_all?";


    //Edit Profile
    public static final String URL_EDIT_PROFILE_PIC = SERVER_URL + "/api/user/upload_pic";
    public static final String URL_SET_AVATAR_PROFILE_PIC = SERVER_URL + "/api/user/set_pic?";
    public static final String URL_GET_AVATAR_LIST = SERVER_URL + "/configuration/avatars/";

    public static final String URL_DRAW_DETAILS = SERVER_URL + "/api/draw/";

    /*User Info*/
    public static final String URL_GET_USER_INFO = SERVER_URL + "/api/user/me";


    /*Notification Read*/
    public static final String URL_READ_ALL_NOTIFICATION = SERVER_URL + "/api/notification/mark_clear";


    public static final String URL_READ_NOTIFICATION = SERVER_URL + "/api/notification/mark_read";

    public static final String URL_FEEDBACK = SERVER_URL + "/api/configuration/feedback";

    public static final String URL_GET_APP_SHARE_TEXT = SERVER_URL + "/configuration/app_share_text";


    /*User Update*/


    public static final String URL_USER_UPDATE = SERVER_URL + "/api/user?";
    public static final String URL_GET_PASS = SERVER_URL + "/api/gatepass/";

    /*Check Cliam Eligibility*/

    public static final String URL_CLAIM_ELIGIBLE = SERVER_URL + "/api/draw/check_claim_eligibility?drawId=";

    //Res Text
    public static final String URL_REGISTATION_TEXT = SERVER_URL + "/oauth/confirm_text/registration";

    public static final String URL_GETPASS = SERVER_URL + "/api/gatepass/action";


    //User Order

    public static final String URL_Customer_Order = SERVER_URL + "/api/ecom/customerorder";
    public static final String URL_Order_Details = SERVER_URL + "/api/ecom/customerorder/";

    /*----------------Deal API---------------*/

    public static final String URL_DEALS_LIST = SERVER_URL + "/api/ecom/product/category";

    public static final String URL_DEALS_TOP_BAR_LIST = SERVER_URL + "/api/ecom/deal/top_bar_list/";

    public static final String URL_DEALS_CATEGORY_HOME = SERVER_URL + "/api/ecom/category/home?api_key=top_bar_list";

    public static final String URL_DEALS_SEARCH_PRODUCT = SERVER_URL + "/api/ecom/product/custom_search_by_category/";

    public static final String URL_ON_LUNCH = SERVER_URL + "/configuration/on_launch";

//    public static final String URL_ON_LUNCH = SERVER_URL + "/configuration/on_launch_new";

//    public static final String URL_ON_LUNCH = SERVER_URL + "/configuration/token";

    /*-----------------Coin Management----------------------*/

    public static final String URL_COIN_DASHBOARD = SERVER_URL + "/api/coin_mgmt/dashboard";
    public static final String URL_VIEW_ADS = SERVER_URL + "/api/coin_mgmt/view/ad";
    public static final String URL_SURVEY = SERVER_URL + "/api/coin_mgmt/view/survey";


    /*----------------Profile Additional Details---------------*/
    public static final String URL_USER_ADDITIONAL_DETAILS = SERVER_URL + "/api/parameter";
    public static final String UPDATE_USER_ADDITIONAL_DETAILS = SERVER_URL + "/api/user/update_additional_info";


    /*----------------Earn Coin List---------------*/
    public static final String URL_EARN_COIN_LIST = SERVER_URL + "/api/coin_mgmt/earn_coins/";

    /*----------------Coin History List---------------*/
    public static final String URL_GET_COIN_HISTORY = SERVER_URL + "/api/coin_mgmt/history/list";

    /*----------------Coin Transfer Activity---------------*/
    public static final String URL_MOBILE_VALIDATE = SERVER_URL + "/api/coin_transfer/validate_mobile_no";
    public static final String URL_COIN_TRANSFER_OTP = SERVER_URL + "/api/coin_transfer/send_otp";
    public static final String URL_COIN_TRANSFER_REQUEST = SERVER_URL + "/api/coin_transfer/request";


    public static final String URL_REDEEM_COIN_DEAL = SERVER_URL + "/api/ecom/deal/redeem_list/";

    public static final String URL_REDEEM_COIN_PRODUCT = SERVER_URL + "/api/ecom/product/category/redeem/";

    public static final String URL_EMAIL_VERIFICATION = SERVER_URL + "/api/user/check_email_verification";
    public static final String URL_EMAIL_CHANGE = SERVER_URL + "/api/user/change_email?";

    //Refine By API
    public static final String URL_REFINE_BY = SERVER_URL + "/api/draw/refine_by";

    //Call Me
    public static final String URL_CALL_ME = SERVER_URL + "/oauth/make_call?";
}
