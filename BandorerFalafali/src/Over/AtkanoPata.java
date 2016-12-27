package Over;

import shobdo.ShobdoKori;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import mundu.JaDorkar;

public class AtkanoPata extends BasicGameState{
	
	private String coor = "";
	private Image backg, soundb;

	public AtkanoPata(int id){}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		backg = new Image("RawFiles/Pics/paused.png");
		soundb = new Image("RawFiles/Pics/soundb.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(backg, 0, 0);
		g.drawString(coor, 720, 12);
		g.drawImage(soundb, 755, 555);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		printCoordinate();
		checkForInput(gc, sbg);
	}

	public int getID(){
		return 7;
	}
	
	public void checkForInput(GameContainer gc, StateBasedGame sbg){
		int x = Mouse.getX();
		int y = Mouse.getY();
		int r = 58;
		Input in = gc.getInput();
		
		if(Math.sqrt(Math.pow( (316-x), 2) + Math.pow( (280-y), 2) ) < r){
			if(in.isMousePressed(0)){
				sbg.enterState(JaDorkar.state);
			}
		}
		
		else if(Math.sqrt(Math.pow((448-x),2)+Math.pow((278-y),2))<r){
			if(in.isMousePressed(0)){
				JaDorkar.clearKormu = true;
				sbg.enterState(0);
			}
		}
		
		if(x >= 755 && x <= 790 && y >= 10 && y <= 45){
			if(in.isMousePressed(0)){
				if(ShobdoKori.music.playing()){
					ShobdoKori.music.stop();
				}

				else{
					ShobdoKori.music.loop();
				}
			}
		}
	}
	
	public void printCoordinate(){
		int x = Mouse.getX();
		int y = Mouse.getY();
		
		coor = "X: " + x + "\nY: " + (y);
	}

}
