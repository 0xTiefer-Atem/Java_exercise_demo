package org.Daolevel;

import com.mysql.jdbc.PreparedStatement;
import org.Info.DriverCarMess;
import org.Jdbc.DataDase;
import org.Servlet.DriverMess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author:WangQian
 * Date: 18-6-27 上午9:03
 */
public class DriverDao {
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ArrayList<DriverCarMess> drivermesseslist = null;

    public HashMap<String, DriverCarMess> getDrivermap() {
        System.out.println(drivermap);
        return drivermap;
    }

    public ArrayList<DriverCarMess> getDrivermesseslist(String type,String value) {
        ArrayList<DriverCarMess> driverlist = new ArrayList<>();
        for (DriverCarMess dcms:drivermesseslist) {
            if (type.equals("id")) {
                if (dcms.getOwner_id().equals(value)) {
                    driverlist.add(dcms);
                }
            }
            else if (type.equals("car_owner")) {
                if (dcms.getCar_owner().equals(value)) {
                    driverlist.add(dcms);
                }
            }
            else if (type.equals("age")) {
                if (dcms.getOwner_age().equals(value)) {
                    driverlist.add(dcms);
                }
            }
            else if (type.equals("gender")) {
                if (dcms.getGender().equals(value)) {
                    driverlist.add(dcms);
                }
            }
            else if (type.equals("address")) {
                if (dcms.getOwner_dress().equals(value)) {
                    driverlist.add(dcms);
                }
            }
            else if (type.equals("cat_type")) {
                if (dcms.getCar_type().equals(value)) {
                    driverlist.add(dcms);
                }
            }
            else if (type.equals("drive_time")) {
                if (dcms.getDrive_time().equals(value)) {
                    driverlist.add(dcms);
                }
            }
            else if (type.equals("register_time")) {
                if (dcms.getRegister_date().equals(value)) {
                    driverlist.add(dcms);
                }
            }
        }
        return driverlist;
    }


    private HashMap<String ,DriverCarMess> drivermap;

    private static DriverDao driverDao = new DriverDao();

    public static DriverDao getNewIntences(){
        if(driverDao==null){
            driverDao = new DriverDao();
            return driverDao;
        }
        return driverDao;
    }
    private DriverDao(){
        DataDase database = new DataDase();
        conn = database.getConn();
        drivermap = new HashMap<>();
    }

    public DriverCarMess getDriver(String id) {
        System.out.println(drivermap);
        DriverCarMess driverCarMess = drivermap.get(id);
        if(driverCarMess == null){
            System.out.println("driver is null");
            return null;
        }
        return driverCarMess;
    }

    public ArrayList selectDriver() throws SQLException {
        drivermesseslist = new ArrayList<>();
        String selectsql = "select *from driver_car_mess";
        ResultSet res = null;
        try {
            pst = (PreparedStatement) conn.prepareStatement(selectsql);
            res = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (res.next()){
            DriverCarMess dcm = new DriverCarMess();
            dcm.setId(Integer.parseInt(res.getString(1)));
            dcm.setOwner_id(res.getString(2));
            dcm.setCar_owner(res.getString(3));
            dcm.setGender(res.getString(4));
            dcm.setTele_num(res.getString(5));
            dcm.setOwner_dress(res.getString(6));
            dcm.setDrive_time(res.getString(7));
            dcm.setRegister_date(res.getString(8));
            dcm.setCar_id(res.getString(9));
            dcm.setCar_type(res.getString(10));
            dcm.setOwner_age(res.getString(11));
            drivermesseslist.add(dcm);
            drivermap.put(dcm.getOwner_id(),dcm);
        }
        return drivermesseslist;
    }



    public boolean removeDriver(int id){
        String sqldelete = "delete from driver_car_mess where id=?";
        System.out.println(sqldelete);
        boolean flag = false;
        try {
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sqldelete);
            pst.setInt(1,id);
            flag = pst.executeUpdate()>0;
            System.out.println(pst.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    public boolean editDriver(String editsql) {
        boolean flag = false;
        try {
            PreparedStatement pst =(PreparedStatement) conn.prepareStatement(editsql);
            flag = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


}
