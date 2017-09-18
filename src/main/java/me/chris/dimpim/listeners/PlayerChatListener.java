package me.chris.dimpim.listeners;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {


    //Call the AsyncPlayerChatEvent which is fired when a player types into chat.\\
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        //Create a new random for the colorizing, and grab it's int value.\\
        Random r = new Random();
        int num = r.nextInt(9);

        //Override the message with int's color value + "dimpim is sexy".\\
        e.setMessage(ChatColor.translateAlternateColorCodes('&', "&" + num + "dimpim is sexy"));

        //NOTE: quite stupid to do, but the below code is to refresh all signs in the chunk, in a kinda lowkey way, on the text event.\\
        //Makes sure all the signs are the right text.. dont'.. don't ask.\\
        //Also kinda cool because everytime the player chats, the colors on the signs will be randomized again. Kinda cool\\

        //This gets the chunk the player is in\\
        Chunk chunk = e.getPlayer().getLocation().getChunk();

        //Loop through all the blockstates in that chunk\\
        for (BlockState b : chunk.getTileEntities()) {
            //If it's not a sign, fuck off\\
            if(!(b instanceof Sign)) {
                return;
            }

            //This code will be ran if the before if statement is false, meaning that the blockstate is a sign\\
            //Cast the blockstate to a sign, which is safe cause we just checked\\
            Sign sign = (Sign) b;

            //Previous for loop for the SignChangeListener, loop through all the signs lines\\

            for(int a = 0; a < sign.getLines().length; a++) {
                //for each line, we need a new random, and we'll get it's integer\\
                Random r2 = new Random();
                int num2 = r2.nextInt(9);

                //Color the sign accordingly, and set the text to "dimpim is sexy"\\
                sign.setLine(a, ChatColor.translateAlternateColorCodes('&', "&" + num2 + "dimpim is sexy"));
                //MUST BE CALLED TO APPLLY THE CHANGE\\
                //Not used in the SignChangeListener because that event listents for when the sign is placed, and it's already updated after that event anyhow\\
                sign.update();
                //CLOSING TIME MOTHERFUCKER\\
            }
        }
    }

}
