package com.hemebiotech.analytics;

import org.apache.log4j.Logger;

public class Main {

	private static Main instance;

	private static Logger logger;

	/**
	 * Main instance getter
	 * @return instance of main class
	 */
	public static Main getInstance(){
		return instance;
	}

	/**
	 * Logger getter
	 * @return log4j logger
	 */
	public static Logger getLogger(){
		return logger;
	}

	/**
	 * Main entry point
	 * @param args received
	 */
	public static void main(String[] args){
		init();
		new AnalyticsCounter(args).launcher();
	}

	/**
	 * Init base components
	 */
	public static void init(){
		instance = new Main();
		logger = Logger.getLogger("AnalyticsCounter");
	}
}
