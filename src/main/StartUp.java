package main;

import cui.MenuApp;
import domein.DomeinController;


public class StartUp {
	

	
	public static void main(String[] args) {
		DomeinController dc = new DomeinController();
		MenuApp menu = new MenuApp(dc);
		menu.start();
		;

	}
}