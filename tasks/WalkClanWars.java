package fungus.tasks;

import fungus.Task;
import fungus.utility.Util;
import fungus.utility.Values;
import fungus.utility.Walker;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.*;
//2
public class WalkClanWars extends Task {

    public WalkClanWars(ClientContext ctx) {
        super(ctx);
    }

    Util util = new Util(ctx);
    Walker walker = new Walker(ctx);

    @Override
    public boolean activate() {
        return (ctx.inventory.isFull() && !util.isInBankAreaClanWars() || !ctx.inventory.isFull() && !util.isAtBloomSpot());
    }

    @Override
    public void execute() {
        if(!ctx.inventory.isFull() && (!util.isAtBloomSpot())){

            Item graveyard_teleport = ctx.inventory.select().id(Values.SALVE_GRAVEYARD_TELEPORT).poll();
            graveyard_teleport.interact("Break");

            walker.walkPath(Values.GRAVEYARD_TO_BLOOMSPOT);
            Tile currentTile = ctx.players.local().tile();
            Condition.wait(()-> !ctx.players.local().tile().equals(currentTile),Random.nextGaussian(400,750,550, 30),10);

        } else if(util.checkIfStatsAreDecreased()) {



            util.teleportToClanWars();
            util.checkRunning();
            walker.walkPath(Values.CLAN_WARS_PATH);
            Tile currentTile = ctx.players.local().tile();
            Condition.wait(()-> !ctx.players.local().tile().equals(currentTile), Random.nextGaussian(400,750,550, 30),3);
            GameObject clanWarsPortal = ctx.objects.select().id(Values.CLAN_WARS_PORTAL).poll();
            clanWarsPortal.interact("Enter");
            Condition.wait(()-> ctx.players.local().interacting().valid(), Random.nextInt(450,700),4);
            GameObject clanWarsPortalExit = ctx.objects.select().id(Values.CLAN_WARS_PORTAL_EXIT).poll();
            clanWarsPortalExit.interact("Exit");



        } else if(ctx.skills.realLevel(Constants.SKILLS_HITPOINTS) == ctx.skills.level(Constants.SKILLS_HITPOINTS)
                && (ctx.skills.realLevel(Constants.SKILLS_PRAYER) == ctx.skills.level(Constants.SKILLS_PRAYER))) {

            walker.walkPath(Values.CLANWARS_TO_BANK);
            Tile currentTile = ctx.players.local().tile();
            Condition.wait(() -> !ctx.players.local().tile().equals(currentTile), Random.nextGaussian(400,750,550, 30), 10);
        }


    }
}
