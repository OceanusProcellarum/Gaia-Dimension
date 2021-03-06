package androsa.gaiadimension.proxy;

import androsa.gaiadimension.block.inventory.*;
import androsa.gaiadimension.block.tileentity.*;
import androsa.gaiadimension.entity.*;
import androsa.gaiadimension.entity.boss.GDBlueHowliteWolf;
import androsa.gaiadimension.entity.boss.GDMalachiteGuard;
import androsa.gaiadimension.model.*;
import androsa.gaiadimension.renderer.*;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public GuiContainer getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        GuiID guiID = GuiID.values()[ID];
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity tile = world.getTileEntity(pos);
        Entity entity = world.getEntityByID(x);

        switch (guiID) {
            case AGATE_CRAFT:
                return new GuiAgateCraftingTable(player.inventory, world, pos);
            case SMALL_CRATE:
                return new GuiSmallCrate(player.inventory, (TileEntitySmallCrate) tile);
            case LARGE_CRATE:
                return new GuiLargeCrate(player.inventory, (TileEntityLargeCrate) tile);
            case GAIA_STONE_FURNACE:
                return new GuiGaiaStoneFurnace(player.inventory, (TileEntityGaiaStoneFurnace) tile);
            case GLITTER_FURNACE:
                return new GuiGlitterFurnace(player.inventory, (TileEntityGlitterFurnace) tile);
            case PURIFIER:
                return new GuiPurifier(player.inventory, (TileEntityPurifier) tile);
            default:
                return null;
        }
    }
    @Override
    public void doPreLoadRegistration() {
       // RenderingRegistry.registerEntityRenderingHandler(GDShotGaianEnergy.class, m -> new RenderSnowball<>(m, Items.ENDER_PEARL, Minecraft.getMinecraft().getRenderItem()));

        RenderingRegistry.registerEntityRenderingHandler(GDCommonGrowthSapper.class, m -> new EntityRenderCommonSapper(m, new ModelGrowthSapper(), 0.6F));
        RenderingRegistry.registerEntityRenderingHandler(GDChilledGrowthSapper.class, m -> new EntityRenderChilledSapper(m, new ModelGrowthSapper(), 0.6F));
        RenderingRegistry.registerEntityRenderingHandler(GDNutrientGrowthSapper.class, m -> new EntityRenderNutrientSapper(m, new ModelGrowthSapper(), 0.6F));
        RenderingRegistry.registerEntityRenderingHandler(GDMystifiedGrowthSapper.class, m -> new EntityRenderMystifiedSapper(m, new ModelGrowthSapper(), 0.6F));
        RenderingRegistry.registerEntityRenderingHandler(GDMutantGrowthExtractor.class, m -> new EntityRendererGrowthExtractor(m, new ModelGrowthExtractor(),0.8F));
        RenderingRegistry.registerEntityRenderingHandler(GDHowliteWolf.class, m -> new EntityRenderHowliteWolf(m, new ModelHowliteWolf(), 0.6F));
        RenderingRegistry.registerEntityRenderingHandler(GDSpellElement.class, m -> new EntityRenderSpellElement(m, new ModelSpellElement(), 0.0F));
        RenderingRegistry.registerEntityRenderingHandler(GDRockyLuggeroth.class, m -> new EntityRenderRockyLuggeroth(m, new ModelRockyLuggeroth(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(GDShalurker.class, m -> new EntityRenderShalurker(m, new ModelShalurker(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(GDMuckling.class, m -> new EntityRenderMuckling(m, 0.625F));
        RenderingRegistry.registerEntityRenderingHandler(GDMarkuzarPlant.class, m -> new EntityRenderMarkuzarPlant(m, new ModelMarkuzarPlant(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(GDRuggedLurmorus.class, m -> new EntityRenderRuggedLurmorus(m, new ModelRuggedLurmorus(), 1.2F));
        RenderingRegistry.registerEntityRenderingHandler(GDAgateGolem.class, m -> new EntityRenderAgateGolem(m, new ModelAgateGolem(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(GDAncientLagrahk.class, m -> new EntityRenderAncientLagrahk(m, new ModelAncientLagrahk(), 2.0F));

        RenderingRegistry.registerEntityRenderingHandler(GDBlueHowliteWolf.class, m -> new EntityRenderBlueHowliteWolf(m, new ModelBlueHowliteWolf(), 1.2F));
        RenderingRegistry.registerEntityRenderingHandler(GDMalachiteGuard.class, m -> new EntityRenderMalachiteGuard(m, new ModelMalachiteGuard(), 1.0F));
    }
    @Override
    public void doOnLoadRegistration() {
        ;
    }
    @Override
    public World getClientWorld() {
        return FMLClientHandler.instance().getClient().world;
    }
}
