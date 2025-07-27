package aepherasadditions.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class ALiquids {
    public static Liquid
        carbonDioxide,
        steam,
        argon
            ;

    public static void load(){
        carbonDioxide = new Liquid("carbon-dioxide", Color.valueOf("ff795e")){{
            gas = true;
        }};

        steam = new Liquid("steam", Color.white){{
            gas = true;
        }};

        argon = new Liquid("argon", Color.valueOf("bf92f9")){{
            gas = true;
        }};
    }
}
