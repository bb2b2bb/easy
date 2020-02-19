package com.ethink.web;

import com.ethink.dao.UserDao;
import com.ethink.util.DbUtil;
import com.ethink.util.ResponseUtil;
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
 * @date 2020/2/19 15:02
 */
public class UserDeleteServlet extends HttpServlet {

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
        // String delId=request.getParameter("delId");
        String delId=request.getParameter("delId");
        Connection con=null;
        try {
            con=dbUtil.getCon();
            JSONObject result=new JSONObject();
            int delNums=userDao.userDelete(con, delId);
            if(delNums==1){
                result.put("success", "true");
            }else{
                result.put("errorMsg", "111删除失败");
            }
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