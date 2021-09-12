//package com.test.datasource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * Created by AdministratorZhang on 2018/3/29.
// */
//@Configuration // 注册到springboot容器中
//@MapperScan(basePackages = "com.test.test002", sqlSessionFactoryRef = "test2SqlSessionFactory")
//public class DataSource2Config {
//
//    /**
//     *
//     * @methodDesc: 功能描述:(配置test2数据库)
//     */
//    @Bean(name = "test2DataSource")//自定义数据源
//    //@Primary
//    @ConfigurationProperties(prefix = "spring.datasource.test2")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     *
//     * @methodDesc: 功能描述:(test2 sql会话工厂)
//     */
//    @Bean(name = "test2SqlSessionFactory")
//    //@Primary
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource)
//            throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
////		bean.setMapperLocations(
////				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test2/*.xml"));
//        return bean.getObject();
//    }
//
//    /**
//     *
//     * @methodDesc: 功能描述:(test2 事物管理)
//     */
//    @Bean(name = "test2TransactionManager")
//    //@Primary
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "test2SqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(
//            @Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
