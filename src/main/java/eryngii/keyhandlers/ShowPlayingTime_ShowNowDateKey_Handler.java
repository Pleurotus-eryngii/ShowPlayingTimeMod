package eryngii.keyhandlers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import eryngii.common.ShowPlayingTimeCore;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * @author Hayabusa
 * 2015/03/16
 * 1.8 Updated by Eryngii
 * 2016/5/22
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
			/*
			 * Java8以上でしか動かないもの
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
			*/
			//Java8では化石に近しいとか言われているCalendarに働いてもらって7でも動作させている
			Calendar c = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("現在日時yyyy年MM月dd日hh時mm分");
			
			entP.addChatMessage(new ChatComponentTranslation((sdf.format(c.getTime())) ));

	    }
	}
}