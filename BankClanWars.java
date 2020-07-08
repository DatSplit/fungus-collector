package fungus.tasks;

import fungus.Task;
import fungus.utility.Util;
import fungus.utility.Values;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;

public class BankClanWars extends Task {
    public BankClanWars(ClientContext ctx) {
        super(ctx);
    }

    Util util = new Util(ctx);
    public static boolean accept = false;



    @Override
    public boolean activate() {

        return ctx.inventory.isFull() && util.isInBankAreaClanWars();
    }

    @Override
    public void execute() {

        if(ctx.bank.opened()){
            ctx.bank.depositAllExcept(Values.SILVER_SICKLE, Values.OAK_LOG);
            Condition.wait(()-> !ctx.inventory.isFull(), Random.nextGaussian(380,650,420, 20),10);
            ctx.bank.withdraw(Values.PRAYER_POT_4DOSE,1);
            ctx.bank.withdraw(Values.SALVE_GRAVEYARD_TELEPORT, 1);
            util.checkRingOfDuelling();
            //ctx.bank.close();


        } else if (ctx.bank.inViewport()){
            ctx.bank.open();
            ctx.bank.depositAllExcept(Values.SILVER_SICKLE, Values.OAK_LOG);
            Condition.wait(()-> ctx.bank.opened(),Random.nextGaussian(380,650,420, 20),10);
            ctx.bank.withdraw(Values.PRAYER_POT_4DOSE,1);
            ctx.bank.withdraw(Values.SALVE_GRAVEYARD_TELEPORT, 1);
            util.checkRingOfDuelling();
            //ctx.bank.close();


        } else {
            ctx.camera.turnTo(ctx.bank.nearest());
        }
        //util.randomLogUsage();
    }
}
