package me.supersanta.adminonly.Listeners;

import me.supersanta.adminonly.AdminOnly;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class JoinLeaveListener implements Listener {

    Plugin plugin = AdminOnly.getPlugin(AdminOnly.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String joinMessage = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("JoinMessage")));
        joinMessage = joinMessage.replace("%player%", player.getDisplayName());

        if (player.hasPermission("adminOnly.joinLeave") && plugin.getConfig().getBoolean("JoinLeaveMessages")) {
            for (Player staff : Bukkit.getOnlinePlayers()) {
                if (staff.hasPermission("adminOnly.see")) {
                    staff.sendMessage(joinMessage);
                }
            }
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        String leaveMessage = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("LeaveMessage")));
        leaveMessage = leaveMessage.replace("%player%", player.getDisplayName());

        if (player.hasPermission("adminOnly.joinLeave") && plugin.getConfig().getBoolean("JoinLeaveMessages")) {
            for (Player staff : Bukkit.getOnlinePlayers()) {
                if (staff.hasPermission("adminOnly.see")) {
                    staff.sendMessage(leaveMessage);
                }
            }
        }
    }
}
