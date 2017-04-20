package libs.in.webserviceutil.wscalls.models;

import static libs.in.webserviceutil.wscalls.constant.NullCheckerClass.checkIsNull;

/**
 * Created by admin on 02-02-2016.
 */
public class Info
{


    private String app_version;
    private String device_id;
    private String user_id;
    private String jid;
    private String file_name;
    private String device_type;
    private String user_name;
    private String name;
    private String profile_pic_url;
    private String profile_pic_thumb_url;
    private String service_type;
    private String email;
    private String mobile;

    public String getMobile() {
        return checkIsNull(mobile);
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return checkIsNull(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile_pic_url() {
        return checkIsNull(profile_pic_url);
    }

    public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
    }

    public String getProfile_pic_thumb_url() {
        return checkIsNull(profile_pic_thumb_url);
    }

    public void setProfile_pic_thumb_url(String profile_pic_thumb_url) {
        this.profile_pic_thumb_url = profile_pic_thumb_url;
    }

    public String getService_type() {
        return checkIsNull(service_type);
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getApp_version() {
        return checkIsNull(app_version);
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public String getDevice_id() {
        return checkIsNull(device_id);
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getUser_id() {
        return checkIsNull(user_id);
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getJid() {
        return checkIsNull(jid);
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public String getFile_name() {
        return checkIsNull(file_name);
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getDevice_type() {
        return checkIsNull(device_type);
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getUser_name() {
        return checkIsNull(user_name);
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return checkIsNull(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
