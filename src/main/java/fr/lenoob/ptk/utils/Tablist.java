package fr.lenoob.ptk.utils;

import java.lang.reflect.Field;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter; 
public class Tablist { 
public static void sendTablist(Player p, String header, String footer1, String footer2) { 
String h = " " + header + " "; 
String f = footer1 + "\n" + footer2; 
try { setPlayerList(p, h, f); } 
catch (IllegalAccessException|InstantiationException e1) { e1.printStackTrace(); } } 
@SuppressWarnings("rawtypes")
static void setPlayerList(Player p, String h, String f) throws IllegalAccessException, InstantiationException { 
	IChatBaseComponent hj = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + h + "\"}"); IChatBaseComponent fj = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + f + "\"}"); PacketPlayOutPlayerListHeaderFooter packet = buildHeaderFooterPacket(hj, fj); 
	(((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)packet); } 
static PacketPlayOutPlayerListHeaderFooter buildHeaderFooterPacket(Object hj, Object fj) {
	try { Object packet = PacketPlayOutPlayerListHeaderFooter.class.newInstance(); if (hj != null) { 
		Field field = PacketPlayOutPlayerListHeaderFooter.class.getDeclaredField("a"); 
		field.setAccessible(true); 
		field.set(packet, hj); field.setAccessible(false); } if (fj != null) {
		Field field = PacketPlayOutPlayerListHeaderFooter.class.getDeclaredField("b"); 
		field.setAccessible(true); field.set(packet, fj); field.setAccessible(false); }
		return (PacketPlayOutPlayerListHeaderFooter)packet; } 
	catch (NoSuchFieldException|InstantiationException|IllegalAccessException e) { e.printStackTrace(); return null; 
	} 
	} 
}
