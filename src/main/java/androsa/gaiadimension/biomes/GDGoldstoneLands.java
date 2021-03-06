package androsa.gaiadimension.biomes;

import androsa.gaiadimension.registry.GDBlocks;
import androsa.gaiadimension.world.gen.GDGenCrystalPlants;
import androsa.gaiadimension.world.gen.GDGenGoldstoneCorruptTree;
import androsa.gaiadimension.world.gen.GDGenNoTrees;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class GDGoldstoneLands extends GDBiomeBase {

    private WorldGenTrees GaiaGenCorruptTrees;
    private short[] skyColorRGB = new short[] { 34, 34, 34 };

    public GDGoldstoneLands(BiomeProperties props) {
        super(props);

        GaiaGenCorruptTrees = new GDGenGoldstoneCorruptTree(false);

        topBlock = GDBlocks.corrupt_grass.getDefaultState();
        fillerBlock = GDBlocks.corrupt_soil.getDefaultState();
    }

    @SideOnly(Side.CLIENT)
    public final short[] getSkyRGB() {
        return skyColorRGB;
    }

    //TODO: Generate veins of Corrupt Blocks

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random par1Random) {
        return par1Random.nextInt(5) == 0 ? new GDGenNoTrees() : par1Random.nextInt(4) == 0 ? GaiaGenCorruptTrees : new GDGenNoTrees();
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand) {

        if (rand.nextInt(32) == 0) {
            return new GDGenCrystalPlants(GDBlocks.corrupted_gaia_eye);
        } else if (rand.nextInt(16) == 0) {
            return new GDGenCrystalPlants(GDBlocks.corrupt_varloom);
        } else {
            if (rand.nextInt(2) == 0) {
                return new GDGenCrystalPlants(GDBlocks.crystal_growth_black);
            } else {
                return new GDGenCrystalPlants(GDBlocks.crystal_growth_red);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x160503;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0x160503;
    }
}
