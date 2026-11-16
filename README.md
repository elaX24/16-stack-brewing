# Bulk Brewing (Fabric, Minecraft 26.3)

Permite poner hasta 16 pociones en cada hueco del alambique y prepararlas todas a la vez.
El ingrediente (polvo de blaze, verruga, etc.) se gasta una sola vez por ciclo.

## Qué hace

1. `PotionSlotMixin`: quita el límite de 1 item de los huecos de botellas.
2. `BrewingRecipeMixin`: el resultado de la receta conserva la cantidad del hueco (16 entran, 16 salen).
3. `BulkBrewing`: hace que poción, poción arrojadiza y poción persistente apilen a 16.
   Si ya lo hace otro mod/datapack, borra ese bloque.

## Compilar

Necesitas **JDK 25**. Gradle 9.6 o superior.

```
gradle wrapper --gradle-version 9.6.0
./gradlew build
```

El `.jar` queda en `build/libs/bulkbrewing-1.0.0.jar` (no uses el `-sources`).

Sin instalar nada: sube la carpeta a un repositorio de GitHub; el workflow de
`.github/workflows/build.yml` compila y deja el `.jar` en la pestaña Actions → artifacts.

## Instalar

En la carpeta `mods` de tu instancia:

- `bulkbrewing-1.0.0.jar`
- Fabric API `0.166.2+26.3` (o más nuevo para 26.3)

Tiene que estar instalado también en el servidor si juegas en multijugador.

## Notas

- No lo pude compilar ni probar aquí (sin red para Gradle); está escrito con los nombres oficiales de Mojang de 26.3.
- Si el juego se cierra al arrancar con un error de Mixin (`InvalidInjectionException`), es que algún nombre de método cambió: copia el log y se ajusta.
