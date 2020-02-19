package com.ethink.web;

import com.ethink.dao.UserDao;
import com.ethink.model.PageBean;
import com.ethink.util.DbUtil;
import com.ethink.util.JsonUtil;
import com.ethink.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * @author Yule_Liu
 * @version V 1.0.0
 * @description
 * @date 2020/2/19 13:15
 */
public class UserListServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    DbUtil dbUtil=new DbUtil();
    UserDao userDao=new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page=request.getParameter("page");
        String rows=request.getParameter("rows");
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));

        Connection con=null;
        try {
            con=dbUtil.getCon();
            JSONObject result=new JSONObject();
            JSONArray jsonArray=JsonUtil.formatRsToJsonArray(userDao.userList(con, pageBean));
            int total=userDao.userCount(con);
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }


}