package com.enwash.rutils.blocks;

import java.util.Random;

import com.enwash.rutils.Main;
import com.enwash.rutils.init.MDRLBlocks;
import com.enwash.rutils.init.MDRLItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class Machine extends BlockBase {
	
	public Machine(String name, Material material) {
		super(name, material);
		this.setLightLevel(.3F);
		this.setHardness(8F);
		this.setResistance(10F);
		this.setCreativeTab(Main.tab);
		this.setSoundType(SoundType.METAL);
		this.setBlockUnbreakable();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (playerIn.getHeldItem(hand).getItem() == MDRLItems.REDSTONE_MULTITOOL) {
			refreshMachine(worldIn, pos, state, playerIn);
			if (playerIn.isSneaking()) {
				worldIn.destroyBlock(pos, true);
			}
		}
		return true;
	}
	
	public void refreshMachine(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
	}
	
}
