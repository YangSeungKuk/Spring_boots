package kr.inhatc.spring.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
//db설정한 파일과 연동
@PropertySource("classpath:/application.properties")
public class DataBaseConfiguration {

	//DB설정정보를 가져오는 용도
	@Autowired
	private ApplicationContext appContext;
	
	//메모리로 올리기 위해서 Bean사용
	@Bean
	//접두어로 앞에 붙이기 위해 사용, "spring.datasource.hikari"로 설정
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	//데이터 소스를 연결하기 위한 준비
	public DataSource dataSouce() throws Exception{
		//hikariConfig()에 접근해서 데이터를 받아옴
		DataSource dataSource = new HikariDataSource(hikariConfig());
		//제대로 되는지 확인하는 용도
		System.out.println("=============>" + dataSource.toString());
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		//매퍼 연결
		sqlSessionFactoryBean.setMapperLocations(
				appContext.getResources("classpath:/mapper/**/sql-*.xml")
				);
		
		//마이바티스에 대한 설정추가
		sqlSessionFactoryBean.setConfiguration(myBatisConfig());
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration myBatisConfig(){
		return new org.apache.ibatis.session.Configuration();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : JPA 설정
	 * 2. 처리내용 : JPA 설정 빈 등록
	 * </pre>
	 * @Method Name : hibernateConfig
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.jpa")
	public Properties hibernateConfig() {
		return new Properties();
	}
}
