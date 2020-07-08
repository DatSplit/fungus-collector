package fungus.utility;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;

import java.awt.*;

public class Values {



    public static final int SILVER_SICKLE = 2963;
    public static final int OAK_LOG = 1521;
    public static final int FUNGHI_ON_LOG = 3509;
    public static final int FULL_RING_OF_DUELLING = 2552;
    public static final int PRAYER_POT_4DOSE = 2434;
    public static final int SALVE_GRAVEYARD_TELEPORT = 19619;
    public static final int CLAN_WARS_PORTAL = 26645;
    public static final int CLAN_WARS_PORTAL_EXIT = 26646;

    public static final int[] PRAYER_POT = {2434,139,141,143};
    public static final int[] RING_OF_DUELLING = {2554,2558, 2560, 2562, 2564,2566};


    public static final Area BANK_CANIFIS = new Area(
            new Tile(3509, 3482, 0),
            new Tile(3509, 3474, 0),
            new Tile(3512, 3474, 0),
            new Tile(3514, 3480, 0),
            new Tile(3514, 3482, 0),
            new Tile(3509, 3482, 0)
    );

    public static final Area BANK_CLANWARS = new Area(
            new Tile(3371, 3168, 0),
            new Tile(3367, 3168, 0),
            new Tile(3367, 3173, 0),
            new Tile(3370, 3173, 0)

    );

    public static final Area INSIDE_PORTAL = new Area(
            new Tile(3327,4745,0),
            new Tile(3330,4745,0),
            new Tile(3329,4753,0),
            new Tile(3327,4753,0)
    );


    public static final Area CLAN_WARS = new Area(
            new Tile(3347, 3136, 0),
            new Tile(3396, 3134, 0),
            new Tile(3391, 3180, 0),
            new Tile(3344, 3183, 0),
            new Tile(3347, 3136, 0)

    );

    public static final Area BLOOM_SPOT = new Area(
            new Tile(3452, 3399, 0),
            new Tile(3455, 3399, 0),
            new Tile(3455, 3405, 0),
            new Tile(3451, 3405, 0)


    );
    public static final Tile[] GRAVEYARD_TO_BLOOMSPOT = {
            new Tile(3431, 3461, 0),
            new Tile(3436, 3459, 0),
            new Tile(3443, 3458, 0),
            new Tile(3438, 3454, 0),
            new Tile(3434, 3451, 0),
            new Tile(3431, 3448, 0),
            new Tile(3437, 3445, 0),
            new Tile(3441, 3441, 0),
            new Tile(3443, 3434, 0),
            new Tile(3447, 3432, 0),
            new Tile(3452, 3433, 0),
            new Tile(3456, 3432, 0),
            new Tile(3454, 3428, 0),
            new Tile(3458, 3426, 0),
            new Tile(3460, 3421, 0),
            new Tile(3459, 3416, 0),
            new Tile(3460, 3412, 0),
            new Tile(3460, 3407, 0),
            new Tile(3457, 3404, 0),
            new Tile(3454, 3402, 0),
            new Tile(3452, 3401, 0)
    };

    public static final Tile[] CLAN_WARS_PATH = {
            new Tile(3383, 3161, 0),
            new Tile(3378, 3163, 0),
            new Tile(3372, 3163, 0),
            new Tile(3364, 3162, 0),
            new Tile(3356, 3163, 0),
            new Tile(3352,3163,0)
            };


    public static final Tile[] CLANWARS_TO_BANK = {
            new Tile(3356, 3165, 0),
            new Tile(3363, 3168, 0),
            new Tile(3369, 3169, 0)
    };

    public static final Tile[] TRAVERSE_PATH = {
            new Tile(3511, 3479, 0),
            new Tile(3504, 3482, 0),
            new Tile(3497, 3482, 0),
            new Tile(3489, 3482, 0),
            new Tile(3483, 3478, 0),
            new Tile(3477, 3476, 0),
            new Tile(3470, 3474, 0),
            new Tile(3463, 3473, 0),
            new Tile(3457, 3472, 0),
            new Tile(3454, 3468, 0),
            new Tile(3451, 3465, 0),
            new Tile(3446, 3462, 0),
            new Tile(3444, 3459, 0),
            new Tile(3442, 3455, 0),
            new Tile(3436, 3453, 0),
            new Tile(3432, 3450, 0),
            new Tile(3437, 3445, 0),
            new Tile(3441, 3441, 0),
            new Tile(3442, 3436, 0),
            new Tile(3445, 3432, 0),
            new Tile(3450, 3429, 0),
            new Tile(3455, 3427, 0),
            new Tile(3460, 3423, 0),
            new Tile(3460, 3418, 0),
            new Tile(3459, 3412, 0),
            new Tile(3459, 3407, 0),
            new Tile(3458, 3403, 0),
            new Tile(3455, 3402, 0),
            new Tile(3453, 3400, 0),
            new Tile(3452, 3402, 0)

    };

    public static final Tile MIDDLE_TILE = new Tile(3453, 3402, 0);


}
