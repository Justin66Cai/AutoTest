package com.cfd;
import java.util.Iterator;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
    public class TestGet {

        @BeforeClass
        public void beforeClass() {
            System.out.println("==========this is before class===============");
        }

        @Test
        public void testGet() throws Exception{
            requestGet("http://www.baidu.com");
//    	requestGet("http://www.renren.com/PLogin.do");
        }
        private void requestGet(String urlWithParams) throws Exception {
            CloseableHttpClient httpclient = HttpClientBuilder.create().build();

            HttpGet httpget = new HttpGet(urlWithParams);
            //配置请求的超时设置
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(50)
                    .setConnectTimeout(50)
                    .setSocketTimeout(50).build();
            httpget.setConfig(requestConfig);

            CloseableHttpResponse response = httpclient.execute(httpget);
            System.out.println("响应码StatusCode -> " + response.getStatusLine().getStatusCode());

            HttpEntity entity = response.getEntity();
            String jsonStr = EntityUtils.toString(entity);//, "utf-8");

            char c=jsonStr.trim().charAt(0);
            if('['==c){
                JSONArray jsonArray=new JSONArray(jsonStr);
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObj=jsonArray.getJSONObject(i);
                    Iterator ite=jsonObj.keys();
                    while(ite.hasNext()){
                        String key=(String) ite.next();
                        System.out.println("key=:"+key+",value=:"+jsonObj.getString(key));
                    }
                }
            }
            else if('{'==c){
                JSONObject jsonObj1=new JSONObject(jsonStr);
                Iterator ite=jsonObj1.keys();
                while(ite.hasNext()){
                    String key=(String) ite.next();
                    System.out.println("解析后的数据：key="+key+",value="+jsonObj1.getString(key));
                }
            }
            httpget.releaseConnection();
        }

        @AfterClass
        public void afterClass() {
            System.out.println("===========this is after class=================");
        }
    }

