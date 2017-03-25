package login;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.*;
import cn.itcast.servlet.BaseServlet;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import domain.User;
import service.UserService;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 * Created by Tao on 3/23/2017.
 */

public class Login extends HttpServlet{
    UserService userService=new UserService();

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        User user=CommonUtils.toBean(request.getParameterMap(),User.class);
        User valid=userService.find(user.getUsername());
        if(valid==null){
            request.getRequestDispatcher("signup.jsp?msg=Sign up first").forward(request,response);
        }else{
            if(valid.getPassword().equals(user.getPassword())){
                request.getRequestDispatcher("welcome.jsp").forward(request,response);
            }else
                request.getRequestDispatcher("signin.jsp?msg=Wrong password").forward(request,response);
        }

    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{


    }
}
