package me.chris.dimpim.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import me.chris.dimpim.DimPim;

public class ChunkLoadListener implements Listener {

    private DimPim main;
    private char[] codes = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public ChunkLoadListener(DimPim main) {
        this.main = main;
    }

    //Call the ChunkLoadEvent so we can play with all the signs in it, har har har\\
    @EventHandler
    public void Chunkload(ChunkLoadEvent e) {
        //Run this task Asynchronously, as to not destroy the very livelihood of the server\\
        //Not.. entirely sure this works.. as intended.. if not, don't blame me entirely, this was reviewed by someone else too\\
        Bukkit.getScheduler().runTaskAsynchronously(main, new Runnable() {

            @Override
            public void run() {
                //Cast the chunk varaible to the loaded chunk in the event\\
                Chunk chunk = e.getChunk();
                //Loop through all the blockstates in the chunk\\
                Random r = new Random();
                //Create a new random for each line, and get its int value\\
                for(BlockState b : chunk.getTileEntities()) {
                    //If the blockstate is an instanceof sign, YOU SHALL PASS\\
                    if(b instanceof Sign) {
                        //Since we know that b is a Sign, we can safely cast it\\
                        Sign sign = (Sign) b;
                        //Same for loop as before lads, loop through all the lines\\
                        for(int a = 0; a < sign.getLines().length; a++) {
                            //Use that int value to color each line a new color, then make the text "dimpim is sexy"\\
                            sign.setLine(a, ChatColor.translateAlternateColorCodes('&', "&" + codes[r.nextInt(15)] + "dimpim is sexy"));
                        }

                    }

                }

            }
        });

    }
}
