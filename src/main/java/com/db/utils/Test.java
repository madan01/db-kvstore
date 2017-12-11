package com.db.utils;

import java.sql.*;
import java.util.BitSet;
import java.util.Properties;

/**
 * Created by madan on 10/12/17.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
/*        String url = "jdbc:postgresql://localhost/postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","123");
        Connection conn = DriverManager.getConnection(url, props);*/

        BitSet bitset = new BitSet(30);
        bitset.set(1);
        String key="test03";
        KeyvalueStore keyvalueStore = new KeyvalueStore("test01");
        //System.out.println(keyvalueStore.put(key,bitset.toByteArray()));
        System.out.println(BitSet.valueOf(keyvalueStore.get("test04")));

/*      Insert
        PreparedStatement st = conn.prepareStatement("insert into test01 (id,value) values (?,?)");
        st.setString(1,"test2");
        st.setBytes(2,bitset.toByteArray());
        st.execute();*/

/*        PreparedStatement st = conn.prepareStatement("select value from test01 where  (id=?)");
        st.setString(1,"Test");
        ResultSet rs =st.executeQuery();
        while(rs.next()){
            System.out.println(BitSet.valueOf(rs.getBytes(1)));
        }

        st.close();*/

    }
}
