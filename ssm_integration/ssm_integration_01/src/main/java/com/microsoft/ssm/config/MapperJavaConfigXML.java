package com.microsoft.ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * @Description 配置 SqlSessionFactoryBean 数据库连接池 mapper映射
 *             当配置类被加载时，Spring容器会首先处理Bean的定义和初始化，其中包括`sqlSessionFactoryBean`和`mapperScannerConfigurer`
 *             的初始化。在这个过程中，如果`@Value`注解所在的Bean还没有被完全初始化，可能会导致注入的属性值为null。
 * @Author frank
 * @Date 2024/10/16
 */
@Configuration
/*@PropertySource("classpath:jdbc.properties")*/
public class MapperJavaConfigXML {
/*    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driver;


    //数据库连接池配置
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }*/

    /**
     * 配置SqlSessionFactoryBean,指定连接池对象和外部配置文件即可 factorybean内部会自动产生sqlsessionFactory对象注入到ioc中
     * @param dataSource 需要注入连接池对象
     * @return 工厂Bean
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        //实例化SqlSessionFactory工厂
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        //设置连接池
        sqlSessionFactoryBean.setDataSource(dataSource);

        //设置配置文件
        //包裹外部配置文件地址对象
        Resource resource = new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);

        return sqlSessionFactoryBean;
    }

    /**
     * 配置Mapper实例扫描工厂,配置 <mapper <package 对应接口和mapperxml文件所在的包
     * 本质上就是一个mapper代理对象的factorybean 将指定包中的mapper接口通过sqlsessionfactory创建的sqlsession得到mapper代理对象 最终放入ioc
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //设置mapper接口和xml文件所在的共同包
        mapperScannerConfigurer.setBasePackage("com.microsoft.ssm.mapper");
        return mapperScannerConfigurer;
    }

}
