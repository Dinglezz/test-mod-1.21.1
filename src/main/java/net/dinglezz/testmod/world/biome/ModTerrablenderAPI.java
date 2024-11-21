package net.dinglezz.testmod.world.biome;

import net.dinglezz.testmod.TestMod;
import net.dinglezz.testmod.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(TestMod.MOD_ID, "overworld"), RegionType.OVERWORLD, 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, TestMod.MOD_ID, ModMaterialRules.makeRules());
    }
}
