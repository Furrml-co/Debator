package com.furrml.debator.config;

import com.corundumstudio.socketio.Configuration;

/**
 * A utility class for server configuration.
 * 
 * @author pcr3w
 */
public class Config {
	
	/**
	 * The port used by the SocketIO server for communications.
	 */
	public static final int SOCKET_IO_PORT = 4242;
	
	/**
	 * The SocketIO server configuration.
	 */
	private static Configuration serverConfig = new Configuration();
	
	private Config() {}
	
	/**
	 * Initiates any configuration values that need to be set.
	 */
	public static void init() {
		serverConfig.setPort(SOCKET_IO_PORT);
	}
	
	/**
	 * @return {@link Config#serverConfig}
	 */
	public static Configuration getServerConfiguration() {
		return serverConfig;
	}
	
}
