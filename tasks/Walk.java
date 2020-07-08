package fungus.tasks;

import fungus.Task;
import fungus.utility.Util;
import fungus.utility.Values;
import fungus.utility.Walker;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
//3
public class Walk extends Task {
    Util util = new Util(ctx);
    Walker walker = new Walker(ctx);


    public Walk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (ctx.inventory.isFull() && !util.isInBankAreaMorytania() || !ctx.inventory.isFull() && !util.isAtBloomSpot());
    }

    @Override
    public void execute() {
        if(!ctx.inventory.isFull() && (!util.isAtBloomSpot())){

            walker.walkPath(Values.TRAVERSE_PATH);
            Tile currentTile = ctx.players.local().tile();
            Condition.wait(()-> !ctx.players.local().tile().equals(currentTile),Random.nextGaussian(400,750,550, 30),10);

        } else {
            walker.walkPathReverse(Values.TRAVERSE_PATH);
            Tile currentTile = ctx.players.local().tile();
            Condition.wait(()-> !ctx.players.local().tile().equals(currentTile),Random.nextGaussian(400,750,550, 30),10);
        }
        util.randomLogUsage();

    }
}
