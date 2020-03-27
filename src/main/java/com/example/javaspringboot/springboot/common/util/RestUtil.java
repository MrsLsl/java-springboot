package com.example.javaspringboot.springboot.common.util;


import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * RestUtil
 * properties for restful
 * common properties defined here
 */
@Service
@Slf4j
public class RestUtil {
   /* @Value("${gateway}")
    public String gateWayUrl;

    @Value("${risauth.client.client-id}")
    public String client_id;

    @Value("${risauth.client.client-secret}")
    public String client_secret;


//    @Autowired
//    CETokenStoreService tokenStoreService;

    public static String USERTOKEN = "userToken";
    public static String RISTOKEN = "access_token";

//    private static final IWSLogger logger = IWSLogger.getInstance();

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    public RedisTemplate redisTemplate;

    public HttpEntity addRequest(Object obj, boolean useSysToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

//        if(useSysToken){
//            httpHeaders.set("Authorization", Constant.TOKEN_PREFIX + tokenStoreService.obtainToken());
//        }
        return new HttpEntity(obj, httpHeaders);
    }

    public HttpEntity addRequest(Object obj) {
        return addRequest(obj,false);
    }


    public Map<String,String> arrayToMap(String[] reqArr, JSONArray resArr){

        if(CollectionUtils.isEmpty(resArr) || ArrayUtils.isEmpty(reqArr) || reqArr.length != resArr.size()){
            return Collections.EMPTY_MAP;
        }
        Map<String,String> resMap = new HashMap<>();
        for(int i=0; i<reqArr.length;i++){
            resMap.put(reqArr[i],(String) resArr.get(i));
        }
        return resMap;
    }

    public JSONArray doubleArrayToMap(String[] reqArr, JSONArray resArr){

        JSONArray res = new JSONArray();
        if(CollectionUtils.isEmpty(resArr) || ArrayUtils.isEmpty(reqArr)){
            return res;
        }
        res.addAll(resArr.stream().map(item->(JSONArray)item)
                .map(item->arrayToMap(reqArr,item)).collect(Collectors.toList()));
        return res;
    }

//    public Object transferApi(Object request, UrlTransfer transferType, boolean useSysToken){
//        log.debug( "requestUrl->"+transferType.getUrl());
//        log.debug( "request->"+JSON.toJSONString(request));
////        logger.writeOperationLog(IWSLogger.LOG_LEVEL_INFO, "requestUrl->"+transferType.getUrl());
////        logger.writeOperationLog(IWSLogger.LOG_LEVEL_INFO, "request->"+JSON.toJSONString(request));
//        try {
//            Object res = restTemplate.postForObject(gateWayUrl + transferType.getUrl(),
//                    addRequest(request,useSysToken), transferType.getResponseClass());
//            log.debug( "response->" + JSON.toJSONString(res));
////            logger.writeOperationLog(IWSLogger.LOG_LEVEL_INFO, "response->" + JSON.toJSONString(res));
//            return res;
//        }catch (HttpClientErrorException e){
//            log.warn( "HttpClientErrorException->" +e.getRawStatusCode() + e.getResponseBodyAsString());
////            logger.writeOperationLog(IWSLogger.LOG_LEVEL_INFO, "HttpClientErrorException->" +e.getRawStatusCode() + e.getResponseBodyAsString());
//        }
//    }

//    public Object transferApi(Object request, UrlTransfer transferType){
//        return transferApi(request, transferType,false);
//    }




//    public List<Map<String, String>> customQuery(String table, List<String> columns, String condition, Integer userId,Boolean useSysToken) {
//        GetDataReq req = GetDataReq.builder().Content(columns.toString()
//                .replace("[","").replace("]",""))
//                .Table(table).Conditionin(condition).UserID(userId+"").build();
//        String[][] ret =  (String[][])transferApi(req, ReportRestApiTransfer.customQuery,useSysToken);
//        List list = new ArrayList();
//        if (ret != null) {
//            for (int k = 0; k < ret.length; k++) {
//                Map map = new HashMap();
//                for (int i = 0; i < columns.size(); i++) {
//                    String[] str = columns.get(i).split("\\.");
//                    map.put(str.length > 1 ? str[1] : str[0], ret[k][i]);
//                }
//                list.add(map);
//            }
//        }
//        return list;
//    }

//    public List<Map<String, String>> customQuery(String table, List<String> columns, String condition, Integer userId) {
//        return customQuery(table,columns,condition,userId,false);
//    }
*/
}
