package com.urong.test.configuration;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// neo4j version => 4.0.0

/*@Configuration
@EnableTransactionManagement
@ComponentScan("com.urong.test")
@EnableNeo4jRepositories("com.urong.test.repository")*/
public class MyNeo4jConfiguration extends Neo4jConfiguration {

	@Override
	public SessionFactory getSessionFactory() {
		return new SessionFactory("com.urong.test.domain");
	}

	// http://127.0.0.1:7474

/*	@Override
	public Neo4jServer neo4jServer() {
		return new RemoteServer("http://107.23.94.190:33948/", "neo4j", "discard-rig-rheostat");
	}*/

	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Session getSession() throws Exception {
		return super.getSession();
	}

}
