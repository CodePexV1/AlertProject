package org.example.main.alertProject;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Alert implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            if (player.isOp()){
                if (args.length > 0) {
                    String message = String.join(" ", args);
                    for (Player target : Bukkit.getOnlinePlayers()) {
                        target.sendTitle(ChatColor.BOLD + "" + ChatColor.AQUA + "ALERT", ChatColor.RED + message, 30, 70, 30);
                        target.playSound(target.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1.0F, 0.5F);
                        target.getWorld().spawnParticle(Particle.SPELL_WITCH, target.getLocation(), 30, 0.5, 0.5, 0.5, 0.1);
                        target.sendMessage(ChatColor.WHITE + "=============================================");
                        target.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "ALERT");
                        target.sendMessage("");
                        target.sendMessage(ChatColor.RED + message);
                        target.sendMessage(ChatColor.WHITE + "=============================================");
                    }
                }
            }else{
                player.sendMessage(ChatColor.DARK_RED + "You dont have perms to use this command!");

            }
        }
        return false;
    }
}
