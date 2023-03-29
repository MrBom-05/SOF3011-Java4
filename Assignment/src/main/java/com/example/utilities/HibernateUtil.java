package com.example.utilities;

import com.example.entities.*;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=SOF3011");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.SHOW_SQL, "true");

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(ChiTietSP.class);
        configuration.addAnnotatedClass(ChucVu.class);
        configuration.addAnnotatedClass(CuaHang.class);
        configuration.addAnnotatedClass(DongSP.class);
        configuration.addAnnotatedClass(GioHang.class);
        configuration.addAnnotatedClass(GioHangChiTiet.class);
        configuration.addAnnotatedClass(HoaDon.class);
        configuration.addAnnotatedClass(HoaDonChiTiet.class);
        configuration.addAnnotatedClass(KhachHang.class);
        configuration.addAnnotatedClass(MauSac.class);
        configuration.addAnnotatedClass(NhanVien.class);
        configuration.addAnnotatedClass(NSX.class);
        configuration.addAnnotatedClass(SanPham.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        FACTORY = configuration.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }
}
