package net.dinglezz.testmod.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        // Order in the court is important! !
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
    }
}
