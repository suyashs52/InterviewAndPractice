package com.jav.pattern.decorator;

public class DrawTree extends DrawingBoardAdapter {

	DrawingBoard drawingBoard;

	DrawTree(DrawingBoard d) {
		drawingBoard = d;
	}

	@Override
	public String PicDesc() {
		// TODO Auto-generated method stub
		return drawingBoard.PicDesc() + " with a mango tree";
	}

}

class DrawHouse extends DrawingBoardAdapter {

	DrawingBoard drawingBoard;

	DrawHouse(DrawingBoard d) {
		drawingBoard = d;
	}

	@Override
	public String PicDesc() {
		// TODO Auto-generated method stub
		return drawingBoard.PicDesc() + " of a small house";
	}

}

class DrawRiver extends DrawingBoardAdapter {

	DrawingBoard drawingBoard;

	DrawRiver(DrawingBoard d) {
		drawingBoard = d;
	}

	@Override
	public String PicDesc() {
		// TODO Auto-generated method stub
		return drawingBoard.PicDesc() + " and flowing river";
	}

}
