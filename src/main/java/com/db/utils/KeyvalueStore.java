package com.db.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by madan on 11/12/17.
 */
public class KeyvalueStore {
    private String storeName;

    public KeyvalueStore(String storeName){
        this.storeName=storeName;
    }

    // puts key as string and value as byte array
    public boolean put(String key, byte[] value){
        PreparedStatement st=null;
        Connection conn=null;
        try {
            conn = DataSource.getConnection();
            st = conn.prepareStatement("insert into "+storeName +"(id,value) values (?,?)");
            st.setString(1,key);
            st.setBytes(2,value);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    // gets the value as byte array
    public byte[] get(String key){
        PreparedStatement st=null;
        Connection conn=null;
        ResultSet rs=null;
        byte[] value=null;
        try {
            conn = DataSource.getConnection();
            st = conn.prepareStatement("select value from test01 where  (id=?)");
            st.setString(1,key);
            rs=st.executeQuery();
            while(rs.next()){ // get the only value as the query is based on primary key
                value = rs.getBytes(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
