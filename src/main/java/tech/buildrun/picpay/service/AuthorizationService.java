package tech.buildrun.picpay.service;

import org.springframework.stereotype.Service;
import tech.buildrun.picpay.client.AutorizationClient;
import tech.buildrun.picpay.dto.TransferDto;
import tech.buildrun.picpay.entity.Transfer;
import tech.buildrun.picpay.exception.PicPayException;

@Service
public class AuthorizationService {

    private final AutorizationClient autorizationClient;

    public AuthorizationService(AutorizationClient autorizationClient) {
        this.autorizationClient = autorizationClient;
    }

    public boolean isAuthorized(TransferDto transfer) {
        var resp = autorizationClient.isAuthorized();

        if (resp.getStatusCode().isError()) {
            throw  new PicPayException();
        }

        return resp.getBody().authorized();
    }
}

