package com.bulkbrewing.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.BrewingInput;
import net.minecraft.world.item.crafting.BrewingRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * En 26.3 el alambique prepara cada hueco con BrewingRecipe#assemble, que siempre devuelve
 * una sola unidad. Aquí copiamos la cantidad del hueco al resultado, de modo que
 * 16 pociones entran y salen 16 pociones (el ingrediente se gasta una sola vez).
 */
@Mixin(BrewingRecipe.class)
public abstract class BrewingRecipeMixin {
	@Inject(
		method = "assemble(Lnet/minecraft/world/item/crafting/BrewingInput;)Lnet/minecraft/world/item/ItemStack;",
		at = @At("RETURN")
	)
	private void bulkbrewing$keepCount(BrewingInput brew, CallbackInfoReturnable<ItemStack> cir) {
		ItemStack result = cir.getReturnValue();
		int count = brew.input().getCount();
		if (count > 1 && !result.isEmpty()) {
			result.setCount(Math.min(count, 99));
		}
	}
}
