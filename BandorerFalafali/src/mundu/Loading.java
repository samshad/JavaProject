package mundu;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import shobdo.ShobdoKori;

public class Loading extends BasicGameState{
	
	private String coor, timer;
	private Image backg, kola, khulaKola;
	private int t, kolax, kolay;
	
	public Loading(int id){
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		gc.setTargetFrameRate(60);
		coor = "";
		timer = "";
		t = 0;
		backg = new Image("RawFiles/Pics/loading.png");
		kola = new Image("RawFiles/Pics/kola.png");
		khulaKola = new Image("RawFiles/Pics/khulaKola.png");
		kolax = 165;
		kolay = 315;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(backg, 0, 0);
		g.drawString(coor, 720, 12);
		g.drawString(timer, 710, 55);
		
		if(kolax < 350){
			g.drawImage(kola, kolax, kolay);
		}
		
		else if(kolax >= 350){
			g.drawImage(khulaKola, kolax, kolay);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		printCoordinate();
		printTime(delta);
		changeKolax();
		checkForInput(gc, sbg);
		
		if(t / 1000 >= 5){
			init(gc, sbg);
			ShobdoKori.music.stop();
			ShobdoKori.inGame.loop();
			sbg.enterState(2);
		}
	}

	public int getID(){
		return 1;
	}
	
	public void checkForInput(GameContainer gc, StateBasedGame sbg) throws SlickException{
		Input in = gc.getInput();
		
		if(in.isKeyPressed(Input.KEY_Z)){
			init(gc, sbg);
			ShobdoKori.music.stop();
			ShobdoKori.inGame.loop();
			sbg.enterState(2);
		}
		
		if(in.isKeyPressed(Input.KEY_ESCAPE)){
			init(gc, sbg);
			sbg.enterState(0);
		}
	}
	
	public void changeKolax(){
		kolax += 3;
		
		if(kolax > 530){
			kolax = 165;
		}
	}
	
	public void printCoordinate(){
		int x = Mouse.getX();
		int y = Mouse.getY();
		
		coor = "X: " + x + "\nY: " + (y);
	}
	
	public void printTime(int delta){
		t += delta;
		timer = "Time: " + (t / 1000);
	}

}
