package fungus;




import fungus.tasks.*;
import fungus.utility.Util;
import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


@Script.Manifest(name="fungus", description="Collects fungus in the Mort Myre swamp")

public class Bloomer extends PollingScript<ClientContext> implements PaintListener, MessageListener {

    public static int mushroomsPicked = 0, mushroomsPerHour = 0;
    public static ArrayList<Task> tasks = new ArrayList<>();
    Util util = new Util(ctx);
    boolean start = false;

    @Override
    public long getRuntime() {
        return super.getRuntime();
    }

    public String formatTime(final long time) {
        final int sec = (int) (time / 1000), h = sec / 3600, m = sec / 60 % 60, s = sec % 60;
        return (h < 10 ? "0" + h : h) + ":" + (m < 10 ? "0" + m : m) + ":"
                + (s < 10 ? "0" + s : s);
    }

    @Override
    public void repaint(Graphics graphics) {
        try {
            InputStream myStream = new BufferedInputStream(new FileInputStream("C:\\Users\\niels\\IdeaProjects\\Fungus\\src\\fungus\\runescape_uf.ttf"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, myStream).deriveFont(24f);

            graphics.setFont(font);
            mushroomsPerHour = (int) (3600000d / getRuntime() * (double) (mushroomsPicked));
            String mushroomsPerHourString = mushroomsPerHour + "";
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0,350,450,150);
            graphics.setColor(Color.WHITE);
            graphics.drawRect(0, 350, 450, 150);
            graphics.drawString("Fungus Collector", 160, 370);
            graphics.setColor(Color.WHITE);
            Font currentFont = graphics.getFont();
            Font newFont = currentFont.deriveFont(18f);
            graphics.setFont(newFont);
            graphics.setColor(Color.GREEN);
            graphics.drawString("Fungus Collected: " + mushroomsPicked, 180, 425);
            graphics.drawString("Fungus per hour: " + mushroomsPerHourString,180,450);
            graphics.setColor(Color.GREEN);
            graphics.setColor(Color.CYAN);
            graphics.drawString("Runtime: " + formatTime(super.getRuntime()),330,370);
            BufferedImage image = ImageIO.read(new File("C:\\Users\\niels\\Downloads\\Mort_myre_fungus_detail(1).png"));
            graphics.drawImage(image,0,350, null);

        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void messaged(MessageEvent messageEvent) {
        String message = messageEvent.text();
        if (message.equals("You pick a mushroom from the log."))
            mushroomsPicked += 1;
    }



    @Override
    public void start() {

        System.out.println("Starting Fungus script");
        JFrame f=new JFrame("Fungus Options");

        JCheckBox check1=new JCheckBox("Use graveyard teleport and ring of duelling");
        JCheckBox check2=new JCheckBox("Walk from Canifis to the swamp and vice versa");
        JButton startButton = new JButton("Start Script");

        check1.setBounds(60,10,300,30);
        check2.setBounds(60,35,300,30);
        startButton.setBounds(130,70,100,30);

        f.add(check1);
        f.add(check2);
        f.add(startButton);

        f.setSize(400,150);
        f.setLayout(null);
        f.setVisible(true);

        check1.addItemListener(event -> tasks.addAll(Arrays.asList( new WalkClanWars(ctx),new BankClanWars(ctx), new Blooming(ctx))));
        check2.addItemListener(event -> tasks.addAll(Arrays.asList( new Walk(ctx),new Bank(ctx), new Blooming(ctx))));

        startButton.addActionListener(e -> {
            start =true;
            f.dispose();
        });

        while(start == false){
            Condition.sleep();
        }
    }

    @Override
    public void poll() {

        for(Task t : tasks){
            if(t.activate()){
                t.execute();
            }

        }
    }
}
