package aepherasadditions.content.custom.block;

import mindustry.world.blocks.defense.Wall;

public class ModuleBlock extends Wall {
    public ModuleBlock(String name) {
        super(name);
        this.hasPower = true;
    }
}