package br.com.extraplays.saocore.commands;

import br.com.extraplays.saocore.SAOCore;
import br.com.extraplays.saocore.teleport.TeleportManager;

public class CoreCommands {

    SAOCore core = SAOCore.getInstance();
    TeleportManager teleportManager = core.getTeleportManager();

//    public void TeleportCommand(Context<Player> context, String name){
//
//        val player = context.getSender();
//
//        if (name != null){
//            if (teleportManager.isTeleportArea(player)){
//
//                Teleport teleport = teleportManager.getTeleport(name);
//
//                if (teleport != null) {
//
//                    if (profileManager.getLevel(player.getUniqueId()) >= teleport.getRequiredLevel()){
//
//                        player.sendMessage("Você foi até " + name);
//                        player.teleport(teleport.getLocation());
//
//                    }else {
//                        player.sendMessage("Você precisa ser nivel " + teleport.getRequiredLevel() + " para entrar nessa cidade");
//                    }
//                }
//
//            }else {
//                player.sendMessage("Você precisa estar em uma plataforma de teletransporte.");
//            }
//        }
//
//    }
//
//    @Command(
//            name = "sao.set",
//            async = true,
//            target = CommandTarget.PLAYER
//    )
//    public void setTeleport(Context<Player> context, String name, String level){
//
//        val player = context.getSender();
//
//        if (name != null) {
//
//            int lvl = Integer.parseInt(level);
//
//            Teleport teleport = teleportManager.newTeleport(name, lvl, player.getLocation());
//
//            player.sendMessage("Novo teleporte nivel: " + teleport.getRequiredLevel());
//
//        }
//
//    }

}
