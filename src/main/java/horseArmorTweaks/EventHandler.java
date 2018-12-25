package horseArmorTweaks;

import java.util.UUID;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.IItemHandler;

public class EventHandler {
	
	@CapabilityInject(IItemHandler.class)
	public static Capability<IItemHandler> ITEM=null;
	
	public static final UUID ARMOR_MODIFIER_UUID=UUID.fromString("556E1665-8B10-40C8-8F9D-CF9B1667F295");
	
	public int getArmorProtection(HorseArmorType armor){
		if(armor==HorseArmorType.GOLD)
			return 11;
		if(armor==HorseArmorType.IRON)
			return 15;
		if(armor==HorseArmorType.DIAMOND)
			return 20;
		return 0;
	}
	
	@SubscribeEvent
	public void setArmor(LivingUpdateEvent e){
		if(!e.getEntityLiving().world.isRemote&&e.getEntityLiving() instanceof EntityHorse){
			if(e.getEntityLiving().world.getWorldTime()%20==0){
				IItemHandler horse=((EntityHorse)e.getEntityLiving()).getCapability(ITEM, null);
				HorseArmorType armor=HorseArmorType.getByItemStack(horse.getStackInSlot(1));
				if(armor!=HorseArmorType.NONE){
					int amount=getArmorProtection(armor);
					if(amount>0){
						e.getEntityLiving().getEntityAttribute(SharedMonsterAttributes.ARMOR).removeModifier(ARMOR_MODIFIER_UUID);
						e.getEntityLiving().getEntityAttribute(SharedMonsterAttributes.ARMOR).applyModifier(new AttributeModifier(ARMOR_MODIFIER_UUID, "Horse armor bonus", amount, 0).setSaved(false));
					}
				}
			}
		}
	}
	
}
