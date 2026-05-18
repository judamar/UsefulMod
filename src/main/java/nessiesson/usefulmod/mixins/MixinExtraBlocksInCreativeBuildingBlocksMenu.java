package nessiesson.usefulmod.mixins;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockGrassPath;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({
        BlockFarmland.class,
        BlockGrassPath.class
})
public abstract class MixinExtraBlocksInCreativeBuildingBlocksMenu extends Block {
    protected MixinExtraBlocksInCreativeBuildingBlocksMenu(Material material) {
        super(material);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}

