package tech.buildrun.picpay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import tech.buildrun.picpay.client.dto.AutorizationResponse;

@FeignClient (
        name = "AutorizationClient", url = "${client.authorization-service.url}"
)
public interface AutorizationClient {

    @GetMapping
    ResponseEntity<AutorizationResponse> isAuthorized();
}
