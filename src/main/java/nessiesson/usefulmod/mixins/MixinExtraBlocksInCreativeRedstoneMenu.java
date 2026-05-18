package nessiesson.usefulmod.mixins;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({
		BlockBarrier.class,
		BlockCommandBlock.class,
		BlockDragonEgg.class,
		BlockStructure.class,
		BlockStructureVoid.class,
		BlockMobSpawner.class
})
public abstract class MixinExtraBlocksInCreativeRedstoneMenu extends Block {
	protected MixinExtraBlocksInCreativeRedstoneMenu(Material material) {
		super(material);
	}

	@Inject(method = "<init>", at = @At("RETURN"))
	private void onInit(CallbackInfo ci) {
		this.setCreativeTab(CreativeTabs.REDSTONE);
	}
}
