package horseArmorTweaks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=HorseArmorTweaks.MODID, name=HorseArmorTweaks.MODNAME, version=HorseArmorTweaks.VERSION)
public class HorseArmorTweaks {
	
	public static final String MODID="horse_armor_tweaks";
	public static final String MODNAME="Horse Armor Tweaks";
	public static final String VERSION="1.0";
	
	@net.minecraftforge.fml.common.Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e){
		
	}
	@net.minecraftforge.fml.common.Mod.EventHandler
	public void init(FMLInitializationEvent e){
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	@net.minecraftforge.fml.common.Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
	}
	
	
}
