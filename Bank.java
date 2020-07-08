package fungus.tasks;

import fungus.Task;
import fungus.utility.Util;
import fungus.utility.Values;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;

public class Bank extends Task {
Util util = new Util(ctx);
public static boolean accept = false;

    public Bank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {

        return ctx.inventory.isFull() && util.isInBankAreaMorytania();
    }

    @Override
    public void execute() {

        if(ctx.bank.opened()){
            ctx.bank.depositAllExcept(Values.SILVER_SICKLE, Values.OAK_LOG);
            Condition.wait(()-> !ctx.inventory.isFull(), Random.nextGaussian(380,650,420, 20),10);
            ctx.bank.withdraw(Values.PRAYER_POT_4DOSE,1);

        } else if (ctx.bank.inViewport()){
            ctx.bank.open();
            ctx.bank.depositAllExcept(Values.SILVER_SICKLE, Values.OAK_LOG);
            Condition.wait(()-> ctx.bank.opened(),Random.nextGaussian(380,650,420, 20),10);
            ctx.bank.withdraw(Values.PRAYER_POT_4DOSE,1);

        } else {
            ctx.camera.turnTo(ctx.bank.nearest());
        }
        util.randomLogUsage();
    }
}

