package com.watayouxiang.dagger2demo.others;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/11/09
 *     desc   :
 * </pre>
 */
public class HttpClient {
    private final String baseUrl;

    public HttpClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String toString() {
        return "HttpClient{" +
                "baseUrl='" + baseUrl + '\'' +
                '}';
    }
}
