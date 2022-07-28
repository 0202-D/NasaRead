import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * @author Dm.Petrov
 * DATE: 28.07.2022
 */
public class ParserToPost {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private CloseableHttpClient getCloseableHttpClient() {
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();
    }

    public Post parse(String url) {
        Post post = null;
        CloseableHttpClient httpClient = getCloseableHttpClient();
        HttpGet request = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            post = objectMapper.readValue(response.getEntity().getContent(),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return post;
    }
}