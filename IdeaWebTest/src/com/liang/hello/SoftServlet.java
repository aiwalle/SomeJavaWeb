package com.liang.hello;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liang on 2018/3/8.
 */
public class SoftServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println("TestServlet.service");
        System.out.println("SoftServlet.service");
    }


}
