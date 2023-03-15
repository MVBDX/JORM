package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyDataSourceFactory {

    public static DataSource getDataSource() {
        Properties properties = new Properties();
        InputStream inputStream;
        BasicDataSource dataSource = new BasicDataSource();

        try {
            inputStream = MyDataSourceFactory.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        dataSource.setDriverClassName(properties.getProperty("DB_DRIVER_CLASS"));
        dataSource.setUrl(properties.getProperty("DB_URL"));
        dataSource.setUsername(properties.getProperty("DB_USERNAME"));
        dataSource.setPassword(properties.getProperty("DB_PASSWORD"));
        return dataSource;
    }

}