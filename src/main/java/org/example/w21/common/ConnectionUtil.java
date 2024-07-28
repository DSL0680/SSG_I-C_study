package org.example.w21.common;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public enum ConnectionUtil {

    INSTANCE;

    private HikariDataSource ds;

    private ConnectionUtil() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:13306/soldb");
        config.setUsername("webdbuserds");
        config.setPassword("webdbuserds");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setConnectionTimeout(1000*10);
        config.setMaximumPoolSize(20); // WAS의 쓰레드 개수
        config.setMaximumPoolSize(1); // 처음부터 연결을 많이 하면 비용문제

        ds = new HikariDataSource(config);
    }

    public HikariDataSource getDs() {
        return ds;
    }

}
