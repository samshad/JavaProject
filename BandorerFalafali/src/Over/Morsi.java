package Over;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import coin.Coin;

public class Morsi extends BasicGameState{
	
	private String coor = "", Score;
	private Image backg;
	
	public Morsi(int id){}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		backg = new Image("RawFiles/Pics/GameOver/Gameover1.png");
		Score = "";
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(backg, 0, 0);
		g.drawString(coor, 720, 12);
		g.drawString(Score, 322, 600 - 316);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		printCoordinate();
		checkForInput(gc, sbg);
	}

	public int getID(){
		return 8;
	}
	
	public void checkForInput(GameContainer gc, StateBasedGame sbg) throws SlickException{
		int x = Mouse.getX();
		int y = Mouse.getY();
		Input in = gc.getInput();

		if(x >= 270 && x <= 547 && y >= 153 && y <= 219){
			if(in.isMousePressed(0)){
				gc.reinit();
				sbg.enterState(0);
			}
		}
	}
	
	public void printCoordinate(){
		int x = Mouse.getX();
		int y = Mouse.getY();
		
		coor = "X: " + x + "\nY: " + (y);
		Score = "Total Score: " + Coin.points;
	}

}
