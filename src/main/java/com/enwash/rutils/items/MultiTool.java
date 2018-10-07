package com.enwash.rutils.items;

import java.util.List;

import com.enwash.rutils.Main;
import com.enwash.rutils.init.MDRLBlocks;
import com.enwash.rutils.init.MDRLItems;
import com.enwash.rutils.util.ICanHazModel;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MultiTool extends ItemBase{
	
	public MultiTool(String name) {
		super(name);
		setCreativeTab(Main.tab);
		setMaxStackSize(1);
		setMaxDamage(250);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(TextFormatting.DARK_PURPLE + "Used to break machines");
		tooltip.add(TextFormatting.DARK_PURPLE + "Shift-right click a machine to break it");
	}
	
	@Override
	public boolean doesSneakBypassUse(ItemStack stack, IBlockAccess world, BlockPos pos, EntityPlayer player) {
		return true;
	}
	
}
