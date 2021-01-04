package com.zwaking.common.net;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author: waking
 * @date: 2020/11/26 11:20
 */
public class DefaultHttpClient {

    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();
        URI wxUri =
            URI.create("https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID");
        HttpRequest request = HttpRequest.newBuilder(wxUri).build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
