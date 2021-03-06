package db;

import java.util.List;

import com.force.api.ApiConfig;
import com.force.api.ApiException;
import com.force.api.ForceApi;

public class SalesforceDAO<T> {
	
	private static final String CLIENTID = "3MVG9ZL0ppGP5UrC9R5pfGadp9_.sezTYM4KyOofpmNB9S0IumaT57vNAI1j0Xbl6fJInNkjvcIDSCKZ9ypMm";
	private static final String CLIENTSECRET = "8568904816664843552";
	private static final String DOMAIN = "https://login.salesforce.com";
	private static final String USERNAME = "devorg@77soft.com";
	private static final String PASSWORD = "77GSIDev1";
	private static final String SECURITY_TOKEN = "Gv0bAID3dNqiUTMvJpVlGDlQ6";
	
	private ApiConfig config;
	private ForceApi api;

	public void connect() {
		config = new ApiConfig();
		
		config.setUsername(USERNAME);
		config.setPassword(PASSWORD+SECURITY_TOKEN);
		config.setClientId(CLIENTID);
		config.setClientSecret(CLIENTSECRET);
		config.setLoginEndpoint(DOMAIN);
		
		api = new ForceApi(config);
	}
	
	public List<T> retrieve(String query, Class<T> objectType) {
		return api.query(query, objectType).getRecords();
	}
	
	public String create(String objectType, Object object) throws ApiException{
		return api.createSObject(objectType, object);
	}

	public String update(String objectType, Object object) {
		return objectType;
	}

	public String delete(String objectType, Object object) {
		return objectType;
	}
}
