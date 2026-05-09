package com.example.config;

import com.example.utils.SolrTemplate;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolrAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.solr")
    public SolrProperties solrProperties() {
        return new SolrProperties();
    }

    @Bean
    public SolrClient solrClient(SolrProperties prop) {
        String url = prop.getHost() + "/" + prop.getCore();
        return new HttpSolrClient.Builder(url)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient solrClient) {
        return new SolrTemplate(solrClient);
    }

    // 内部属性类，干净封闭
    public static class SolrProperties {
        private String host;
        private String core;

        public String getHost() { return host; }
        public void setHost(String host) { this.host = host; }
        public String getCore() { return core; }
        public void setCore(String core) { this.core = core; }
    }
}