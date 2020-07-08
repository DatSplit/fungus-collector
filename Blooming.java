package fungus.tasks;

import fungus.Task;
import fungus.utility.Util;
import fungus.utility.Values;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.TileMatrix;

public class Blooming extends Task {
    Util util = new Util(ctx);

    public Blooming(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return util.isAtBloomSpot() && !ctx.inventory.isFull();
    }

    @Override
    public void execute() {
        if(util.noFunghiOnLog()) {
            final TileMatrix middle_tile = new TileMatrix(ctx, new Tile(3453, 3402, 0));
            Item prayer_pot = ctx.inventory.select().id(Values.PRAYER_POT).poll();
            util.drinkPrayerPot(prayer_pot);
            util.moveToCorrectTile(middle_tile);
            //util.randomLogUsage();

            Condition.wait(() -> ctx.players.local().interacting().valid(), Random.nextGaussian(380,650,420, 20), 1);

            //util.moveToCorrectTile(middle_tile);
            Item silver_sickle = ctx.inventory.select().id(Values.SILVER_SICKLE).poll();
            silver_sickle.interact("Cast Bloom");

            Condition.wait(() -> ctx.players.local().interacting().valid(), Random.nextGaussian(600,900,750, 25), 1);



        } else {
            GameObject fungi = ctx.objects.select().id(Values.FUNGHI_ON_LOG).nearest().poll();
            fungi.interact("Pick");

            Condition.wait(() -> ctx.players.local().interacting().valid(), Random.nextGaussian(380,650,420, 20), 1);
        }




    }
}
