package org.Daolevel;

import com.mysql.jdbc.PreparedStatement;
import org.Info.User;
import org.Jdbc.DataDase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author:WangQian
 * Date: 18-7-13 上午1:32
 */
public class UserDao {
    private static UserDao userdao= null;
    private HashMap<String,User> userhash = new HashMap<>();
    private ArrayList<User> userlist = new ArrayList<>();
    private Connection conn = null;
    private PreparedStatement pst = null;

    private UserDao(){
        DataDase dataDase = new DataDase();
        conn = dataDase.getConn();
        String usersql = "select * from user_res";
        try {
            pst = (PreparedStatement) conn.prepareStatement(usersql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                User user = new User();
                user.setId(Integer.parseInt(res.getString("id")));
                user.setName(res.getString("name"));
                user.setTele_num(res.getString("tele_num"));
                user.setStart(res.getString("start"));
                user.setEnd(res.getString("end"));
                userlist.add(user);
                userhash.put(user.getName(),user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, User> getUserhash() {
        return userhash;
    }

    public static UserDao getnewInstance(){
        if(userdao == null){
            return new UserDao();
        }
        return userdao;
    }

    public ArrayList<User> getUserlist() {
        return userlist;
    }
}
