package com.hemebiotech.analytics;

public class Main {

	private static Main instance;

	/**
	 * Main instance getter
	 * @return instance of main class
	 */
	public static Main getInstance(){
		return instance;
	}

	/**
	 * Main entry point
	 * @param args received
	 * @throws Exception
	 */
	public static void main(String args[]){
		init();
		new AnalyticsCounter(args).launcher();
	}

	/**
	 * Init base components
	 */
	public static void init(){
		instance = new Main();
	}
}
