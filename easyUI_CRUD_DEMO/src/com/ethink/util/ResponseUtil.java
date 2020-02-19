package com.ethink.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Yule_Liu
 * @version V 1.0.0
 * @description
 * @date 2020/2/19 21:41
 */
public class ResponseUtil {
    public static void write(HttpServletResponse response, Object o)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print(o.toString());
        out.flush();
        out.close();
    }
}
