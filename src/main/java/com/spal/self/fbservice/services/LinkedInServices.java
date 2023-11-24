package com.spal.self.fbservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class LinkedInServices {

    @Autowired
    RestTemplate restTemplate;

    public void createPost() {
        String url = "https://api.linkedin.com/rest/posts";//77ua8vycvryy1r
        String jsonBody = "{\n" +
                "  \"author\": \"urn:li:organization:5515715\",\n" +
                "  \"commentary\": \"Sample text Post\",\n" +
                "  \"visibility\": \"PUBLIC\",\n" +
                "  \"distribution\": {\n" +
                "    \"feedDistribution\": \"MAIN_FEED\",\n" +
                "    \"targetEntities\": [],\n" +
                "    \"thirdPartyDistributionChannels\": []\n" +
                "  },\n" +
                "  \"lifecycleState\": \"PUBLISHED\",\n" +
                "  \"isReshareDisabledByAuthor\": false\n" +
                "}";
        String resp = restTemplate.postForObject(url, jsonBody, String.class);
        System.out.println(resp);
    }
}
