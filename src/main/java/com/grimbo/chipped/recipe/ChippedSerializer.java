package com.grimbo.chipped.recipe;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ChippedSerializer {

	//Add new IRecipeTypes here
	public static final IRecipeType<ChippedRecipe> BOTANIST_WORKBENCH_TYPE = IRecipeType.register("botanist_workbench");
	public static final IRecipeType<ChippedRecipe> GLASSBLOWER_TYPE = IRecipeType.register("glassblower");
	public static final IRecipeType<ChippedRecipe> CARPENTERS_TABLE_TYPE = IRecipeType.register("carpenters_table");
	public static final IRecipeType<ChippedRecipe> LOOM_TABLE_TYPE = IRecipeType.register("loom_table");
	public static final IRecipeType<ChippedRecipe> MASON_TABLE_TYPE = IRecipeType.register("mason_table");
	
	//Add new IRecipeSerializers here
	public static final DeferredRegister<IRecipeSerializer<?>> SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Chipped.MOD_ID);
	
	public static final RegistryObject<IRecipeSerializer<?>> BOTANIST_WORKBENCH = SERIALIZER.register("botanist_workbench",
			() -> new ChippedRecipe.Serializer(0, ChippedSerializer.BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH.get()));

	public static final RegistryObject<IRecipeSerializer<?>> GLASSBLOWER = SERIALIZER.register("glassblower",
			() -> new ChippedRecipe.Serializer(1, ChippedSerializer.GLASSBLOWER_TYPE, ChippedBlocks.GLASSBLOWER.get()));

	public static final RegistryObject<IRecipeSerializer<?>> CARPENTERS_TABLE = SERIALIZER.register("carpenters_table",
			() -> new ChippedRecipe.Serializer(2, ChippedSerializer.CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE.get()));

	public static final RegistryObject<IRecipeSerializer<?>> LOOM_TABLE = SERIALIZER.register("loom_table",
			() -> new ChippedRecipe.Serializer(3, ChippedSerializer.LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE.get()));

	public static final RegistryObject<IRecipeSerializer<?>> MASON_TABLE = SERIALIZER.register("mason_table",
			() -> new ChippedRecipe.Serializer(4, ChippedSerializer.MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE.get()));



}