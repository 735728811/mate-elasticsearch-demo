package vip.mate.elasticsearch.service;

import vip.mate.elasticsearch.entity.User;

import java.io.IOException;
import java.util.Map;

public interface IEsService {

    boolean save(User user, String indexId) throws IOException;

    Map<String, Object> query(String indexId) throws IOException;
}
