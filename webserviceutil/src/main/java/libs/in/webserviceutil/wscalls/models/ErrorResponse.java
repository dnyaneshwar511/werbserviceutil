package libs.in.webserviceutil.wscalls.models;

import java.util.ArrayList;

import static libs.in.webserviceutil.wscalls.constant.NullCheckerClass.checkIsNull;

/**
 * Created by admin on 15-02-2016.
 */
public class ErrorResponse
{
    private String requestId;
    private String url;
    private int statusCode;
    private int errorCode;
    private ArrayList<errors> errors = new ArrayList<errors>();


    /**
     *
     * @return
     * The sports
     */
    public ArrayList<errors> getError() {
        return errors;
    }

    /**
     *
     * @param errors
     * The sports
     */
    public void setError(ArrayList<errors> errors) {
        this.errors = errors;
    }


    public void addError(errors errorss)
    {
        errors.add(errorss);
    }

    public String getUrl() {
        return checkIsNull(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }



    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getRequestId() {
        return checkIsNull(requestId);
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    public class errors {
    private String displayMessage;
    private String errorMessage;
    private String errorType;
    private String errorProperty;

        public String getDisplayMessage() {
            return checkIsNull(displayMessage);
        }

        public void setDisplayMessage(String displayMessage) {
            this.displayMessage = displayMessage;
        }

        public String getErrorMessage() {
            return checkIsNull(errorMessage);
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorType() {
            return checkIsNull(errorType);
        }

        public void setErrorType(String errorType) {
            this.errorType = errorType;
        }


        public String getErrorProperty() {
            return checkIsNull(errorProperty);
        }

        public void setErrorProperty(String errorProperty) {
            this.errorProperty = errorProperty;
        }

    }
}
