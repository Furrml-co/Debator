package com.furrml.debator.network.event;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;

@NetworkEventHandler(event = "demo", data = String.class)
public class DemoEvent implements DataListener<String> {

	@Override
	public void onData(SocketIOClient client, String data, AckRequest ack) throws Exception {
		
	}
	
}
