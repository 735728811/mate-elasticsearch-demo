package vip.mate.elasticsearch.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;
import vip.mate.elasticsearch.entity.User;
import vip.mate.elasticsearch.service.IEsService;

import java.io.IOException;
import java.util.Map;

@Service
@AllArgsConstructor
public class EsServiceImpl implements IEsService {

    private final RestHighLevelClient restHighLevelClient;
    private final String indexName = "indexname";

    @Override
    public boolean save(User user, String indexId) throws IOException {
        String json = JSON.toJSONString(user);
        IndexRequest request = new IndexRequest(indexName).id(indexId).source(json, XContentType.JSON);
        restHighLevelClient.index(request, RequestOptions.DEFAULT);
        return true;
    }

    @Override
    public Map<String, Object> query(String indexId) throws IOException  {
        GetRequest request = new GetRequest(indexName, indexId);
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        return response.getSource();
    }
}
