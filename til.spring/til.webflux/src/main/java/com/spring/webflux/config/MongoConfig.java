package com.spring.webflux.config;

/*
@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.spring.webflux.repository")
public class MongoConfig extends AbstractReactiveMongoConfiguration {

  @Value("${port}")
  private String port;

  @Value("${dbname}")
  private String dbName;


  @Override
  public MongoClient reactiveMongoClient() {
    return MongoClients.create();
  }

  @Override
  protected String getDatabaseName() {
    return dbName;
  }

  @Bean
  public ReactiveMongoTemplate reactiveMongoTemplate() {
    return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
  }
}
*/