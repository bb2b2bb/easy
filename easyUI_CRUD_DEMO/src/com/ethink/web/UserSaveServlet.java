package com.ethink.web;

import com.ethink.dao.UserDao;
import com.ethink.model.User;
import com.ethink.util.DbUtil;
import com.ethink.util.ResponseUtil;
import com.ethink.util.StringUtil;
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
 * @date 2020/2/19 13:30
 */
public class UserSaveServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    DbUtil dbUtil = new DbUtil();
    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String id = request.getParameter("id");

        User user = new User(name, age, email);
        if (StringUtil.isNotEmpty(id)) {
            user.setId(Integer.parseInt(id));
        }

        Connection con = null;
        try {
            int saveNums = 0;
            con = dbUtil.getCon();
            JSONObject result = new JSONObject();
            if (StringUtil.isNotEmpty(id)) {
                saveNums = userDao.userModify(con, user);
            } else {
                saveNums = userDao.userAdd(con, user);
            }
            if (saveNums == 1) {
                result.put("success", "true");
            } else {
                result.put("success", "true");
                result.put("errorMsg", "保存成功");
            }
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}

