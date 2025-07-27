package aepherasadditions.content.custom.block;

import aepherasadditions.content.ABlocks;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.Constructor;

public class ModuleFactory extends Constructor {
    public int moduleSize = 1;

    public ModuleFactory(String name) {
        super(name);
    }

    @Override
    public boolean canProduce(Block b) {
       if(b.size == this.moduleSize) {
           return b == ABlocks.basicArmorModule
                   || b == ABlocks.basicAssaultModule
                   || b == ABlocks.basicSupportModule
                   || b == ABlocks.basicSpecialtyModule
                   || b == ABlocks.calibratedArmorModule
                   || b == ABlocks.calibratedAssaultModule
                   || b == ABlocks.calibratedSupportModule
                   || b == ABlocks.calibratedSpecialtyModule
                   || b == ABlocks.integratedArmorModule
                   || b == ABlocks.integratedAssaultModule
                   || b == ABlocks.integratedSupportModule
                   || b == ABlocks.integratedSpecialtyModule
                   || b == ABlocks.maximizedArmorModule
                   || b == ABlocks.maximizedAssaultModule
                   || b == ABlocks.maximizedSupportModule
                   || b == ABlocks.maximizedSpecialtyModule;
       }
       else return false;
    }
}
