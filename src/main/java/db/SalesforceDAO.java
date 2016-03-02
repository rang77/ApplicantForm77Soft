package db;

import java.util.List;

import com.force.api.ApiConfig;
import com.force.api.ApiException;
import com.force.api.ForceApi;

public class SalesforceDAO<T> {
	
	private static final String CLIENTID = "3MVG9PbQtiUzNgN4S79MiP7zmS6BZFASaVsqM23xscv4ZjTH0Mu0dyndwsWFmEmsoKnNgBAKt.xv2srlAjlwF";
	private static final String CLIENTSECRET = "8479639149034290684";
	private static final String DOMAIN = "https://test.salesforce.com";
	private static final String USERNAME = "sfadmin@77soft.com.leave";
	private static final String PASSWORD = "77UltimateLeave";
	private static final String SECURITY_TOKEN = "qTV4gyJXi7Du55xmqZXnQUahX";
	
	private ApiConfig config;
	private ForceApi api;

	protected void connect() {
		config = new ApiConfig();
		
		config.setUsername(USERNAME);
		config.setPassword(PASSWORD+SECURITY_TOKEN);
		config.setClientId(CLIENTID);
		config.setClientSecret(CLIENTSECRET);
		config.setLoginEndpoint(DOMAIN);
		
		api = new ForceApi(config);
	}
	
	protected List<T> retrieve(String query, Class<T> objectType) {
		return api.query(query, objectType).getRecords();
	}
	
	protected String create(String objectType, Object object) throws ApiException{
		return api.createSObject(objectType, object);
	}

	protected String update(String objectType, Object object) {
		return objectType;
	}

	protected String delete(String objectType, Object object) {
		return objectType;
	}
}
