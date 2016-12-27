package jungle_1;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import coin.Coin;
import shobdo.ShobdoKori;

public class Stage_4 extends BasicGameState{
	
	private String coor, timer, koytaCoin;
	private Image backg, bandorUp, coin;
	private int t, bandorX, bandorY, koyta;
	private int []xobs;
	private int []yobs;
	
	public Stage_4(int id){}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		gc.setTargetFrameRate(60);
		coor = ""; timer = ""; t = 0; bandorX = 95; bandorY = 350; koyta = 0; koytaCoin = "";
		backg = new Image("RawFiles/Pics/Stage_1/4z.png");
		bandorUp = new Image("RawFiles/Pics/Bandor/Monkeyup.png");
		
		xobs = new int[]{106,287,289,466,467,647,648,649};
		yobs = new int[]{320,232,525,411,34,250,109,33};
		
		coin = new Image("RawFiles/Pics/Gcoin.png");
		
		for(int i = 0; i < Coin.st4x.length; i++){
			Coin.stb[i] = true;
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(backg, 0, 0);
		g.drawString(coor, 720, 12);
		g.drawString(timer, 710, 55);
		g.drawString(koytaCoin, 710, 75);
		g.drawImage(bandorUp, bandorX, bandorY);
		
		for(int i = 0; i < Coin.st4x.length; i++){
			if(Coin.stb[i]){
				g.drawImage(coin, Coin.st4x[i], Coin.st4y[i]);
			}
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		updatePrints(delta);
		checkForInput(gc, sbg);
		nicheNamai();
		checkBandorPos(gc, sbg);
		checkForCoin();
	}

	public int getID(){
		return 5;
	}
	
	public void checkForInput(GameContainer gc, StateBasedGame sbg) throws SlickException{
		Input in = gc.getInput();
		
		if(in.isKeyPressed(Input.KEY_ESCAPE)){
			sbg.enterState(0);
		}
		
		if(in.isKeyPressed(Input.KEY_SPACE)){
			bandorY -= 70;
		}
		
		if(in.isKeyPressed(Input.KEY_RIGHT)){
			bandorX += 180;
			bandorY -= 50;
			
			if(bandorX > 635){
				bandorX = 95;
			}
		}
		
		if(in.isKeyPressed(Input.KEY_LEFT)){
			bandorX -= 180;
			bandorY -= 50;
			
			if(bandorX < 95){
				bandorX = 635;
			}
		}
	}
	
	public void checkBandorPos(GameContainer gc, StateBasedGame sbg) throws SlickException{
		for(int i=0; i < xobs.length; i++){
			if(bandorX < xobs[i] + 60 && bandorX + 30 > xobs[i] && bandorY < yobs[i] + 30 && 70 + bandorY > yobs[i]){
        	  	ShobdoKori.Ah1.play();
        	  	init(gc,sbg);
        	  	sbg.enterState(6);
			}
        }
		
		if(bandorY < -5){
			init(gc, sbg);
			sbg.enterState(6);
		}
		
		if(bandorY > 510){
			init(gc, sbg);
			sbg.enterState(6);
		}
	}
	
	public void checkForCoin(){
		for(int i = 0; i < Coin.st4x.length; i++){
			if(bandorX < Coin.st4x[i] + 60 && bandorX + 30 > Coin.st4x[i] && bandorY < Coin.st4y[i] + 30 && 70 + bandorY > Coin.st4y[i]){
        	  	if(Coin.stb[i]){
        	  		//ShobdoKori.Ah1.play();
	        	  	Coin.stb[i] = false;
	        	  	koyta++;
        	  	}
			}
		}
	}

	public void nicheNamai(){
		bandorY += 1;
		
		if(bandorY >= 600){
			bandorY = 0;
		}
	}
	
	public void updatePrints(int delta){
		int x = Mouse.getX();
		int y = Mouse.getY();
		
		coor = "X: " + x + "\nY: " + (y);
		
		t += delta;
		timer = "Time: " + (t / 1000);
		
		koytaCoin = "Total: " + koyta;
	}
	
}