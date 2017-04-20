package libs.in.webserviceutil.wscalls.models;

import static libs.in.webserviceutil.wscalls.constant.NullCheckerClass.checkIsNull;

/**
 * Created by admin on 17-03-2016.
 */
public class LoginResponseModel
{



    private String access_token;
    private String token_type;
    private String refresh_token;
    private Integer expires_in;
    private String scope;
    private Info info;

    public String getAccess_token() {
        return checkIsNull(access_token);
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return checkIsNull(token_type);
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return checkIsNull(refresh_token);
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return checkIsNull(scope);
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
