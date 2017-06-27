package com.ai.demos.manager;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;



@Configuration
//扫描 Mapper 接口并容器管理
@MapperScan(basePackages = StudentDataBase.PACKAGE, sqlSessionFactoryRef = "studentSqlSessionFactory")

//从数据源，不是主数据源，对于bean的注入千万不要使用@Primary，只能主数据库使用，不然报错
public class StudentDataBase {

	//dao层的包路径
	static final String PACKAGE = "com.ai.demos.dao.student";
	//mapper文件的相对路径
	static final String MAPPER_LOCATION = "classpath:mapper/student/*.xml";
	
	@Value("${student.datasource.url}")
    private String url;
 
    @Value("${student.datasource.username}")
    private String user;
 
    @Value("${student.datasource.password}")
    private String password;
 
    @Value("${student.datasource.driverClassName}")
    private String driverClass;
	
    @Bean(name = "studentDataSource", destroyMethod =  "close")
    public DataSource studentDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);//用户名
        dataSource.setPassword(password);//密码
        dataSource.setDriverClassName(driverClass);
        dataSource.setInitialSize(2);//初始化时建立物理连接的个数
        dataSource.setMaxActive(20);//最大连接池数量
        dataSource.setMinIdle(0);//最小连接池数量
        dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。
        dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql
        dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
        dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
        return dataSource;
    }
    
    @Bean(name = "studentTransactionManager")
    public DataSourceTransactionManager studentTransactionManager() {
        return new DataSourceTransactionManager(studentDataSource());
    }
	
	@Bean(name = "studentSqlSessionFactory")
    public SqlSessionFactory studentSqlSessionFactory(@Qualifier("studentDataSource") DataSource studentDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(studentDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(StudentDataBase.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}