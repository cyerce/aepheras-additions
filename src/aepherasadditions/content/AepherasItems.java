package aepherasadditions.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.UnitTypes;
import mindustry.type.Item;

public class AepherasItems {
    public static Item
    coalCoke, titansteel, voltalite, nuclearCompound;

    public static final Seq<Item> serpuloItems = new Seq<>(), erekirItems = new Seq<>(), erekirOnlyItems = new Seq<>();

    public static void load(){
        coalCoke = new Item("coal-coke", Color.valueOf("8e9097")){{
            cost = 1f;
            flammability = 0.05f;
        }};

        titansteel = new Item("titansteel", Color.valueOf("919fe7")){{
            cost = 1f;
        }};

        voltalite = new Item("voltalite", Color.valueOf("fcf387")){{
            cost = 1f;
            charge = 0.8f;
        }};

        nuclearCompound = new Item("nuclear-compound", Color.valueOf("f9a3c7")){{
            cost = 1f;
            explosiveness = 5f;
            radioactivity = 3f;
        }};



        serpuloItems.addAll(
                coalCoke, titansteel, voltalite, nuclearCompound
        );
    }

}
