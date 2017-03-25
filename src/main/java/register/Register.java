package register;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.*;
import cn.itcast.servlet.BaseServlet;
import domain.User;
import service.UserService;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Tao on 3/23/2017.
 */

public class Register extends HttpServlet{
    UserService userService=new UserService();
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        User user=CommonUtils.toBean(request.getParameterMap(),User.class);
        //check whether the username has been signup

        User valid=userService.find(user.getUsername());
        if(valid!=null)
            request.getRequestDispatcher("signup.jsp?msg=UserNameHasSignUp").forward(request,response);
        else{
            user.setId(CommonUtils.uuid());
            userService.add(user);
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response){
        User user=CommonUtils.toBean(request.getParameterMap(),User.class);
        user.setId(CommonUtils.uuid());
        userService.add(user);
    }
}
