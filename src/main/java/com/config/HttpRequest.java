package com.config;

import java.io.IOException;
import java.util.*;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public  final class HttpRequest{

   public  static String requestGet(String urlWithParams, String checkPoint) throws Exception {
       CloseableHttpClient httpCilent = HttpClientBuilder.create().build();//Creates CloseableHttpClient instance with default configuration.
       HttpGet httpGet = new HttpGet(urlWithParams);
       RequestConfig requestConfig = RequestConfig.custom()
               .setConnectionRequestTimeout(50)
               .setConnectTimeout(50)
               .setSocketTimeout(50).build();
       httpGet.setConfig(requestConfig);
       CloseableHttpResponse response =  httpCilent.execute(httpGet);
//       System.out.println("响应码:"+response.getStatusLine().getStatusCode());
//       获取返回的body数据
       HttpEntity entity = response.getEntity();
       String res = EntityUtils.toString(entity,"UTF-8");
//       返回的是 -1说明包含checkpoint
       if(res.indexOf(checkPoint) != -1){
           System.out.println("getEntity:"+res);
       }else {
           System.out.println("没有找到:"+checkPoint);
       }
        httpCilent.close();//释放资源
       return res;
   }
    public  static Map<String,String> requestGetAndHeader(String urlWithParams, String checkPoint) throws Exception {
        CloseableHttpClient httpCilent = HttpClientBuilder.create().build();//Creates CloseableHttpClient instance with default configuration.
        HttpGet httpGet = new HttpGet(urlWithParams);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(50).setConnectTimeout(50).setSocketTimeout(50).build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = httpCilent.execute(httpGet);
//       System.out.println("响应码:"+response.getStatusLine().getStatusCode());
//       获取返回的body数据
        HttpEntity entity = response.getEntity();
        String res = EntityUtils.toString(entity, "UTF-8");
//       返回的是 -1说明包含checkpoint
        if (res.indexOf(checkPoint) != -1) {
//            System.out.println("getEntity:");
        } else {
            System.out.println("没有找到:" + checkPoint);
        }
        Header[] headers = response.getAllHeaders();

        Map<String, String> myheader = new LinkedHashMap<>();
        for (Header header : headers) {
            myheader.put(header.getName(), header.getValue());
        }
        myheader.put("res", res);
//        myheader.forEach((key,value)-> System.out.println(key+":"+value));
        httpCilent.close();//释放资源
        return myheader;
    }

}
