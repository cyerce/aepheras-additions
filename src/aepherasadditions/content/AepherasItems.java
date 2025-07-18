package aepherasadditions.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.Items;
import mindustry.type.Item;

public class AepherasItems {
    public static Item
    coalCoke, titansteel, voltalite, nuclearCompound,
    aluminum, ferrite, sulfur, vanadium, chromium, cobalt, sapphire, steel, stainlessSteel, graphene, carybte
    ;

    public static final Seq<Item> serpuloItemsKey = new Seq<>(), erekirItemsKey = new Seq<>(), cynerisItemsKey = new Seq<>();

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

        aluminum = new Item("aluminum", Color.valueOf("f6d4ca")){{
            cost = 1f;
            hardness = 1;
        }};

        ferrite = new Item("ferrite", Color.valueOf("d8b587")){{
            cost = 1f;
            hardness = 1;
        }};

        sulfur = new Item("sulfur", Color.valueOf("ffee6b")){{
            cost = 0.5f;
            hardness = 2;
            flammability = 1f;
            explosiveness = 0.35f;
            buildable = false;
        }};

        carybte = new Item("carbyte", Color.valueOf("272727")){{
            cost = 0.5f;
            flammability = 1.5f;
            explosiveness = 1f;
            buildable = false;
        }};

        graphene = new Item("graphene", Color.valueOf("95abd9")){{
            cost = 0.85f;
        }};

        vanadium = new Item("vanadium", Color.valueOf("f15454")){{
            cost = 1f;
            hardness = 3;
            buildable = false;
        }};

        chromium = new Item("chromium", Color.valueOf("c2bffb")){{
            cost = 1f;
            hardness = 4;
        }};

        cobalt = new Item("cobalt", Color.valueOf("576ba9")){{
            cost = 1f;
            hardness = 3;
        }};

        steel = new Item("steel", Color.valueOf("73789a")){{
            cost = 0.75f;
        }};

        stainlessSteel = new Item("stainless-steel", Color.valueOf("61615b")){{
            cost = 0.45f;
        }};

        sapphire = new Item("sapphire", Color.valueOf("544deb")){{
            cost = 0.85f;
        }};


        Items.serpuloItems.addAll(
                coalCoke, titansteel, voltalite, nuclearCompound
        );

        serpuloItemsKey.addAll(
                Items.copper, Items.lead, Items.metaglass, Items.graphite, Items.sand, Items.titanium, Items.thorium, Items.scrap, Items.plastanium, Items.phaseFabric, Items.surgeAlloy, Items.sporePod, Items.pyratite, Items.blastCompound, titansteel, voltalite, nuclearCompound
        );

        erekirItemsKey.addAll(
                Items.beryllium, Items.tungsten, Items.oxide, Items.carbide
        );

        cynerisItemsKey.addAll(
                aluminum, ferrite, sulfur, vanadium, chromium, cobalt, sapphire, steel, stainlessSteel, coalCoke, Items.silicon, Items.coal
        );

    }
}
