package com.panorama_screenshot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public final class Panorama_screenshot extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Enabled Plugin.");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Disabled Plugin.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("screenshot")) { //親コマンドの判定
            sender.sendMessage("§aパノラマ用にtpの実行を5秒後に開始します。");

            Player p = (Player) sender;

            String pn = p.getName();
            String uuid = p.getUniqueId().toString();

            p.chat("/gamerule sendCommandFeedback false");

            getLogger().info("Player name:" + sender.getName() + "\n" + "UUID:" + uuid);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            p.chat("/tp " + uuid + " ~ ~ ~ 0 0");
            sender.sendMessage("F2ボタンを押してください。");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            p.chat("/tp " + uuid + " ~ ~ ~ 90 0");
            sender.sendMessage("F2ボタンを押してください。");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            p.chat("/tp " + uuid + " ~ ~ ~ 180 0");
            sender.sendMessage("F2ボタンを押してください。");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            p.chat("/tp " + uuid + " ~ ~ ~ 270 0");
            sender.sendMessage("F2ボタンを押してください。");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            p.chat("/tp " + uuid + " ~ ~ ~ 0 -90");
            sender.sendMessage("F2ボタンを押してください。");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            p.chat("/tp " + uuid + " ~ ~ ~ 0 90");
            sender.sendMessage("F2ボタンを押してください。");

            p.chat("/gamerule sendCommandFeedback true");

            sender.sendMessage("§a実行が完了しました。\n" + "保存されたスクリーンショットを922*922にリサイズし、時間が古い順から「panorama_0.png」...「panorama_5.png」として保存してください。");


            //終わり
            //if (args.length == 0) { //サブコマンドの個数が0、つまりサブコマンド無し
            //    sender.sendMessage("§eサブコマンドなし!");
            //} else { //サブコマンドの個数が0以外
            //    sender.sendMessage("§eサブコマンドあり!");
            //    if (args[0].equalsIgnoreCase("hello")) { //サブコマンドが「hello」かどうか
            //        sender.sendMessage("§bHello World!");
            //    } else { //サブコマンドが「hello」以外
            //        sender.sendMessage("§eその他のサブコマンドです");
            //    }
            //}
            return true; //終わり
        }
        return false;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage("プレイヤーがログインしました: " + e.getPlayer().getName());

    }
}
