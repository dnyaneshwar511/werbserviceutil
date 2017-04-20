package libs.in.webserviceutil.wscalls;

/**
 * Created by apple on 25/05/15.
 */
public enum HttpResponseStatus
{
    INVALID_URL_ENCODING
            {
                @Override
                public String toString()
                {
                    return "URL is not valid.";
                }
            },
    NO_NEWTWORK_ERROR
            {
                @Override
                public String toString()
                {
                    return "Network is not available.";
                }
            },
    UNABLE_TO_CONNECT
            {
                @Override
                public String toString()
                {
                    return "Unable to connect with server.";
                }
            },
    RESPONSE_RECEIVED
            {
                @Override
                public String toString()
                {
                    return super.toString();
                }
            },
    AUTHORIZATION_REQUIRED
            {
                @Override
                public String toString()
                {
                    return super.toString();
                }
            },
    BAD_REQUEST
            {
                @Override
                public String toString()
                {
                    return "Bad request due to decoding the data.";
                }
            },
    INTERNAL_SERVER_ERROR
            {
                @Override
                public String toString()
                {
                    return "Internal server error due to encoding the data.";
                }
            },
    USER_NOT_FOUND
            {
                @Override
                public String toString()
                {
                    return "Given user not found\n";
                }
            },
    Forbidden
            {
                public String toString()
                {
                    return "Session key not available";
                }

            }, DUPLICATE_USERNO
        {
            @Override
            public String toString()
            {
                return "Duplicate";
            }
        },
    INVALID_ANSWER
            {
                @Override
                public String toString()
                {
                    return "InvalidAnswer";
                }
            },
    INVALID_TOKEN
            {
                @Override
                public String toString()
                {
                    return "InvalidToken";
                }
            }

}
