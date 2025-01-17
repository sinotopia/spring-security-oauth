package org.springframework.security.oauth2.provider.implicit;

import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;

import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory implementation of the ImplicitGrantService.
 *
 * @author Amanda Anganes
 */
@SuppressWarnings("deprecation")
public class InMemoryImplicitGrantService implements ImplicitGrantService {

    protected final ConcurrentHashMap<TokenRequest, OAuth2Request> requestStore = new ConcurrentHashMap<TokenRequest, OAuth2Request>();

    @Override
    public void store(OAuth2Request originalRequest, TokenRequest tokenRequest) {
        this.requestStore.put(tokenRequest, originalRequest);
    }

    @Override
    public OAuth2Request remove(TokenRequest tokenRequest) {
        OAuth2Request request = this.requestStore.remove(tokenRequest);
        return request;
    }

}
