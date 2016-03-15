package me.peregrine.hayabusa.keyhandlers;

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
	 * 2016/03/15
	 */

public class ShowPlayingTime_ShowTimeKey_Handler {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void inputKey(InputEvent.KeyInputEvent e)
	{

	    if (ShowPlayingTimeCore.inputKeyC.isPressed())
	    {

	    	//System.out.println(ShowPlayingTimeCore.startedtime);
	    	//System.out.println("キーが押されますた");

	    	long nowtime = System.currentTimeMillis();//現在時間を取得
	    	EntityPlayer entP = Minecraft.getMinecraft().thePlayer;//プレイヤーのインスタンス取得
	    	long calculation = (nowtime - ShowPlayingTimeCore.startedtime)/1000L; //現在時間 - 起動時にセットした時間
	    	if(calculation > 60)//60秒以上だった場合(=1分以上)
	    	{
	    		if(calculation > 3600)//3600以上だった場合(=1時間以上)
	    		{
	    			//時間部分と分部分を分けて計算して表示
	    			long hour = calculation/60L;
	    			long min = calculation%60L;

	    			String hourC = String.valueOf(hour);
	    			String minC = String.valueOf(min);

	    			entP.addChatMessage(new ChatComponentTranslation("貴方のプレイ時間は" + hourC + "時間" + minC + "分です"));
	    		}
	    		else //3600未満60以上(=1分以上60分以下)
	    		{
	    			long min = calculation/60L;
	    			long sec = calculation%60L;

	    			String minC = String.valueOf(min);
	    			String secC = String.valueOf(sec);

		    		entP.addChatMessage(new ChatComponentTranslation("貴方のプレイ時間は" + minC + "分" + secC + "秒です"));
	    		}
	    	}
	    	else //60秒未満だった場合
	    	{
	    		//変換してそのまま表示
	    		String chat1 = String.valueOf(calculation);
	    		entP.addChatMessage(new ChatComponentTranslation("貴方のプレイ時間は" +chat1 + "秒です"));

	    	}
	    	/*
	    	 * ToDo
	    	 * ・1時間以上の場合に秒表示を追加
	    	 * ・24時間を超えたら(!)日表示を追加
	    	 */


	    }
	}
}
