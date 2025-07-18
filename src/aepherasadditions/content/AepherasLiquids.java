package aepherasadditions.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class AepherasLiquids {
    public static Liquid
        carbonDioxide,
        steam
            ;

    public static void load(){
        carbonDioxide = new Liquid("carbon-dioxide", Color.valueOf("ff795e")){{
            gas = true;
        }};

        steam = new Liquid("steam", Color.white){{
            gas = true;
        }};
    }
}
