package com.training.aem.core.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public final class ThridPartyApiCallUtility {
    public static String callThirdPartyApi(String method, String apiUrl) {
        String readData = null;
        if (method.equals("GET")) {
            HttpGet httpGet = new HttpGet(apiUrl);
            readData = callApi(httpGet);
        }

        return readData;

    }
    private static String callApi(HttpGet httpGet)  {
        try(CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet)){
            HttpEntity httpEntity = httpResponse.getEntity();
            try (InputStream inputStream = httpEntity.getContent()) {
                return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            }

        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
