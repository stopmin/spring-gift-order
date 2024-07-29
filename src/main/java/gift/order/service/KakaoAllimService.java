package gift.order.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class KakaoAllimService {
    private final RestClient restClient;

    public KakaoAllimService(RestClient restClient) {
        this.restClient = restClient;
    }

    public void sendAllim(String accessToken, String templateObject) {
        restClient.post()
                .uri("https://kapi.kakao.com/v2/api/talk/memo/default/send")
                .header("Authorization", "Bearer " + accessToken)
                .body(templateObject)
                .retrieve()
                .body(String.class);
    }
}
