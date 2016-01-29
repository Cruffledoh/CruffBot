package com.cruffledoh;

import java.io.*;
import java.util.Random;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.jibble.pircbot.*;
import org.json.*;
import org.apache.commons.io.*;

public class CruffBot extends PircBot {
    private static String name = "CruffBot";
    private JSONObject soundConfig;

    public CruffBot() {
        this.setName(name);
    }

    public void loadSoundConfig() {
        try {
            File f = new File("config.json");
            FileInputStream fis = new FileInputStream(f);
            String jsonTxt = IOUtils.toString(fis);
            soundConfig = new JSONObject(jsonTxt);
        }
        catch (IOException e) {
            System.out.println("Error reading config file. " + e.getMessage());
        }
    }

    public void onMessage(String channel, String sender,
    					  String login, String hostname, String message) {

        // todo: Impmelement
        //if (message.startsWith("!sb help"))
        //    displaySBHelp();

        // todo: Impmelement
        //else if (message.startsWith("!sb list"))
        //    displaySBList();

        // todo: Impmelement
        //else if (message.startsWith("!sb rand"))
        //    playRandomSound();

        if (message.startsWith("!sb "))
            playSound(message);
    }

    public void onJoin(String channel, String sender, String login, String hostname) {
		//sendMessage(channel, "Hi there!");
	}

    public void playSound(String message) {
        try {
            String[] str = message.split(" ");
            String filename;
            if (soundConfig.getJSONArray("sounds").getJSONObject(0).has(str[1])) {
                filename = soundConfig.getJSONArray("sounds").getJSONObject(0).getString(str[1]);
                FileInputStream fis = new FileInputStream("sounds/" + filename);
                Player p = new Player(fis);
                p.play();
            }
        }
        catch (FileNotFoundException|JavaLayerException ex) {
        }
    }
}