package fr.lenoob.ptk.scoreboard;

import static org.bukkit.ChatColor.*;

import org.bukkit.entity.Player;

public class PRE_GAME {

    private ScoreboardManager scoreboardManager;
    public PRE_GAME(ScoreboardManager scoreboardManager) {
        this.scoreboardManager = scoreboardManager;
    
	}	



    public void game(Player player) {
        scoreboardManager.createBoard(player, fastBoard -> {
            fastBoard.updateTitle(DARK_AQUA+""+BOLD+"Protect The King");


            fastBoard.updateLines(
                    WHITE + "",
                    WHITE + ">>━━━━━━━━━━━━━<<",
                    WHITE + "",
                    DARK_AQUA + "En attente ...",
                    WHITE + "",
                    WHITE + ">>━━━━━━━━━━━━━<<",
                    WHITE + ""
            );
        });
    }

}



