package com.furrml.debator;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;

public class Main {
	
	public static void main(String[] args) {
		LogManager.getRootLogger().setLevel(Level.INFO);
		
		Debator.getDebator();
	}
	
}
