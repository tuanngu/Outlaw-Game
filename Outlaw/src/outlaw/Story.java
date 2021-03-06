package outlaw;

import Character.Vice;
import Character.Suzy;
import Character.Billy;
import Character.Dorin;
import java.util.HashMap;

public class Story {
    
    private boolean dead;
    private boolean done;
    private int killed;
    HashMap<String, String> mapOutlaw = new HashMap();
    
    public Story(Player user) {
        this.killed = 0;
        this.dead = false;
        this.done = false;
        
        Map map = new Map();
        Vice vice = new Vice();
        Suzy suzy = new Suzy();
        Billy billy = new Billy();
        Dorin dorin = new Dorin();
        mapOutlaw();
        
        System.out.println("West End, in a small peaceful and wealthy town, there is a brace Sheriff whose name is " + user.getName() + ".");
        System.out.println("\nOne night, a robbery happened in the mansion of Kalle Blome, the richest man in the town. "
                + "\nA robber attack Mr. Blome by gun but he hasn’t died. "
                + "\nAccording to the Blomes, there were 3 of them and they take all the cash and some jewelry in the mansion. "
                + "\nThe mission of the Sheriff begins, he must find out that 3 gangsters and kill them to make sure his people still live in peace.   \n" 
                + "\nHe begins to inspect the 4 people who move to the town recently. "
                + "\nHe didn’t know that in 1 of 4 people, there is a vice Sheriff from another town. "
                + "\nThe vice is tracking the Gangster Band and he also want to kill them. "
                + "\nHowever, for his safety, he has to hide his role.");
        Delay(5000);
        System.out.println("\nYou will play as the Sheriff. "
                + "\nYour role is to walk around the town, find out 3 outlaws. "
                + "\nYou should think about questions and ask 4 guys to make them reveal themselves. "
                + "\nTwo command you should remember are KILL and LEAVE. If you think the suspect you are talking to is an outlaw, use KILL command. "
                + "You can leave the place you entered by using LEAVE."
                + "\nLet start! ");
        Delay(1000);
        
        while( !this.dead && !this.done ) {
            String location = map.mapMenu();
            Conversation(location, vice, suzy, billy, dorin);
        }
        
        if ( this.dead ) {
            System.out.println("You lose.");
        }
        
        if ( this.done ) {
            System.out.println("You win. Congrats!");
        }
        
    }
    
    public void Conversation(String location, Vice vice, Suzy suzy, Billy billy, Dorin dorin) {
        boolean leave = false;
        String character = mapOutlaw.get(location);
        
        while(!leave) {
            if ( character != null && character.equals("Vice") ) {
               vice.startVice();
               if ( vice.dead ) {
                   this.dead = true;
               }
               leave = true;
            } else if ( character != null && character.equals("Suzy") ) {
                suzy.startSuzy();
                if ( suzy.dead ) {
                    this.killed += 1;
                }
                leave = true;
            } else if ( character != null && character.equals("Billy") ) {
                billy.startBilly();
                if ( billy.dead ) {
                    this.killed += 1;
                }
                leave = true;
            } else if ( character != null && character.equals("Dorin") ) {
                dorin.startDorin();
                if ( dorin.dead ) {
                    this.killed += 1;
                }
                if ( dorin.escaped ) {
                    this.dead = true;
                }
                leave = true;
            } else {
                if ( location.equals("street") ) {
                    System.out.println("You are on the street.");
                } else {
                    System.out.println("There isn't any suspect in " + location + ".");
                }
                
                leave = true;
            } 
        }
        
        if ( this.killed == 3 ) {
            this.done = true;
        }
    }
    
    private void mapOutlaw(){
        mapOutlaw.put("The Tavern", "Vice");
        mapOutlaw.put("Motel", "Suzy");
        mapOutlaw.put("Market Square", "Billy");
        mapOutlaw.put("South Habour", "Dorin");
    }
    
    private void Delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            System.out.print(ex);
        }
    }
    
}
