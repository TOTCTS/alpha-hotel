package org.best.alpha.constant;

public interface DaoConstant {

    interface Jdbc{

        String DRIVER_CLASS_NAME = "jdbc.driverClassName";
        String URL = "jdbc.url";
        String USERNAME = "jdbc.username";
        String PASSWORD = "jdbc.password";

    }

    interface Mybatis{

        String MAPPER_LOCATIONS = "classpath:mapper/*.xml";
        String TYPE_ALIASES_PACKAGE = "org.best.alpha.entity";

    }

}
