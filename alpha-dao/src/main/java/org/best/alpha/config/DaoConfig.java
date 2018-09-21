package org.best.alpha.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.best.alpha.constant.DaoConstant;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@ComponentScan(basePackages = {"org.best.alpha"})
@MapperScan(basePackages = {"org.best.alpha.mapper"})
public class DaoConfig implements TransactionManagementConfigurer {

//    @Value(DaoConstant.Jdbc.DRIVER_CLASS_NAME)
    private String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

//    @Value(DaoConstant.Jdbc.URL)
    private String URL = "jdbc:mysql://localhost:3306/hotel";

//    @Value(DaoConstant.Jdbc.USERNAME)
    private String USERNAME = "root";

//    @Value(DaoConstant.Jdbc.PASSWORD)
    private String PASSWORD = "admin123";

    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(DRIVER_CLASS_NAME);
        druidDataSource.setUrl(URL);
        druidDataSource.setUsername(USERNAME);
        druidDataSource.setPassword(PASSWORD);
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(ApplicationContext applicationContext) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(DaoConstant.Mybatis.MAPPER_LOCATIONS));
        sqlSessionFactoryBean.setTypeAliasesPackage(DaoConstant.Mybatis.TYPE_ALIASES_PACKAGE);
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager();
    }
}
