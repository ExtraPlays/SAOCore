package br.com.extraplays.saocore.listeners;

import br.com.extraplays.saocore.SAOCore;
import br.com.extraplays.saocore.data.PlayerData;
import br.com.extraplays.saocore.data.PlayerManager;
import br.com.extraplays.saocore.data.PlayerSkill;
import br.com.extraplays.saocore.events.ExperienceEvent;
import br.com.extraplays.saocore.events.LevelUpEvent;
import br.com.extraplays.saocore.skills.SkillType;
import br.com.extraplays.saocore.utils.ColorUtil;
import br.com.extraplays.saocore.utils.PlayerDataUtil;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.Map;

public class PlayerJoin implements Listener {

    private static final Map<Material, Integer> MATERIALS = new HashMap<Material, Integer>(){{
//        MINING
        put(Material.STONE, 3);
        put(Material.COAL_ORE, 8);
        put(Material.IRON_ORE, 10);
        put(Material.LAPIS_ORE, 10);
        put(Material.REDSTONE_ORE, 10);
        put(Material.GOLD_ORE, 10);
        put(Material.DIAMOND_ORE, 20);


//      WOODCUTTER
        put(Material.ACACIA_LOG, 3);
        put(Material.BIRCH_LOG, 3);
        put(Material.OAK_LOG, 3);
        put(Material.DARK_OAK_LOG, 3);
        put(Material.SPRUCE_LOG, 3);
    }};

    PlayerManager playerManager = SAOCore.getInstance().getPlayerManager();

    @EventHandler
    public void aoEntrar(PlayerJoinEvent e){

        Player player = e.getPlayer();
        if (playerManager.containsPlayer(player.getUniqueId())) return;
        playerManager.addPlayer(
            new PlayerData(
                    player.getUniqueId(),
                    PlayerDataUtil.getDefaultSkills()
            ));
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){

        Block block = e.getBlock();
        Player p = e.getPlayer();

        if (!MATERIALS.containsKey(block.getType())) return;

        PlayerData player = playerManager.getPlayer(p.getUniqueId());

        if (block.getType().name().contains("_ORE")){

            PlayerSkill skill = player.getSkill(SkillType.MINING);

            Bukkit.getPluginManager().callEvent(new ExperienceEvent(
                    player,skill,MATERIALS.get(block.getType())
            ));
        }

        if (block.getType().name().contains("_LOG")){

            PlayerSkill skill = player.getSkill(SkillType.WOODCUTTER);

            Bukkit.getPluginManager().callEvent(new ExperienceEvent(
                    player,skill,MATERIALS.get(block.getType())
            ));

        }

    }

    @EventHandler
    public void onExperienceEvent(ExperienceEvent event){

        PlayerData data = event.getData();
        PlayerSkill skill = event.getSkill();
        SkillType type = skill.getType();
        int exp = event.getExp();

        skill.setXp(skill.getXp() + exp);

        if (skill.getXp() >= 1024) {

            skill.setXp(skill.getXp() - 1024);
            skill.setLevel(skill.getLevel() + 1);

            Bukkit.getPluginManager().callEvent(new LevelUpEvent(data, skill, skill.getLevel()));
        }

        Player p = Bukkit.getPlayer(data.getId());

        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(
                ColorUtil.colored("&f@skill: &7@level &fXP:( &7@xp / &71024 &f)")
                        .replace("@skill", type.getName())
                        .replace("@xp", String.valueOf(skill.getXp()))
                        .replace("@level", String.valueOf(skill.getLevel()))
        ));

    }

    @EventHandler
    public void onLevelUp(LevelUpEvent event){

        PlayerData data = event.getData();
        Player p = Bukkit.getPlayer(data.getId());

        p.sendMessage("Level up " + event.getNewLevel());

    }
}
