package connection;

import domain.User;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tao on 3/23/2017.
 */
public class Connection {

    private QueryRunner qr=new TxQueryRunner();
    public void add(User user){
        try{
            String sql="insert into t_user values(?,?,?,?)";
            Object[]params={user.getId(),user.getUsername(),user.getPassword(),user.getEmail()};
            qr.update(sql,params);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public User find(String username){
        try{
            String sql="select * from t_user where username=?";
            return qr.query(sql,new BeanHandler<User>(User.class),username);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
