package com.bulkbrewing.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Quita el límite de 1 item de los tres huecos de botellas del alambique.
 * El límite real pasa a ser el tamaño máximo de pila del item (16 para las pociones),
 * porque Slot#getMaxStackSize(ItemStack) usa el mínimo entre ambos valores.
 */
@Mixin(targets = "net.minecraft.world.inventory.BrewingStandMenu$PotionSlot")
public abstract class PotionSlotMixin {
	@Inject(method = "getMaxStackSize()I", at = @At("HEAD"), cancellable = true)
	private void bulkbrewing$allowStacks(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(99);
	}
}
