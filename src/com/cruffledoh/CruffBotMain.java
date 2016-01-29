package com.cruffledoh;

import com.cruffledoh.secure.TInfo;

public class CruffBotMain {

    public static void main(String[] args) throws Exception {
        
        // Create our bot instance
        CruffBot bot = new CruffBot();

        // Load sound configuration
        bot.loadSoundConfig();

        // Enable debugging output.
        bot.setVerbose(false);
        
        // Connect to the Twitch IRC server.
        bot.connect("irc.twitch.tv", 6667, TInfo.pwd);

		// Join the channel you wish to join.
        bot.joinChannel("#cruffledoh");
    }

}