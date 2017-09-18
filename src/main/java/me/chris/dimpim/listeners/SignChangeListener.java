package me.chris.dimpim.listeners;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChangeListener implements Listener {


    //Call the SignChangeEvent which triggers when you close a sign.\\
    @EventHandler
    public void onSignCreate(SignChangeEvent e) {
        //Loop through all the lines on the sign\\
        for(int a = 0; a < e.getLines().length; a++) {
            //For each line, create a new random number to color that line, and grab it's integer value that's bound to a max of 9.\\
            Random r = new Random();
            int num = r.nextInt(9);
            //Set the lines sign to that color + "dimpim is sexy".\\
            e.setLine(a, ChatColor.translateAlternateColorCodes('&', "&" + num + "dimpim is sexy"));
        }

    }
}
