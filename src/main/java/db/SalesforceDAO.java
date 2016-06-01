package db;

import java.util.List;

import com.force.api.ApiConfig;
import com.force.api.ApiException;
import com.force.api.ForceApi;

import model.SalesforceObject;

public class SalesforceDAO<T extends SalesforceObject> {

	private static String clientId = null;
	private static String clientSecret = null;
	private static String domain = null;
	private static String username = null;
	private static String password = null;
	private static String securityToken = null;

	private static ApiConfig config;
	private static ForceApi api;

	public static void setClientID(String theClientID) {
		if (clientId == null) {
			clientId = theClientID;
		}
	}

	public static void setClientSecret(String theClientSecret) {
		if (clientSecret == null) {
			clientSecret = theClientSecret;
		}
	}

	public static void setDomain(String theDomain) {
		if (domain == null) {
			domain = theDomain;
		}
	}

	public static void setUsername(String theUsername) {
		if (username == null) {
			username = theUsername;
		}
	}

	public static void setPassword(String thePassword) {
		if (password == null) {
			password = thePassword;
		}
	}

	public static void setSecurityToken(String theToken) {
		if (securityToken == null) {
			securityToken = theToken;
		}
	}

	protected void connect() {

		if (config == null) {
			config = new ApiConfig();

			config.setUsername(username);
			config.setPassword(password + securityToken);
			config.setClientId(clientId);
			config.setClientSecret(clientSecret);
			config.setLoginEndpoint(domain);
		}

		if (api == null) {
			api = new ForceApi(config);
		}
	}

	protected List<T> retrieve(String query, Class<T> objectType) {
		return api.query(query, objectType).getRecords();
	}

	protected String create(String objectType, T object) throws ApiException {
		return api.createSObject(objectType, object);
	}

	protected void update(String objectType, T sObject) {
		api.updateSObject(objectType, sObject.getId(), sObject);
	}

	protected String delete(String objectType, Object object) {
		return objectType;
	}
}
