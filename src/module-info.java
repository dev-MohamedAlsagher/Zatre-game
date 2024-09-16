module groep68 {
	exports persistentie;
	exports images;
	exports test;
	exports cui;
	exports talen;
	exports gui;
	exports main;
	exports domein;
	exports exceptions;

	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires junit;
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;
	requires javafx.fxml;
	
	opens gui to javafx.graphics, javafx.fxml ;
	
}