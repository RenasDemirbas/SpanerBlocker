package com.example;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.chunk.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnerBlocker extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("SpawnerBlocker aktif!");
    }

    @EventHandler
    public void onChunkPopulate(ChunkPopulateEvent event) {
        Chunk chunk = event.getChunk();
        for (BlockState state : chunk.getTileEntities()) {
            if (state instanceof CreatureSpawner) {
                state.getBlock().setType(Material.AIR);
            }
        }
    }
}
