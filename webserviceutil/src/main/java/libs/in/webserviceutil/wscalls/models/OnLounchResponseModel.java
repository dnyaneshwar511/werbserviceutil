package libs.in.webserviceutil.wscalls.models;

import static libs.in.webserviceutil.wscalls.constant.NullCheckerClass.checkIsNull;

/**
 * Created by apple on 29/12/16.
 */

public class OnLounchResponseModel
{


    public Version version;
    public Configuration configuration;


    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public class Version {
        private String appDownloadUrl;
        private Boolean forceUpdateRequired;
        private String message;
        private Boolean updateAvailable;
        private Boolean stopAppRequired;


        public Boolean getStopAppRequired() {
            return stopAppRequired;
        }

        public void setStopAppRequired(Boolean stopAppRequired) {
            this.stopAppRequired = stopAppRequired;
        }

        public String getAppDownloadUrl() {
            return checkIsNull(appDownloadUrl);
        }

        public void setAppDownloadUrl(String appDownloadUrl) {
            this.appDownloadUrl = appDownloadUrl;
        }

        public Boolean getForceUpdateRequired() {
            return forceUpdateRequired;
        }

        public void setForceUpdateRequired(Boolean forceUpdateRequired) {
            this.forceUpdateRequired = forceUpdateRequired;
        }

        public String getMessage() {
            return checkIsNull(message);
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Boolean getUpdateAvailable() {
            return updateAvailable;
        }

        public void setUpdateAvailable(Boolean updateAvailable) {
            this.updateAvailable = updateAvailable;
        }
    }


    public class Configuration {

        private String appDownloadUrl;
        private String apiUrl;
        private String iosAppVersion;
        private String androidAppVersion;
        private String contactUsUrl;
        private String faqsUrl;
        private String privacyPolicyUrl;
        private String termsOfUseUrl;
        private Integer eventHostTimeDifference;
        private Integer iAmAvailableTimeDifference;
        private Integer defaultPageLimit;
        private String customerSupportEmailId;
        private String iosRateAppUrl;
        private String androidRateAppUrl;
        public String tcAndPPUrl;
        public Integer declareDrawListMaxDrawToShow;
        public String disclaimerUrl;
        public String referAndEarnText;
        public String howToEarnStarsUrl;
        public String howToRedeemStarsUrl;
        public String myDashboardInfoUrl;
        private String winnerWallUrl;

        public String getWinnerWallUrl()
        {
            return winnerWallUrl;
        }

        public void setWinnerWallUrl(String winnerWallUrl)
        {
            this.winnerWallUrl = winnerWallUrl;
        }

        public String getHowToRedeemStarsUrl() {
            return checkIsNull(howToRedeemStarsUrl);
        }

        public void setHowToRedeemStarsUrl(String howToRedeemStarsUrl) {
            this.howToRedeemStarsUrl = howToRedeemStarsUrl;
        }

        public String getMyDashboardInfoUrl() {
            return checkIsNull(myDashboardInfoUrl);
        }

        public void setMyDashboardInfoUrl(String myDashboardInfoUrl) {
            this.myDashboardInfoUrl = myDashboardInfoUrl;
        }

        public String getHowToEarnStarsUrl() {
            return checkIsNull(howToEarnStarsUrl);
        }

        public void setHowToEarnStarsUrl(String howToEarnStarsUrl) {
            this.howToEarnStarsUrl = howToEarnStarsUrl;
        }

        public String getReferAndEarnText() {
            return checkIsNull(referAndEarnText);
        }

        public void setReferAndEarnText(String referAndEarnText) {
            this.referAndEarnText = referAndEarnText;
        }

        public String getDisclaimerUrl() {
            return checkIsNull(disclaimerUrl);
        }

        public void setDisclaimerUrl(String disclaimerUrl) {
            this.disclaimerUrl = disclaimerUrl;
        }

        public Integer getDeclareDrawListMaxDrawToShow() {
            return declareDrawListMaxDrawToShow;
        }

        public void setDeclareDrawListMaxDrawToShow(Integer declareDrawListMaxDrawToShow) {
            this.declareDrawListMaxDrawToShow = declareDrawListMaxDrawToShow;
        }

        public String getTcAndPPUrl() {
            return checkIsNull(tcAndPPUrl);
        }

        public void setTcAndPPUrl(String tcAndPPUrl) {
            this.tcAndPPUrl = tcAndPPUrl;
        }

        public String getAppDownloadUrl() {
            return checkIsNull(appDownloadUrl);
        }

        public void setAppDownloadUrl(String appDownloadUrl) {
            this.appDownloadUrl = appDownloadUrl;
        }

        public String getApiUrl() {
            return checkIsNull(apiUrl);
        }

        public void setApiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
        }

        public String getIosAppVersion() {
            return checkIsNull(iosAppVersion);
        }

        public void setIosAppVersion(String iosAppVersion) {
            this.iosAppVersion = iosAppVersion;
        }

        public String getAndroidAppVersion() {
            return checkIsNull(androidAppVersion);
        }

        public void setAndroidAppVersion(String androidAppVersion) {
            this.androidAppVersion = androidAppVersion;
        }

        public String getContactUsUrl() {
            return checkIsNull(contactUsUrl);
        }

        public void setContactUsUrl(String contactUsUrl) {
            this.contactUsUrl = contactUsUrl;
        }

        public String getFaqsUrl() {
            return checkIsNull(faqsUrl);
        }

        public void setFaqsUrl(String faqsUrl) {
            this.faqsUrl = faqsUrl;
        }

        public String getPrivacyPolicyUrl() {
            return checkIsNull(privacyPolicyUrl);
        }

        public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
            this.privacyPolicyUrl = privacyPolicyUrl;
        }

        public String getTermsOfUseUrl() {
            return checkIsNull(termsOfUseUrl);
        }

        public void setTermsOfUseUrl(String termsOfUseUrl) {
            this.termsOfUseUrl = termsOfUseUrl;
        }

        public Integer getEventHostTimeDifference() {
            return eventHostTimeDifference;
        }

        public void setEventHostTimeDifference(Integer eventHostTimeDifference) {
            this.eventHostTimeDifference = eventHostTimeDifference;
        }

        public Integer getiAmAvailableTimeDifference() {
            return iAmAvailableTimeDifference;
        }

        public void setiAmAvailableTimeDifference(Integer iAmAvailableTimeDifference) {
            this.iAmAvailableTimeDifference = iAmAvailableTimeDifference;
        }

        public Integer getDefaultPageLimit() {
            return defaultPageLimit;
        }

        public void setDefaultPageLimit(Integer defaultPageLimit) {
            this.defaultPageLimit = defaultPageLimit;
        }

        public String getCustomerSupportEmailId() {
            return checkIsNull(customerSupportEmailId);
        }

        public void setCustomerSupportEmailId(String customerSupportEmailId) {
            this.customerSupportEmailId = customerSupportEmailId;
        }

        public String getIosRateAppUrl() {
            return checkIsNull(iosRateAppUrl);
        }

        public void setIosRateAppUrl(String iosRateAppUrl) {
            this.iosRateAppUrl = iosRateAppUrl;
        }

        public String getAndroidRateAppUrl() {
            return checkIsNull(androidRateAppUrl);
        }

        public void setAndroidRateAppUrl(String androidRateAppUrl) {
            this.androidRateAppUrl = androidRateAppUrl;
        }
    }

}
