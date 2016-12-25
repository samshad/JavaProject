package jungle_1;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import shobdo.ShobdoKori;

public class Stage_1 extends BasicGameState{
	
	private String coor, timer, koytaCoin;
	private Image backg, bandorUp, coin;
	private int t, bandorX, bandorY, koyta;
	private boolean [] cc = new boolean[3];
	
	public Stage_1(int id){}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		gc.setTargetFrameRate(60);
		coor = ""; timer = ""; t = 0; bandorX = 95; bandorY = 350; koyta = 0; koytaCoin = "";
		backg = new Image("RawFiles/Pics/Stage_1/1z.png");
		bandorUp = new Image("RawFiles/Pics/Bandor/Monkeyup.png");
		coin = new Image("RawFiles/Pics/coin.png");
		
		for(int i = 0; i < 3; i++){
			cc[i] = true;
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(backg, 0, 0);
		g.drawString(coor, 720, 12);
		g.drawString(timer, 710, 55);
		g.drawString(koytaCoin, 710, 75);
		g.drawImage(bandorUp, bandorX, bandorY);

		if(cc[0]){
			g.drawImage(coin, 300, 105);
		}
		
		if(cc[1]){
			g.drawImage(coin, 480, 105);
		}
		
		if(cc[2]){
			g.drawImage(coin, 660, 105);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		updatePrints(delta);
		checkForInput(gc, sbg);
		nicheNamai();
		checkBandorPos();
		checkForCoin();
	}

	public int getID(){
		return 2;
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
	
	public void checkBandorPos() throws SlickException{
		if(bandorX == 95){
			if(bandorY <= 183 && bandorY >= 155){
				ShobdoKori.Ah1.play();
			}
		}
	}
	
	public void checkForCoin(){
		if(bandorX >= 275 && bandorX <= 345 && bandorY >= 105 && bandorY <= 140){
			if(cc[0]){
				koyta++;
				cc[0] = false;
			}
		}
		
		if(bandorX >= 455 && bandorX <= 525 && bandorY >= 105 && bandorY <= 140){
			if(cc[1]){
				koyta++;
				cc[1] = false;
			}
		}
		
		if(bandorX >= 635 && bandorX <= 705 && bandorY >= 105 && bandorY <= 140){
			if(cc[2]){
				koyta++;
				cc[2] = false;
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
