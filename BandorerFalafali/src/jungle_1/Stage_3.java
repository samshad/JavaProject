package jungle_1;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import shobdo.ShobdoKori;

public class Stage_3 extends BasicGameState{
	
	private String coor, timer;
	private Image backg, bandorUp;
	private int t, bandorX, bandorY;
	private int []xobs;
	private int []yobs;
	
	public Stage_3(int id){}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		gc.setTargetFrameRate(60);
		coor = ""; timer = ""; t = 0; bandorX = 95; bandorY = 350;
		backg = new Image("RawFiles/Pics/Stage_1/3z.png");
		bandorUp = new Image("RawFiles/Pics/Bandor/Monkeyup.png");
		xobs= new int[]{106,103,288,463,650,647,650};
		yobs= new int[]{274,134,376,136,277,504,40};
		
	}
	
	/*106 284
	103 144
	288 386
	463 146 
	650 287
	647 514
	650 58*/

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(backg, 0, 0);
		g.drawString(coor, 720, 12);
		g.drawString(timer, 710, 55);
		g.drawImage(bandorUp, bandorX, bandorY);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		printCoordinate();
		printTime(delta);
		checkForInput(gc, sbg);
		nicheNamai();
		
		if(bandorY<=-10){
			init(gc,sbg);
			sbg.enterState(5);
			
		}
		checkBandorPos(gc,sbg);
	}

	public int getID(){
		return 4;
	}
	
	public void checkForInput(GameContainer gc, StateBasedGame sbg) throws SlickException{
		Input in = gc.getInput();
		
		if(in.isKeyPressed(Input.KEY_ESCAPE)){
			sbg.enterState(0);
		}
		
		if(in.isKeyPressed(Input.KEY_SPACE)){
			bandorY -= 70;
		}
		
		if(in.isKeyPressed(Input.KEY_UP)){
			bandorY -= 70;
		}
		
		if(in.isKeyPressed(Input.KEY_DOWN)){
			bandorY += 70;
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
		int i;
		
		for(i=0;i<xobs.length;i++)
        {
			//System.out.println(xobs[i]+" "+yobs[i]);
          if(bandorX < xobs[i] + 60 && bandorX + 30 > xobs[i] && bandorY < yobs[i] + 30 && 70 + bandorY > yobs[i])
              {
        	  		ShobdoKori.Ah1.play();
        	  		init(gc,sbg);
        			sbg.enterState(6);
        	  }
        }
	}

	public void nicheNamai(){
		bandorY += 1;
		
		if(bandorY >= 600){
			bandorY = 0;
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