package com.portabull.security;

import com.portabull.security.constants.CommonConstants;
import com.portabull.exception.HRMSException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestHelper {

    private RequestHelper() {
    }

    public static HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) throw new HRMSException("RequestAttributes for the request context is null");
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    public static String getRequestId() {
        Object requestId = RequestHelper.getCurrentRequest().getAttribute(CommonConstants.REQUEST_ID_HEADER);
        return requestId != null ? requestId.toString() : "";
    }

}
