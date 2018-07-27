package com.cfd;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.config.HttpRequest;
import com.config.RequestGetBackup;
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
            String a="http://www.baidu.com";
            Map resq = HttpRequest.requestGetAndHeader(a, "%&^*()*");
//            for (Object str : resq.keySet()) {
//                System.out.println("key:" + str + " vlue:" + resq.get(str));
//            }
            resq.forEach((key,value)-> System.out.println(key+":"+value));
//            String head = (String) resq.get(2);
//            System.out.println(head);
//            String resq = HttpRequest.requestGet(a, "b");
//            System.out.println(resq);
//            String resq = RequestGetBackup.requestGet(a);
//            System.out.println(resq);

//    	requestGet("http://www.renren.com/PLogin.do");
        }


        @AfterClass
        public void afterClass() {
            System.out.println("===========this is after class=================");
        }
    }

