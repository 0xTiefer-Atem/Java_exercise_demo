package org.Info;

import com.mysql.jdbc.Connection;
import org.Jdbc.DataDase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


/**
 * Author:WangQian
 * Date: 18-6-24 下午9:24
 */
public class CountAndPwd {
    private HashMap<String,String> counthash = new HashMap<>();
    private HashMap<String,String> typehash = new HashMap<>();



    public  CountAndPwd(){
        Connection connection;
        try {
            DataDase dataDase = new DataDase();
            connection = dataDase.getConn();
            String sql0 = "select type,count,pwd from count_pwd";
            PreparedStatement ps1 = connection.prepareStatement(sql0);
            ResultSet res = ps1.executeQuery();
            while (res.next()){
                counthash.put(res.getString("count"), res.getString("pwd"));
                typehash.put(res.getString("pwd"), res.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public HashMap<String, String> getCounthash() {
        return counthash;
    }

    public HashMap<String, String> getTypehash() {
        return typehash;
    }
}
