package vip.mate.elasticsearch.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.mate.elasticsearch.entity.User;
import vip.mate.elasticsearch.service.IEsService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class TestEsController {

    private final IEsService esService;

    @RequestMapping(value = "helloEs")
    public Map<String, Object> hello() {

        Map<String, Object> query = new HashMap<>();
        try{
            User user = User.builder()
                    .id(1L)
                    .name("张三")
                    .desc("张三是名JAVA开发工程师")
                    .build();
            String indexId = "test001";
            esService.save(user, indexId);

            User user2 = User.builder()
                    .id(2L)
                    .name("李四")
                    .desc("李四是一名数据产品经理")
                    .build();
            indexId = "test002";
            esService.save(user2, indexId);

            query = esService.query(indexId);
        }catch (IOException e){
            e.printStackTrace();
        }
//        return Result.data(query);
        return query;
    }
}
