package com.furrml.debator.network.event;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * The marker annotation for SocketIO message event handler classes within the Debator server.
 * 
 * @author pcr3w
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface NetworkEventHandler {
	
	/**
	 * The message type String of the SocketIO event.
	 */
	public String event();
	
	/**
	 * The class of the expected data object received by the network event handler.
	 */
	public Class data();
	
}
