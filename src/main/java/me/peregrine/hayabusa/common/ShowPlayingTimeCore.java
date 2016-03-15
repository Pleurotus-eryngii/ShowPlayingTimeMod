package me.peregrine.hayabusa.common;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.peregrine.hayabusa.keyhandlers.ShowPlayingTime_ShowTimeKey_Handler;
import net.minecraft.client.settings.KeyBinding;
/*
 * The main class of ShowPlayingTimeMod
 * @author Hayabusa
 * 2016/03/15
 */

@Mod(modid = "ShowPlayingTime", name = "ShowPlayingTime", version = "1.7.10_1.0a")

public class ShowPlayingTimeCore {

	@Instance("ShowPlayingTime")
	public static ShowPlayingTimeCore instance;

	//Cキーが押された時の処理 インスタンス生成
	@SideOnly(Side.CLIENT)
	public static final KeyBinding inputKeyC = new KeyBinding("key.showplayingtime", Keyboard.KEY_C, "key.categories.gameplay");
	public static final KeyBinding inputKeyV = new KeyBinding("key.showplayingtime", Keyboard.KEY_V, "key.categories.gameplay");

	@EventHandler
	public void init(FMLInitializationEvent event) throws IOException
	{
		if (event.getSide() == Side.CLIENT)
	    {
	        ClientRegistry.registerKeyBinding(inputKeyC);
	        ClientRegistry.registerKeyBinding(inputKeyV);
	    }
		ShowPlayingTime_ShowTimeKey_Handler keyinstance_C = new ShowPlayingTime_ShowTimeKey_Handler();
		FMLCommonHandler.instance().bus().register(keyinstance_C);
		//Cキーの処理をさせるクラスに投げる

	}
	public static long startedtime;

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		//postInitで起動時を取得
		//フラグを設置してグローバル変数に投げている
		//この実装は安全なのか…？
		long i = System.currentTimeMillis();
		System.out.println(i);
		startedtime = i;
		System.out.println(startedtime);
	}
	/*public long getStartedtime()
	{
		return this.startedtime;
	}*/

}
