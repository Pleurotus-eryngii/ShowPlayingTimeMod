package me.peregrine.hayabusa.keyhandlers;

import java.time.LocalDateTime;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.peregrine.hayabusa.common.ShowPlayingTimeCore;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;

/*
 * @author Hayabusa
 * 2015/03/16
 * 特定のキーを押すことで現在日時を表示する機能
 */

public class ShowPlayingTime_ShowNowDateKey_Handler {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void inputKey(InputEvent.KeyInputEvent e)
	{
		if (ShowPlayingTimeCore.inputKeyV.isPressed())
	    {
			//System.out.println("Vキー押された");
			EntityPlayer entP = Minecraft.getMinecraft().thePlayer;
			//Instant ins = Instant.now();
			LocalDateTime nowdate = LocalDateTime.now();
			entP.addChatMessage(new ChatComponentTranslation("現在日時:" + nowdate.getYear() + "年" + nowdate.getMonthValue() + "月" + nowdate.getDayOfMonth() + "日"
					+ nowdate.getHour() + "時" + nowdate.getMinute() + "分" ));

	    }
	}
}
