package aepherasadditions;

import aepherasadditions.content.AepherasBlocks;
import aepherasadditions.content.AepherasItems;
import aepherasadditions.content.AepherasUnitTypes;
import arc.*;
import arc.func.Prov;
import arc.struct.Seq;
import arc.util.*;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.ui.dialogs.*;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.blocks.units.UnitFactory;

public class AepherasAdditions extends Mod{

    public AepherasAdditions(){
        Log.info("Loaded AepherasAdditions constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("aepherasadditions-frog")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        Log.info("Loading some example content.");
        AepherasItems.load();
        AepherasUnitTypes.load();
        AepherasBlocks.load();

        ((UnitFactory)Blocks.groundFactory).plans.add(
                new UnitFactory.UnitPlan(
                        AepherasUnitTypes.atta,
                        60f * 15f,
                        ItemStack.with(Items.silicon, 50, Items.lead, 30, Items.titanium, 30)
                )
        );

        Seq<UnitType[]> additiveUpgrades = ((Reconstructor)Blocks.additiveReconstructor).upgrades;
        additiveUpgrades = additiveUpgrades.copy();
        additiveUpgrades.add(new UnitType[]{AepherasUnitTypes.atta, AepherasUnitTypes.lasius});
        ((Reconstructor)Blocks.additiveReconstructor).upgrades = additiveUpgrades;

        Seq<UnitType[]> multiplicativeUpgrades = ((Reconstructor)Blocks.multiplicativeReconstructor).upgrades;
        multiplicativeUpgrades = multiplicativeUpgrades.copy();
        multiplicativeUpgrades.add(new UnitType[]{AepherasUnitTypes.lasius, AepherasUnitTypes.formica});
        ((Reconstructor)Blocks.multiplicativeReconstructor).upgrades = multiplicativeUpgrades;

        Seq<UnitType[]> exponentialUpgrades = ((Reconstructor)Blocks.exponentialReconstructor).upgrades;
        exponentialUpgrades = exponentialUpgrades.copy();
        exponentialUpgrades.add(new UnitType[]{AepherasUnitTypes.formica, AepherasUnitTypes.eciton});
        ((Reconstructor)Blocks.exponentialReconstructor).upgrades = exponentialUpgrades;

        Seq<UnitType[]> tetrativeUpgrades = ((Reconstructor)Blocks.tetrativeReconstructor).upgrades;
        tetrativeUpgrades = tetrativeUpgrades.copy();
        tetrativeUpgrades.add(new UnitType[]{AepherasUnitTypes.eciton, AepherasUnitTypes.myrmex});
        ((Reconstructor)Blocks.tetrativeReconstructor).upgrades = tetrativeUpgrades;
    }

}
