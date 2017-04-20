package libs.in.webserviceutil.wscalls.models;

import static libs.in.webserviceutil.wscalls.constant.NullCheckerClass.checkIsNull;

/**
 * Created by apple on 25/05/15.
 */
public class OauthGenerateTokenModel {

    private String username;
    private String password;

    public OauthGenerateTokenModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return checkIsNull(username);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return checkIsNull(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}