package shobdo;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public final class ShobdoKori{
	
	public static Music music;
	
	public ShobdoKori(){}
	
	public static void Splay() throws SlickException{
		music = new Music("RawFiles/Audio/Gold.wav");
		music.loop();
	}
}
