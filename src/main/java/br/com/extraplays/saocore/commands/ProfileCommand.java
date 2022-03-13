package br.com.extraplays.saocore.commands;

import br.com.extraplays.saocore.SAOCore;
import br.com.extraplays.saocore.utils.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ProfileCommand implements CommandExecutor {

    private final SAOCore core = SAOCore.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("profile")){

            if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage("Esse comando não pode ser usado do console");
            }

//            Player player = (Player) sender;
//
//            player.sendMessage("");
//            player.sendMessage(ColorUtil.colored("&7Seu perfil:"));
//            player.sendMessage(ColorUtil.colored(" &f➡ Level: &a" + level));
//            player.sendMessage(ColorUtil.colored(" &f➡ XP: (&a" + xp + "&f/&a" + nextLevelXp + "&f)"));
//            player.sendMessage("");
        }

        return false;
    }
}
