package aepherasadditions.content;

import arc.graphics.Color;
import arc.math.Mathf;
import mindustry.content.StatusEffects;
import mindustry.type.StatusEffect;

public class AEffects {
    public static StatusEffect
    irradiated,
    meltingAcid
    ;

    public static void load(){
        irradiated = new StatusEffect("irradiated"){{
            color = Color.valueOf("ffbdd4");
            effect = AFx.irradiated;
            healthMultiplier = 0.75f;
            speedMultiplier = 0.75f;
            reloadMultiplier = 4/3f;
            buildSpeedMultiplier = 0.75f;
            transitionDamage = 24f;
            effectChance = 0.75f;
            applyColor = Color.valueOf("ffbdd4");
            affinity(StatusEffects.wet, (unit, result, time) -> {
                unit.damagePierce(transitionDamage);
                AFx.irradiated.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
                result.set(irradiated, Math.min(time + result.time, 300f));
            });
        }};

        meltingAcid = new StatusEffect("melting-acid"){{
            color = Color.valueOf("ffee6b");
            speedMultiplier = 0.8f;
            healthMultiplier = 0.8f;
            damage = 0.3f;
            effect = AFx.meltingAcid;

            init(() -> {
                opposite(StatusEffects.wet, StatusEffects.freezing);
            });
        }};
    }
}
