package com.bewitchment.common.world.gen.structures;

import com.bewitchment.Bewitchment;
import com.bewitchment.common.world.gen.ModWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class WorldGenStonecircle extends WorldGenerator {
	private int type;
	
	public WorldGenStonecircle(int type) {
		super();
		this.type = type;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		WorldServer worldServer = (WorldServer) worldIn;
		MinecraftServer minecraftServer = worldIn.getMinecraftServer();
		TemplateManager templateManager = worldServer.getStructureTemplateManager();
		Template template = templateManager.getTemplate(minecraftServer, new ResourceLocation(Bewitchment.MODID + ":stonecircle" + type));
		
		if (ModWorldGen.canSpawnHere(template, worldServer, position)) {
			IBlockState iBlockState = worldIn.getBlockState(position);
			worldIn.notifyBlockUpdate(position, iBlockState, iBlockState, 3);
			PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false);
			template.addBlocksToWorld(worldIn, position.add(0, -1, 0), placementsettings);
			return true;
		}
		return false;
	}
}
