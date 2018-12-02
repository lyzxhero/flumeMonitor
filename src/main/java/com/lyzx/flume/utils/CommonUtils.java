package com.lyzx.flume.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class CommonUtils {
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static final HttpGet httpGet = new HttpGet("http://"+Conf.monitorHost +":"+Conf.monitorPort+"/metrics");

    public static Optional<Result> getRequest(){
        try{
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String context = EntityUtils.toString(entity);
            Result<Integer,String> result = new Result<>(statusCode, context);
            return Optional.of(result);
        }catch(IOException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void sleep(int sleepTime){
        try{TimeUnit.MINUTES.sleep(sleepTime);}catch(InterruptedException e){e.printStackTrace(); }
    }

    public void sleep(){
        sleep(Conf.monitorInterval);
    }
}
