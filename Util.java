package fungus.utility;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.*;

import java.util.concurrent.ThreadLocalRandom;

public class Util {
    private final ClientContext ctx;

    public Util(ClientContext ctx) {

        this.ctx = ctx;
    }

    public boolean isAtBloomSpot() {
        return Values.BLOOM_SPOT.contains(ctx.players.local());
    }

    public boolean noFunghiOnLog() {
        return ctx.objects.select().id(Values.FUNGHI_ON_LOG).viewable().isEmpty();
    }

    public void drinkPrayerPot(Item item) {
        if ((ctx.skills.level(Constants.SKILLS_PRAYER) <= ThreadLocalRandom.current().nextInt(0, (ctx.skills.realLevel(Constants.SKILLS_PRAYER) *(1/4 )) + 7)) ||
                ctx.skills.level(Constants.SKILLS_PRAYER) <= 6)

            item.interact("Drink");
        }

        public boolean isInBankAreaMorytania(){
            return Values.BANK_CANIFIS.contains(ctx.players.local());
        }

        public void moveToCorrectTile(TileMatrix tilematrix){
        if(!ctx.players.local().tile().equals(Values.MIDDLE_TILE))
            tilematrix.interact("Walk here");
        }

        public void checkPrayerPot(){
        if(!ctx.inventory.contains(ctx.inventory.select().id(Values.PRAYER_POT_4DOSE).peek())) {
            ctx.bank.open();
            ctx.bank.withdraw(Values.PRAYER_POT_4DOSE, 1);
        }
        }

    public void randomLogUsage() {
        if ((Random.nextDouble(0.0, 100000.0) / 100000.0) > Random.nextDouble(0.95, 0.99)) {

            Item oakLog = ctx.inventory.select().id(Values.OAK_LOG).poll();
            BasicQuery<GameObject> gameObjects = ctx.objects.select(Random.nextInt(4, 8)).viewable().shuffle();
            GameObject currentObject = ctx.objects.select(gameObjects).poll();
            oakLog.click("use");
            currentObject.click();

            Condition.wait(() -> ctx.players.local().inMotion(), Random.nextGaussian(400,750,550, 30), 3);


    }}
        public void checkRunning(){
            if(!ctx.movement.running()) {
                ctx.widgets.component(160,24).click();
        }
    }


    public boolean isInBankAreaClanWars() {
        return Values.BANK_CLANWARS.contains(ctx.players.local());
    }

    public void checkRingOfDuelling(){
        ctx.bank.close();
        ctx.widgets.widget(164).component(57).click(); //56 is inventory.
        Condition.wait(()->ctx.widgets.widget(164).component(57).visible(), 900, 3);



        if(!ctx.equipment.itemAt(Equipment.Slot.RING).valid()){
            ctx.bank.open();
            ctx.bank.withdraw(Values.FULL_RING_OF_DUELLING,1);
            ctx.bank.close();
            ctx.widgets.widget(164).component(56).click();
            Condition.wait(()->ctx.widgets.widget(164).component(56).visible(), 900, 3);
            ctx.inventory.select().id(Values.FULL_RING_OF_DUELLING).poll().interact("Wear");

        } else {
            ctx.widgets.widget(164).component(56).click();
            Condition.wait(()->ctx.widgets.widget(164).component(56).visible(), 500, 3);
        }



    }

    public void teleportToClanWars(){


        if(!Values.CLAN_WARS.contains(ctx.players.local()) && !Values.INSIDE_PORTAL.contains(ctx.players.local())){

            ctx.widgets.widget(164).component(57).click(); //open equipment tab
            Condition.wait(()->ctx.widgets.widget(164).component(57).visible(), 500, 3);
            ctx.equipment.itemAt(Equipment.Slot.RING).interact("clan wars"); //teleport to clanwars
            ctx.widgets.widget(164).component(56).click();
            Condition.wait(()->ctx.widgets.widget(164).component(56).visible(), 500, 3); //click on inventory
        }
    }

    public boolean checkIfStatsAreDecreased(){
        return (ctx.skills.realLevel(Constants.SKILLS_HITPOINTS) != ctx.skills.level(Constants.SKILLS_HITPOINTS)
                || (ctx.skills.realLevel(Constants.SKILLS_PRAYER) != ctx.skills.level(Constants.SKILLS_PRAYER) || ((
                ctx.skills.realLevel(Constants.SKILLS_HITPOINTS) != ctx.skills.level(Constants.SKILLS_HITPOINTS)
                        && (ctx.skills.realLevel(Constants.SKILLS_PRAYER) != ctx.skills.level(Constants.SKILLS_PRAYER)

                )))));
    }



}

