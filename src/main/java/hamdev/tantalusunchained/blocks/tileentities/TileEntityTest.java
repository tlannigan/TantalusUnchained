package hamdev.tantalusunchained.blocks.tileentities;

import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityTest extends TileEntity {
    public static TileEntityType<?> TestType;

    public TileEntityTest(){
        super(TestType = TileEntityType.Builder.create(TileEntityTest::new).build(null).setRegistryName(TantalusUnchained.MODID, "block_test"));
    }
}
