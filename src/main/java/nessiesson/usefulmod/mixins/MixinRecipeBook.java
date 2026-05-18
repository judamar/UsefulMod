package nessiesson.usefulmod.mixins;

import net.minecraft.client.util.RecipeBookClient;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.RecipeBook;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CraftingManager.class)
public class MixinRecipeBook {

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void onInit(CallbackInfo ci) {
        registerRocketRecipes();
    }

    private static void registerRocketRecipes() {
        // Vuelo 1
        ItemStack rocket1 = new ItemStack(Items.FIREWORKS, 3);
        setFlightDuration(rocket1, 1);
        NonNullList<Ingredient> ing1 = NonNullList.withSize(2, Ingredient.EMPTY);
        ing1.set(0, Ingredient.fromItem(Items.PAPER));
        ing1.set(1, Ingredient.fromItem(Items.GUNPOWDER));
        CraftingManager.register(new ResourceLocation("usefulmod", "rocket_flight_1"),
                new ShapelessRecipes("fireworks", rocket1, ing1));

        // Vuelo 2
        ItemStack rocket2 = new ItemStack(Items.FIREWORKS, 3);
        setFlightDuration(rocket2, 2);
        NonNullList<Ingredient> ing2 = NonNullList.withSize(3, Ingredient.EMPTY);
        ing2.set(0, Ingredient.fromItem(Items.PAPER));
        ing2.set(1, Ingredient.fromItem(Items.GUNPOWDER));
        ing2.set(2, Ingredient.fromItem(Items.GUNPOWDER));
        CraftingManager.register(new ResourceLocation("usefulmod", "rocket_flight_2"),
                new ShapelessRecipes("fireworks", rocket2, ing2));

        // Vuelo 3
        ItemStack rocket3 = new ItemStack(Items.FIREWORKS, 3);
        setFlightDuration(rocket3, 3);
        NonNullList<Ingredient> ing3 = NonNullList.withSize(4, Ingredient.EMPTY);
        ing3.set(0, Ingredient.fromItem(Items.PAPER));
        ing3.set(1, Ingredient.fromItem(Items.GUNPOWDER));
        ing3.set(2, Ingredient.fromItem(Items.GUNPOWDER));
        ing3.set(3, Ingredient.fromItem(Items.GUNPOWDER));
        CraftingManager.register(new ResourceLocation("usefulmod", "rocket_flight_3"),
                new ShapelessRecipes("fireworks", rocket3, ing3));
    }

    private static void setFlightDuration(ItemStack stack, int duration) {
        NBTTagCompound tag = new NBTTagCompound();
        NBTTagCompound fireworksTag = new NBTTagCompound();
        fireworksTag.setByte("Flight", (byte) duration);
        tag.setTag("Fireworks", fireworksTag);
        stack.setTagCompound(tag);
    }
}