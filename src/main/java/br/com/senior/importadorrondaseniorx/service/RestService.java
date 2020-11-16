package br.com.senior.importadorrondaseniorx.service;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.senior.importadorrondaseniorx.dto.LoginDto;
import br.com.senior.importadorrondaseniorx.dto.UserAllPreferencesDto;

@Service
public class RestService {
	private static RestService restService;
	private final RestTemplate restTemplate;
	private final String urlSAM;
	private final String urlSSecure;
	private LoginDto loginDto;
	private UserAllPreferencesDto userPreferencesDto;

	public static synchronized RestService getInstance() {
		if (restService == null)
			restService = new RestService();
		return restService;
	}

    private RestService() {
        restTemplate = new RestTemplateBuilder().build();
        urlSAM = "https://platform.senior.com.br/t/senior.com.br/bridge/1.0";
        urlSSecure = "https://platform.senior.com.br/t/senior.com.br/sam/1.0";
        
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.getMessageConverters().add(converter);
        
	    restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
				if (loginDto != null) {
		    		if ("bearer".equalsIgnoreCase(loginDto.getTokenType())) {
		        		request.getHeaders().setBearerAuth(loginDto.getAccessToken());
		    		} else {
		    			request.getHeaders().set("Authorization", loginDto.getTokenType() + " " + loginDto.getAccessToken());
		    		}
		    	} else {
		    		request.getHeaders().remove("Authorization");
		    	}
				return execution.execute(request, body);
			}
		});
    }
    
    public <T> ResponseEntity<T> postSAM(String url, Object body, Class<T> classValue) {
    	return post(urlSAM + url, body, classValue);
    }
    
    public <T> ResponseEntity<T> postSSecure(String url, Object body, Class<T> classValue) {
    	return post(urlSSecure + url, body, classValue);
    }

	public void postSSecure(String url) {
		post(urlSSecure + url, null, null);
	}
    
    public <T> ResponseEntity<T> getSSecure(String url, Class<T> classValue) {
    	return get(urlSSecure + url, classValue);
    }
    
    private <T> ResponseEntity<T> post(String url, Object body, Class<T> classValue) {
    	HttpEntity<?> request = new HttpEntity<>(body);
        return restTemplate.postForEntity(url, request, classValue);
    }
    
    private <T> ResponseEntity<T> get(String url, Class<T> classValue) {
    	return restTemplate.getForEntity(url, classValue);
    }
    
    protected void setToken(LoginDto loginDto) {
		this.loginDto = loginDto;
	}
    
    public LoginDto getToken() {
    	return loginDto;
    }
    
    protected void setUserPreferences(UserAllPreferencesDto userPreferencesDto) {
		this.userPreferencesDto = userPreferencesDto;
	}
    
    public UserAllPreferencesDto getUserPreferences() {
    	return userPreferencesDto;
    }
    
    public void resetUserPreferences() {
    	userPreferencesDto = null;
    }
    
    public void resetToken() {
    	loginDto = null;
    }
}
