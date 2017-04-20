package libs.in.webserviceutil.wscalls.models;

import java.util.HashMap;
import java.util.Map;

import static libs.in.webserviceutil.wscalls.constant.NullCheckerClass.checkIsNull;

/**
 * Created by apple on 25/05/15.
 */
public class OauthGenerateTokenResponseModel {

    private String access_token;
    private String token_type;
    private String refresh_token;
    private String expires_in;
    private String scope;
    private String device_id;
    private String session_key;
    private String device_type;
    private Info info;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public String getDevice_id() {
        return checkIsNull(device_id);
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_type() {
        return checkIsNull(device_type);
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    /**
     *
     * @return
     * The access_token
     */
    public String getAccess_token() {
        return access_token;
    }

    /**
     *
     * @param access_token
     * The access_token
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    /**
     *
     * @return
     * The token_type
     */
    public String getToken_type() {
        return token_type;
    }

    /**
     *
     * @param token_type
     * The token_type
     */
    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    /**
     *
     * @return
     * The refresh_token
     */
    public String getRefresh_token() {
        return refresh_token;
    }

    /**
     *
     * @param refresh_token
     * The refresh_token
     */
    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    /**
     *
     * @return
     * The expires_in
     */
    public String getExpires_in() {
        return expires_in;
    }

    /**
     *
     * @param expires_in
     * The expires_in
     */
    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    /**
     *
     * @return
     * The scope
     */
    public String getScope() {
        return scope;
    }

    /**
     *
     * @param scope
     * The scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     *
     * @return
     * The session_key
     */
    public String getSession_key() {
        return session_key;
    }

    /**
     *
     * @param session_key
     * The session_key
     */
    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    /**
     *
     * @return
     * The info
     */
    public Info getInfo() {
        return info;
    }

    /**
     *
     * @param info
     * The info
     */
    public void setInfo(Info info) {
        this.info = info;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }



}