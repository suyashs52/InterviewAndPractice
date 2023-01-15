package com.jav.pattern.decorator;

// class must be closed for modification but open for extension; that is, a new functionality 
//can be added without disturbing existing functionalities. dont change the archtitechture of 
//ground floor but change the newly added floor > house> add additional str> add paint> add floor
public class DrawingBoard {
	public DrawingBoard() {

	}

	public String PicDesc() {
		return "this is a picture of darwing board";
	}

	public static void code() {
		DrawingBoard d1 = new DrawingBoard();
		d1 = new DrawHouse(d1);
		d1 = new DrawTree(d1);
		d1 = new DrawRiver(d1);

		System.out.println(d1.PicDesc());
		// this is a picture of darwing board of a small house with a mango tree and
		// flowing river

	}
}
