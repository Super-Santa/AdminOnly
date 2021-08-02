package me.supersanta.adminonly.Commands;

import me.supersanta.adminonly.AdminOnly;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class CommandAo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Plugin plugin = AdminOnly.getPlugin(AdminOnly.class);

            Player player = (Player) sender;

            HashMap<UUID, PermissionAttachment> perms = new HashMap<>();
            PermissionAttachment attachment = player.addAttachment(plugin);
            perms.put(player.getUniqueId(), attachment);

            if (player.hasPermission("adminOnly.use")) {
                if (args.length == 0 && player.hasPermission("adminOnly.see")) {
                    perms.get(player.getUniqueId()).setPermission("adminOnly.see", false);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("VerboseOff"))));
                } else if (args.length == 0 && !player.hasPermission("adminOnly.see")) {
                    perms.get(player.getUniqueId()).setPermission("adminOnly.see", true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("VerboseOn"))));
                } else {
                    StringBuilder message = new StringBuilder();
                    for (int i = 0; i < args.length; i++) {
                        message.append(args[i] + " ");
                    }

                    String staffMessage = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("AOMessage")));
                    staffMessage = staffMessage.replace("%player%", player.getDisplayName());
                    staffMessage = staffMessage.replace("%message%", message);

                    for (Player staff : Bukkit.getOnlinePlayers()) {
                        if (staff.hasPermission("adminOnly.see")) {
                            staff.sendMessage(staffMessage);
                        }
                    }
                }

            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to run this command");
            }
        } else {
            sender.sendMessage("You must be a player to run this command");
        }

        return true;
    }
}
