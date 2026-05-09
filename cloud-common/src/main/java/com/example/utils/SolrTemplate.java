package com.example.utils;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.common.SolrDocumentList;

public class SolrTemplate {

    private final SolrClient solrClient;

    public SolrTemplate(SolrClient solrClient) {
        this.solrClient = solrClient;
    }

    public SolrDocumentList query(String q) throws Exception {
        SolrQuery query = new SolrQuery(q);
        query.setRows(20);
        return solrClient.query(query).getResults();
    }

    public void save(Object bean) throws Exception {
        solrClient.addBean(bean);
        solrClient.commit();
    }

    public void delete(String id) throws Exception {
        solrClient.deleteById(id);
        solrClient.commit();
    }
}