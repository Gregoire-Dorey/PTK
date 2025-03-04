package fr.lenoob.ptk.commands;

import fr.lenoob.ptk.utils.UtilsMethods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStart implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] strings) {
        UtilsMethods utm = new UtilsMethods();
        if(sender instanceof Player){
            Player player = (Player) sender;
            utm.start(player);
        }
        return false;
    }
}
