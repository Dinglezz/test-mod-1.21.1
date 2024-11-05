package net.dinglezz.testmod.datagen;

import net.dinglezz.testmod.block.ModBlocks;
import net.dinglezz.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET,
                ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE);

        offerSmelting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
        offerBlasting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PINK_GARNET, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_PINK_GARNET_BLOCK);

        createTransmutationRecipe(ModBlocks.PINK_GARNET_BUTTON, Ingredient.ofItems(ModItems.PINK_GARNET)).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(recipeExporter);
          createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_PRESSURE_PLATE, Ingredient.ofItems(ModItems.PINK_GARNET)).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(recipeExporter);
          createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, Ingredient.ofItems(ModItems.PINK_GARNET)).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(recipeExporter);
          createTrapdoorRecipe(ModBlocks.PINK_GARNET_TRAPDOOR, Ingredient.ofItems(ModItems.PINK_GARNET)).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(recipeExporter);

          // Normals
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CHISEL)
                .pattern("   ")
                .pattern(" P ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('P', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))// Unlock recipe when pink garnet obtained
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK)
                .pattern("PRP")
                .pattern("RPR")
                .pattern("PRP")
                .input('R', ModBlocks.RAW_PINK_GARNET_BLOCK)
                .input('P', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STARLIGHT_ASHES)
                .pattern(" B ")
                .pattern("BPB")
                .pattern(" B ")
                .input('P', ModItems.PINK_GARNET)
                .input('B', Items.GLOWSTONE)
                .criterion(hasItem(Items.GLOWSTONE), conditionsFromItem(Items.GLOWSTONE))
                .offerTo(recipeExporter);

        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SWORD)
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" S ")
                .input('P', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_PICKAXE)
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .input('P', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_AXE)
                .pattern(" PP")
                .pattern(" SP")
                .pattern(" S ")
                .input('P', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SHOVEL)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" S ")
                .input('P', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HOE)
                .pattern(" PP")
                .pattern(" S ")
                .pattern(" S ")
                .input('P', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
    }
}
