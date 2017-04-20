package libs.in.webserviceutil.wscalls;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import libs.in.webserviceutil.wscalls.constant.Constants;
import libs.in.webserviceutil.wscalls.constant.URLConstants;
import libs.in.webserviceutil.wscalls.models.LoginResponseModel;
import libs.in.webserviceutil.wscalls.models.OauthGenerateTokenResponseModel;
import libs.in.webserviceutil.wscalls.utils.PreferenceManager;

/*
import in.interactive.luckystars.activities.HomeActivity;
import in.interactive.luckystars.activities.SplashActivity;
import in.interactive.luckystars.constant.Constants;
import in.interactive.luckystars.constant.URLConstants;
import in.interactive.luckystars.model.LoginResponseModel;
import in.interactive.luckystars.model.OauthGenerateTokenResponseModel;
import in.interactive.luckystars.utility.PreferenceManager;
*/


/**
 * Created by apple on 25/05/15.
 */
public class BaseAsyncTask extends AsyncTask<Void, Void, Void>
{

    Activity baseActivity = null;
    public static int REQUEST_TYPE_POST = 1;
    public static int REQUEST_TYPE_GET = 2;
    public static int REQUEST_TYPE_FFED = 3;
    public static final int REQUEST_TYPE_DELETE = 7;
    public static final int REQUEST_TYPE_DELETE_POST = 8;
    public static int REQUEST_TYPE_DELETE_POST_HASHMAP = 10;
    public static int REQUEST_TYPE_POST_PARAMETER = 4;
    public static int REQUEST_TYPE_PUT_PARAMETER = 9;


    protected String url = null;
    protected int request_type;
    protected String body;
    protected HashMap<String, String> bodyHashMap;
    protected String username;
    protected String password;
    protected HttpResponseStatus responseStatus;
    protected String response;
    protected int responseCode;

    private static final char PARAMETER_DELIMITER = '&';
    private static final char PARAMETER_EQUALS_CHAR = '=';
    protected Exception mException;
    protected InputStream is;


    @Override
    protected Void doInBackground(Void... params)
    {

        if (request_type == REQUEST_TYPE_POST)
        {
            doHttpPostRequest(body);
        }

        return null;
    }


    private void bufferReader()
    {
        try
        {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();

            while ((line = rd.readLine()) != null)
            {
                response.append(line);
                response.append('\r');
            }

            rd.close();
            this.response = response.toString();
            this.responseStatus = HttpResponseStatus.INTERNAL_SERVER_ERROR;
        }
        catch (SocketTimeoutException e)
        {
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static StringBuilder createQueryStringForParameters(Map<String, String> parameters)
    {
        StringBuilder parametersAsQueryString = new StringBuilder();
        if (parameters != null)
        {
            boolean firstParameter = true;

            for (String parameterName : parameters.keySet())
            {
                if (!firstParameter)
                {
                    parametersAsQueryString.append(PARAMETER_DELIMITER);
                }
                parametersAsQueryString.append(parameterName)
                        .append(PARAMETER_EQUALS_CHAR)
                        .append(URLEncoder.encode(
                                parameters.get(parameterName)));
                firstParameter = false;
            }
        }
        return parametersAsQueryString;
    }

    protected int doGenerateRefreshToken()
    {
        int responseCode = 0;
        String res = "";
        Constants.REFRESH_TOKEN_KEY = PreferenceManager.getPreference(baseActivity.getApplicationContext(), PreferenceManager.KEY_REFRESH_TOKEN);
        String mUrl = URLConstants.URL_USER_GENERATE_TOKEN;
        HttpURLConnection connection = null;
        StringBuilder post;
        Map<String, String> postProperties = new HashMap<String, String>();

        postProperties.put(Constants.GRANT_TYPE, Constants.GRANT_TYPE_REFRESH_TOKEN);
        postProperties.put(Constants.CLIENT_ID, Constants.ANDROID_CLIENT_ID);
        postProperties.put(Constants.REFRESH_TOKEN, Constants.REFRESH_TOKEN_KEY);
        postProperties.put(Constants.CLIENT_SECRET, Constants.ANDROID_CLIENT_SECRET);
        post = createQueryStringForParameters(postProperties);

        try
        {
            URL url = new URL(mUrl + post);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            responseCode = connection.getResponseCode();
            Log.e("RefreshtokenCode", ">" + responseCode);
            if (responseCode == 200)
            {
                InputStream in = connection.getInputStream();
                InputStreamReader isw = new InputStreamReader(in);
                int data = isw.read();
                StringBuffer response = new StringBuffer();
                while (data != -1)
                {
                    char current = (char) data;
                    data = isw.read();
                    response.append(current);
                }
                res = response.toString();
                Gson gson = new Gson();

                final LoginResponseModel loginResponseModel = gson.fromJson(res.toString(), LoginResponseModel.class);
                savePreference(loginResponseModel);
                this.responseStatus = HttpResponseStatus.RESPONSE_RECEIVED;

            }
            if (responseCode == 412)
            {
                InputStream in = connection.getInputStream();
                InputStreamReader isw = new InputStreamReader(in);
                int data = isw.read();
                StringBuffer response = new StringBuffer();
                while (data != -1)
                {
                    char current = (char) data;
                    data = isw.read();
                    response.append(current);
                }
                res = response.toString();
                Gson gson = new Gson();
                final LoginResponseModel loginResponseModel = gson.fromJson(res.toString(), LoginResponseModel.class);
                savePreference(loginResponseModel);
                this.responseStatus = HttpResponseStatus.RESPONSE_RECEIVED;
                return responseCode;

            } else if (responseCode == 201)
            {
                InputStream is = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuffer response = new StringBuffer();
                while ((line = rd.readLine()) != null)
                {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();
                res = response.toString();
                Gson gson = new Gson();
                final LoginResponseModel loginResponseModel = gson.fromJson(res.toString(), LoginResponseModel.class);
                savePreference(loginResponseModel);

            } else if (responseCode == 401)
            {

                String username = PreferenceManager.getPreference(baseActivity.getApplicationContext(), PreferenceManager.KEY_USERNAME);
                String password = PreferenceManager.getPreference(baseActivity.getApplicationContext(), PreferenceManager.KEY_USER_PASSWORD);
                String outhUrl = URLConstants.URL_USER_GENERATE_REFRESH_TOKEN;
                doGetToken(outhUrl, username, password, Constants.GRANT_TYPE_TOKEN, request_type);
                this.responseStatus = HttpResponseStatus.BAD_REQUEST;
                return responseCode;
            } else if (responseCode == 400)
            {
                String username = PreferenceManager.getPreference(baseActivity.getApplicationContext(), PreferenceManager.KEY_USERNAME);
                String password = PreferenceManager.getPreference(baseActivity.getApplicationContext(), PreferenceManager.KEY_USER_PASSWORD);
                String outhUrl = URLConstants.URL_USER_GENERATE_REFRESH_TOKEN;
                doGetToken(outhUrl, username, password, Constants.GRANT_TYPE_TOKEN, request_type);
                is = connection.getErrorStream();
                bufferReader();
                this.responseStatus = HttpResponseStatus.BAD_REQUEST;
                return responseCode;
            } else if (responseCode == 403)
            {
                is = connection.getErrorStream();
                bufferReader();
                this.responseStatus = HttpResponseStatus.Forbidden;
                return responseCode;
            } else if (responseCode == 404)
            {
                is = connection.getErrorStream();
                bufferReader();
                this.responseStatus = HttpResponseStatus.USER_NOT_FOUND;
                return responseCode;
            } else if (responseCode == 500)
            {
                is = connection.getErrorStream();
                bufferReader();
                this.responseStatus = HttpResponseStatus.USER_NOT_FOUND;

                return responseCode;
            } else if (responseCode == 409)
            {
                is = connection.getErrorStream();
                bufferReader();
                this.responseStatus = HttpResponseStatus.DUPLICATE_USERNO;
                return responseCode;
            } else if (responseCode == 402)
            {
                is = connection.getErrorStream();
                bufferReader();
                return responseCode;
            }
        }
        catch (MalformedURLException murl)
        {

        }
        catch (IOException io)
        {

        }
        return responseCode;
    }


    protected void doGetToken(String mUrl, String username, String password, String grantType, int requesttype)
    {
        String res = "";

        HttpURLConnection connection = null;
        StringBuilder post;
        Map<String, String> postProperties = new HashMap<String, String>();

        if (grantType.equalsIgnoreCase(Constants.GRANT_TYPE_TOKEN))
        {
            postProperties.put(Constants.GRANT_TYPE, grantType);
            postProperties.put(Constants.CLIENT_ID, Constants.ANDROID_CLIENT_ID);
            postProperties.put(Constants.USER_NAME, username);
            postProperties.put(Constants.PASSWORD, password);
            postProperties.put(Constants.CLIENT_SECRET, Constants.ANDROID_CLIENT_SECRET);
            post = createQueryStringForParameters(postProperties);
        } else if (grantType.equalsIgnoreCase("reset"))
        {
            postProperties.put("userName", username);
            postProperties.put("pasword", password);
            post = createQueryStringForParameters(postProperties);
        } else
        {
            postProperties.put(Constants.GRANT_TYPE, grantType);
            postProperties.put(Constants.CLIENT_ID, Constants.ANDROID_CLIENT_ID);
            if (Constants.REFRESH_TOKEN_KEY != null)
                postProperties.put(Constants.REFRESH_TOKEN, Constants.REFRESH_TOKEN_KEY);
            postProperties.put(Constants.CLIENT_SECRET, Constants.ANDROID_CLIENT_SECRET);
            post = createQueryStringForParameters(postProperties);
        }
        try
        {
            URL url = new URL(mUrl + post);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            int responseCode = connection.getResponseCode();
            Log.e("tokenbyusernamepwd>>", ">>" + responseCode);
            if (responseCode == 200)
            {
                InputStream in = connection.getInputStream();
                InputStreamReader isw = new InputStreamReader(in);
                int data = isw.read();
                StringBuffer response = new StringBuffer();
                while (data != -1)
                {
                    char current = (char) data;
                    data = isw.read();
                    response.append(current);
                }
                res = response.toString();
                Gson gson = new Gson();
                final OauthGenerateTokenResponseModel generateTokenResponseModel = gson.fromJson(res.toString(), OauthGenerateTokenResponseModel.class);
                savePreference(generateTokenResponseModel);
                /*Intent intent = new Intent(baseActivity, HomeActivity.class);
                baseActivity.startActivity(intent);
                */
                this.responseStatus = HttpResponseStatus.RESPONSE_RECEIVED;
                return;
            } else if (responseCode == 201)
            {
                InputStream is = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuffer response = new StringBuffer();
                while ((line = rd.readLine()) != null)
                {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();
                Gson gson = new Gson();
                res = response.toString();
                final OauthGenerateTokenResponseModel generateTokenResponseModel = gson.fromJson(res.toString(), OauthGenerateTokenResponseModel.class);
                savePreference(generateTokenResponseModel);
                /*Intent intent = new Intent(baseActivity, HomeActivity.class);
                baseActivity.startActivity(intent);
                baseActivity.finish();
                */

                return;

            } else if (responseCode == 401)
            {
                {
                    this.responseStatus = HttpResponseStatus.AUTHORIZATION_REQUIRED;
                    bufferReader();
                    signOut();
                    return;
                }
            } else if (responseCode == 400)
            {
                is = connection.getErrorStream();
                bufferReader();
                signOut();
                this.responseStatus = HttpResponseStatus.BAD_REQUEST;
                return;
            } else if (responseCode == 403)
            {
                is = connection.getErrorStream();
                bufferReader();
                this.responseStatus = HttpResponseStatus.Forbidden;
                return;
            } else if (responseCode == 404)
            {
                is = connection.getErrorStream();
                bufferReader();
                this.responseStatus = HttpResponseStatus.USER_NOT_FOUND;
                return;
            } else if (responseCode == 500)
            {
                is = connection.getErrorStream();
                bufferReader();
                this.responseStatus = HttpResponseStatus.USER_NOT_FOUND;

                return;
            } else if (responseCode == 409)
            {
                is = connection.getErrorStream();
                bufferReader();
                this.responseStatus = HttpResponseStatus.DUPLICATE_USERNO;
                return;
            } else if (responseCode == 402)
            {
                is = connection.getErrorStream();
                bufferReader();
                return;
            }
        }
        catch (MalformedURLException murl)
        {

        }
        catch (IOException io)
        {

        }
    }

    public void signOut()
    {
        PreferenceManager.ClearPreference(baseActivity);

        File cache = baseActivity.getCacheDir();
        File appDir = new File(cache.getParent());
        if (appDir.exists())
        {
            String[] children = appDir.list();
            for (String s : children)
            {
                if (!s.equals("lib"))
                {
                    deleteDir(new File(appDir, s));
                }
            }
        }

        /*Intent intent = new Intent(baseActivity, Mai.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        baseActivity.startActivity(intent);
        baseActivity.finish();
        baseActivity.finishAffinity();*/

    }

    public static boolean deleteDir(File dir)
    {
        if (dir != null && dir.isDirectory())
        {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++)
            {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success)
                {
                    return false;
                }
            }
        }

        return dir.delete();
    }

    private void savePreference(LoginResponseModel model)
    {
        PreferenceManager.savePreference(baseActivity, PreferenceManager.KEY_ACCESS_TOKEN, model.getAccess_token() + "");
        PreferenceManager.savePreference(baseActivity, PreferenceManager.KEY_TOKEN_TYPE, model.getToken_type() + "");
        PreferenceManager.savePreference(baseActivity, PreferenceManager.KEY_REFRESH_TOKEN, model.getRefresh_token() + "");
        PreferenceManager.savePreference(baseActivity, PreferenceManager.KEY_APP_VERSION, model.getInfo().getApp_version() + "");
        PreferenceManager.savePreference(baseActivity, PreferenceManager.KEY_USER_ID, model.getInfo().getUser_id() + "");
        PreferenceManager.savePreference(baseActivity, PreferenceManager.KEY_DEVICE_TYPE, model.getInfo().getDevice_type() + "");
        PreferenceManager.savePreference(baseActivity, PreferenceManager.KEY_USERNAME, model.getInfo().getUser_name() + "");
        PreferenceManager.savePreference(baseActivity, PreferenceManager.KEY_NAME, model.getInfo().getName() + "");
        PreferenceManager.savePreference(baseActivity, PreferenceManager.KEY_IS_LOGIN, true);

        Constants.AUTHORIZATION = model.getAccess_token();
        Constants.REFRESH_TOKEN_KEY = model.getRefresh_token();
    }


    private void savePreference(OauthGenerateTokenResponseModel generateTokenResponseModel)
    {

        PreferenceManager.savePreference(baseActivity.getApplicationContext(), PreferenceManager.KEY_ACCESS_TOKEN, generateTokenResponseModel.getAccess_token());
        PreferenceManager.savePreference(baseActivity.getApplicationContext(), PreferenceManager.KEY_REFRESH_TOKEN, generateTokenResponseModel.getRefresh_token());
        PreferenceManager.savePreference(baseActivity.getApplicationContext(), PreferenceManager.KEY_USER_ID, generateTokenResponseModel.getInfo().getUser_id());
        PreferenceManager.savePreference(baseActivity.getApplicationContext(), PreferenceManager.KEY_USERNAME, generateTokenResponseModel.getInfo().getUser_name());
        Constants.AUTHORIZATION = generateTokenResponseModel.getAccess_token();
        Constants.REFRESH_TOKEN_KEY = generateTokenResponseModel.getRefresh_token();
    }


    private void doHttpPostRequest(String body)
    {
        try
        {
            HttpURLConnection connection = null;
            Constants.AUTHORIZATION = PreferenceManager.getPreference(baseActivity.getApplicationContext(), PreferenceManager.KEY_ACCESS_TOKEN);
            URL mUrl = new URL(url);
            if ("https".equals(mUrl.getProtocol()))
            {
                // It is https
                TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager()
                        {
                            public X509Certificate[] getAcceptedIssuers()
                            {
                                return null;
                            }

                            public void checkClientTrusted(X509Certificate[] certs, String authType)
                            {
                            }

                            public void checkServerTrusted(X509Certificate[] certs, String authType)
                            {
                            }
                        }
                };
                SSLContext sc = SSLContext.getInstance("TLS");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                connection = (HttpsURLConnection) mUrl.openConnection();

            } else if ("http".equals(mUrl.getProtocol()))
            {

                connection = (HttpURLConnection) mUrl.openConnection();

            }

            /*connection = (HttpURLConnection) mUrl.openConnection();*/
            connection = (HttpsURLConnection) mUrl.openConnection();
            connection.setRequestMethod("POST");
            if (PreferenceManager.getPreference(baseActivity, PreferenceManager.KEY_ACCESS_TOKEN) != null)
            {
                connection.setRequestProperty("Authorization", Constants.BEARER + PreferenceManager.getPreference(baseActivity, PreferenceManager.KEY_ACCESS_TOKEN));
            }

//            if (url.equalsIgnoreCase(URLConstants.URL_COIN_TRANSFER_OTP) || url.equalsIgnoreCase(URLConstants.URL_COIN_TRANSFER_REQUEST) || url.equalsIgnoreCase(URLConstants.URL_GETPASS))
//            {
//                connection.setRequestProperty("X-Access-Token", BCrypt.hashpw("?>" + PreferenceManager.getPreference(baseActivity, PreferenceManager.KEY_USER_ID) + "~!" + Constants.API_KEY + "*&" + PreferenceManager.getPreference(baseActivity, PreferenceManager.KEY_USER_MOBILE) + "^&",BCrypt.gensalt(12)));
//            }
//            else
//            {
//                connection.setRequestProperty("X-Access-Token", BCrypt.hashpw(Constants.API_KEY,BCrypt.gensalt(12)));
//            }
            connection.setRequestProperty("X-Access-Token", Constants.API_KEY);
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoInput(true);
            connection.setDoOutput(false);

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            byte[] data = body.getBytes("UTF-8");
            wr.write(data);
            wr.flush();
            wr.close();

            int responseCode = connection.getResponseCode();
            Log.e("code>", "" + responseCode);

            this.responseCode = responseCode;

            if (responseCode >= 200 && responseCode <= 210)
            {
                InputStream is = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuffer response = new StringBuffer();
                while ((line = rd.readLine()) != null)
                {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();
                this.response = response.toString();

//                if (url.equalsIgnoreCase(URLConstants.URL_ON_LUNCH))
//                {
//                    AESCryptLib aesCryptLib = new AESCryptLib();
//                    this.response = aesCryptLib.decrypt(this.response);
//                }
                this.responseStatus = HttpResponseStatus.RESPONSE_RECEIVED;

                this.responseCode = responseCode;
            } else if (responseCode >= 400 && responseCode <= 600)
            {
                if (responseCode == 401)
                {
                    InputStream is = connection.getErrorStream();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while ((line = rd.readLine()) != null)
                    {
                        response.append(line);
                        response.append('\r');
                    }
                    rd.close();
                    Gson gson = new Gson();
                    this.response = response.toString();
                    try
                    {
                        JSONObject jsonObject = new JSONObject(this.response);
                        if (jsonObject.get("error") instanceof JSONArray)
                        {
                            Log.e("", "");
                            int responseCode1 = doGenerateRefreshToken();
                            if (responseCode1 == 200)
                            {
                                this.response = null;
                                doHttpPostRequest(body);
                                return;
                            }


                        } else
                        {
                            String response1 = jsonObject.getString("error_description");
                            String res[] = response1.split(":");

                            if (mUrl.toString().contains("oauth"))
                            {
                                signOut();
                            } else
                            {

                                int responseCodeNew = doGenerateRefreshToken();
                                if (responseCodeNew == 200)
                                {
                                    this.response = null;
                                    doHttpPostRequest(body);
                                    return;
                                }
                            }
                        }

                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                    return;
                } else if (responseCode == 400)
                {
                    InputStream is = connection.getErrorStream();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while ((line = rd.readLine()) != null)
                    {
                        response.append(line);
                        response.append('\r');
                    }
                    rd.close();
                    this.response = response.toString();
                    this.responseStatus = HttpResponseStatus.BAD_REQUEST;
                    return;
                } else if (responseCode == 403)
                {
                    is = connection.getErrorStream();
                    bufferReader();
                    this.responseStatus = HttpResponseStatus.Forbidden;
                    return;
                } else if (responseCode == 404)
                {
                    is = connection.getErrorStream();
                    bufferReader();
                    this.responseStatus = HttpResponseStatus.USER_NOT_FOUND;
                    return;
                } else if (responseCode == 500)
                {
                    InputStream is = connection.getErrorStream();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while ((line = rd.readLine()) != null)
                    {
                        response.append(line);
                        response.append('\r');
                    }
                    rd.close();
                    this.response = response.toString();
                    this.responseStatus = HttpResponseStatus.USER_NOT_FOUND;
                    return;
                } else if (responseCode == 409)
                {
                    InputStream is = connection.getErrorStream();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while ((line = rd.readLine()) != null)
                    {
                        response.append(line);
                        response.append('\r');
                    }
                    rd.close();
                    this.response = response.toString();
                    this.responseStatus = HttpResponseStatus.DUPLICATE_USERNO;
                    return;
                } else if (responseCode == 402)
                {
                    is = connection.getErrorStream();
                    bufferReader();
                    return;
                } else if (responseCode == 504)
                {
                    InputStream is = connection.getErrorStream();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while ((line = rd.readLine()) != null)
                    {
                        response.append(line);
                        response.append('\r');
                    }
                    rd.close();
                    this.response = response.toString();
                    this.responseStatus = HttpResponseStatus.INVALID_URL_ENCODING;
                    return;
                } else
                {
                    InputStream is = connection.getErrorStream();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while ((line = rd.readLine()) != null)
                    {
                        response.append(line);
                        response.append('\r');
                    }
                    rd.close();
                    this.responseCode = connection.getResponseCode();
                    this.response = response.toString();
                    this.responseStatus = HttpResponseStatus.INTERNAL_SERVER_ERROR;
                    return;
                }

            }

        }
        catch (UnsupportedEncodingException e)
        {
            responseStatus = HttpResponseStatus.INVALID_URL_ENCODING;
        }
        catch (SocketTimeoutException e)
        {
        }
        catch (IOException e)
        {
            responseStatus = HttpResponseStatus.UNABLE_TO_CONNECT;
        }
        catch (NoSuchAlgorithmException e1)
        {
            e1.printStackTrace();
        }
        catch (KeyManagementException e1)
        {
            e1.printStackTrace();
        }
//        catch (NoSuchPaddingException e) {
//            e.printStackTrace();
//        } catch (BadPaddingException e) {
//            e.printStackTrace();
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (IllegalBlockSizeException e) {
//            e.printStackTrace();
//        } catch (InvalidAlgorithmParameterException e) {
//            e.printStackTrace();
//        }

    }


}

