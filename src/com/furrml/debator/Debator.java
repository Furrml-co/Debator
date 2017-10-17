package com.furrml.debator;

import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.reflections.Reflections;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.furrml.debator.config.Config;
import com.furrml.debator.network.event.NetworkEventHandler;

/**
 * The main class for Debator, responsible for setting up and running the entire server.
 * 
 * @author pcr3w
 */
public class Debator {
	
	/**
	 * The singleton instance of Debator.
	 */
	private static Debator singleton = new Debator();
	/**
	 * The global logger used by all Debator classes.
	 */
	private static Logger logger = LogManager.getLogger("Debator");
	
	/**
	 * The SocketIO server used for communications.
	 */
	private SocketIOServer server;
	
	private Debator() {
		Config.init();
		
		this.server = new SocketIOServer(Config.getServerConfiguration());
		
		this.loadEventHandlers();
	}
	
	/**
	 * Sets up the handlers for SocketIO message events, using the {@link NetworkEventHandler} annotation to discover handler classes.
	 */
	private void loadEventHandlers() {
		// search in the network event package
		Reflections reflections = new Reflections("com.furrml.debator.network.event");
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(NetworkEventHandler.class);
		
		// check every class annotated with the handler annotation
		for(Class<?> controller : annotated) {
			if(DataListener.class.isAssignableFrom(controller)) {
				NetworkEventHandler anno = controller.getAnnotation(NetworkEventHandler.class);
				
				// try to create a new instance of the discovered class and register it as an event listener
				try {
					DataListener listener = (DataListener) controller.newInstance();
					
					this.server.addEventListener(anno.event(), anno.data(), listener);
				} catch(InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @return {@link Debator#server}
	 */
	public static Debator getDebator() {
		return singleton;
	}
	
	/**
	 * @return {@link Debator#logger}
	 */
	public static Logger getLogger() {
		return logger;
	}
	
}
