package Over;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class SesherPata extends BasicGameState{
	
	private String coor = "";
	private Image backg, menu, again;
	
	public SesherPata(int id){}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		backg = new Image("RawFiles/Pics/GameOver/GameOver.png");
		menu = new Image("RawFiles/Pics/GameOver/mainmenuButtonr.png");
		again = new Image("RawFiles/Pics/GameOver/playagnButtonr.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(backg, 0, 0);
		g.drawString(coor, 720, 12);
		g.drawImage(menu, 258, 360);
		g.drawImage(again, 258, 430);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		printCoordinate();
		checkForInput(gc, sbg);
	}

	public int getID(){
		return 6;
	}
	
	public void checkForInput(GameContainer gc, StateBasedGame sbg){
		int x = Mouse.getX();
		int y = Mouse.getY();
		Input in = gc.getInput();
		
		if(x >= 260 && x <= 536 && y >= 171 && y <= 240){
			if(in.isMousePressed(0)){
				sbg.enterState(0);
			}
		}
		
		if(x >= 260 && x <= 536 && y >= 100 && y <=167){
			if(in.isMousePressed(0)){
				
				sbg.enterState(1);
			}
		}
		
		if(x >= 258 && x <= 438 && y >= 430 && y <= 500){
			if(in.isMousePressed(0)){
				sbg.enterState(2);
			}
		}
	}
	
	public void printCoordinate(){
		int x = Mouse.getX();
		int y = Mouse.getY();
		
		coor = "X: " + x + "\nY: " + (y);
	}

}
