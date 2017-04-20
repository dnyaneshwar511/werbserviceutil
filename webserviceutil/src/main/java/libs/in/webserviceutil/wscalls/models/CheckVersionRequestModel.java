package libs.in.webserviceutil.wscalls.models;

/**
 * Created by apple on 29/04/16.
 */
public class CheckVersionRequestModel
{

    private String currentVersion;
    private String deviceType;


    public CheckVersionRequestModel(String currentVersion, String deviceType)
    {
        this.currentVersion=currentVersion;
        this.deviceType=deviceType;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
