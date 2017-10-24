package me.chris.dimpim.listeners;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChangeListener implements Listener {

    private char[] codes = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    //Call the SignChangeEvent which triggers when you close a sign.\\
    @EventHandler
    public void onSignCreate(SignChangeEvent e) {
        //For each line, create a new random number to color that line, and grab it's integer value that's bound to a max of 9.\\
        Random r = new Random();

        //Loop through all the lines on the sign\\
        for(int a = 0; a < e.getLines().length; a++) {
            //Set the lines sign to that color + "dimpim is sexy".\\
            e.setLine(a, ChatColor.translateAlternateColorCodes('&', "&" + codes[r.nextInt(15)] + "dimpim is sexy"));
        }

    }
}
