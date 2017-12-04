package uk.ac.ebi.literature.mongodb.dao.impl;

import java.io.IOException;
import java.util.Properties;

import com.mongodb.MongoCredential;

public class ConnectionData {

	private String hostName;
	
	private int port;
	
	private String databaseAuthentication;
	
	private String userName;
	
	private String password;
	
	public ConnectionData(String dbName) throws IOException{
		Properties properties = new Properties();
        properties.load(ConnectionData.class.getResourceAsStream("/mongodb.properties"));
        String url = properties.getProperty("hostName."+dbName);
		this.setHostName(url);
		System.out.println("Connecting to mongoDB " +dbName+ " with the URL: " +url+ ".");
		this.setPort(Integer.parseInt(properties.getProperty("port."+dbName, "0")));
		this.setDatabaseAuthentication(properties.getProperty("databaseAuthentication."+dbName, ""));
		this.setUserName(properties.getProperty("userName."+dbName, ""));
		this.setPassword(properties.getProperty("password."+dbName, ""));
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDatabaseAuthentication() {
		return databaseAuthentication;
	}

	public void setDatabaseAuthentication(String databaseAuthentication) {
		this.databaseAuthentication = databaseAuthentication;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean match(MongoCredential credential){
		boolean ret = (credential.getUserName().equalsIgnoreCase(this.getUserName())) && ((new String (credential.getPassword())).equalsIgnoreCase(this.getPassword())) 
				      && (credential.getSource().equalsIgnoreCase(this.getDatabaseAuthentication()));
		return ret;
	}
	
}
