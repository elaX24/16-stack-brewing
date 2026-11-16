package com.bulkbrewing;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Items;

public class BulkBrewing implements ModInitializer {
	/** Tamaño máximo de pila de las pociones (normal, arrojadiza y persistente). */
	public static final int POTION_STACK_SIZE = 16;

	@Override
	public void onInitialize() {
		// Hace que los tres tipos de poción apilen a 16. Si ya lo hace otro mod o datapack,
		// puedes borrar este bloque entero y el resto del mod sigue funcionando.
		DefaultItemComponentEvents.MODIFY.register(context -> {
			context.modify(Items.POTION, builder -> builder.set(DataComponents.MAX_STACK_SIZE, POTION_STACK_SIZE));
			context.modify(Items.SPLASH_POTION, builder -> builder.set(DataComponents.MAX_STACK_SIZE, POTION_STACK_SIZE));
			context.modify(Items.LINGERING_POTION, builder -> builder.set(DataComponents.MAX_STACK_SIZE, POTION_STACK_SIZE));
		});
	}
}
