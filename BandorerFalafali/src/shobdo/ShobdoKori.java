package shobdo;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public final class ShobdoKori{
	
	public static Music music;
	public static Sound Ah1;
	
	public ShobdoKori(){}
	
	public static void Splay() throws SlickException{
		music = new Music("RawFiles/Audio/Gold.wav");
		music.loop();
	}
	
	public static void SAh1() throws SlickException{
		Ah1 = new Sound("RawFiles/Audio/A1.wav");
	}
}
