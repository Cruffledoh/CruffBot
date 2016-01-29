package com.cruffledoh.tests;

import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class SoundPlayTest {
	
	public static void main(String[] args) {

        playSound("ding.mp3");
	}

    public static void playSound(String filename) {
        try {
            FileInputStream fis = new FileInputStream("sounds/" + filename);
            try {
                Player p = new Player(fis);
                p.play();
            }
            catch (JavaLayerException e) {}
        }
        catch (FileNotFoundException e) {}
    }
}


