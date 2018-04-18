package com.liang.crm.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liang on 2018/4/14.
 */
public class UserContext {
    public static final String USER_IN_SESSION = "user_in_session";

    private static ThreadLocal<HttpServletRequest> local = new ThreadLocal<HttpServletRequest>();

    public static void set(HttpServletRequest request) {
        local.set(request);
    }

    public static HttpServletRequest get() {
        return local.get();
    }

}
