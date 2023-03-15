package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyDataSourceFactory {

    public static DataSource getDataSource() {
        Properties props = new Properties();
        InputStream fis;
        BasicDataSource ds = new BasicDataSource();

        try {
            fis = MyDataSourceFactory.class.getClassLoader().getResourceAsStream("db.properties");
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        ds.setDriverClassName(props.getProperty("DB_DRIVER_CLASS"));
        ds.setUrl(props.getProperty("DB_URL"));
        ds.setUsername(props.getProperty("DB_USERNAME"));
        ds.setPassword(props.getProperty("DB_PASSWORD"));
        return ds;
    }

}