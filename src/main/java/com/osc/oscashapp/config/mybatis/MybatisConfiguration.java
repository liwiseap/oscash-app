package com.osc.oscashapp.config.mybatis;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.osc.oscashapp.config.datasource.DataBaseConfiguration;

@Configuration
@ConditionalOnClass({ EnableTransactionManagement.class, EntityManager.class })
@AutoConfigureAfter({ DataBaseConfiguration.class })
public class MybatisConfiguration implements EnvironmentAware {

	private static Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);

	private RelaxedPropertyResolver propertyResolver;

	@Resource(name = "dataSource")
	DataSource dataSource;

	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment,"mybatis.");
	}

	/**
	 * 初始化SessionFactory
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public SqlSessionFactory sqlSessionFactory() {
		try {
			
			SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
			sessionFactory.setDataSource(dataSource);
			sessionFactory.setTypeAliasesPackage(propertyResolver.getProperty("typeAliasesPackage"));
			sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(propertyResolver.getProperty("mapperLocations")));
			sessionFactory.setConfigLocation(new DefaultResourceLoader().getResource(propertyResolver.getProperty("configLocation")));

			return sessionFactory.getObject();
		} catch (Exception e) {
			logger.warn("Could not confiure mybatis session factory");
			return null;
		}
	}

	@Bean
	@ConditionalOnMissingBean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
}
