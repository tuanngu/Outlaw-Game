package Character;

import java.util.HashMap;

public class Vice {
    
    public boolean dead;
    public boolean done;
    public int talked;
    Parser parser = new Parser();
    private HashMap<String, String> instructions = new HashMap();
    private HashMap<String, String> answers = new HashMap();
    private String[] command;
    private String[] instruction;
    private String[] answer;
    
    
    public Vice() {
        this.dead = false;
        this.done = false;
        this.talked = 0;
        this.command = new String[]{
            "name", 
            "purpose", 
            "hometown", 
            "why_come",
            "last_night", 
            "check_gun", 
            "why_gun", 
            "bullets"};
        this.instruction = new String[]{
            "name", 
            "purpose", 
            "hometown", 
            "why_come", 
            "last_night", 
            "check_gun", 
            "why_gun",
            "bullets"};
        this.answer = new String[]{
            "Marvin Catalon", 
            "Just sitting and having a drink.", 
            "My hometown is quite far from here, about 160km away from the north.", 
            "I'm on vacation.", 
            "I was wandering around the town, enjoyed the silent of the night. Suddenly, I saw somebody rushing, then I followed them.", 
            "Of course.",
            "I need it. It’s for my job.", 
            "I have used 1. That’s it."};
        
        for (int i = 0; i < this.command.length; i++) {
            instructions.put(this.command[i], this.instruction[i]);
            answers.put(this.command[i], this.answer[i]);
        }
        
    }
    
    public void startVice() {
        if ( this.talked != 0 ) {
            System.out.println("\nYou are back in the tarven.\n");
        }
        
        while (!this.dead && !this.done) {
            if (this.talked == 0) {
                System.out.println("You are in the TARVEN. It's very crowded. There is a man in your suspect list here.");
                System.out.println("You decide to talk with that man and ask him some questions in your question list.\n");
            }
            
            System.out.println(this.instruction[this.talked]);
            // Input and parse input
            String input = this.parser.getInput();
            String parsed = this.parser.parse(input);
            if ( parsed.equals("purpose_1") ) {
                parsed = "purpose";
            }
            if ( parsed.equals("last_night_1") ) {
                parsed = "last_night";
            }
                
            if (parsed.equals("leave")) {
                System.out.println("You've left the tarven.");
                break;
            }
            if (parsed.equals("kill")) {
                this.dead = true;
                System.out.println("You've killed " + this.answer[0] + " . He is a vice Sheriff.");
                break;
            }
            if (parsed.equals(this.command[this.talked])) {
                System.out.println(this.answer[this.talked] + "\n");
                this.talked += 1;
            }
            
            if (this.talked == this.command.length) {
                this.done = true;
            }
        }
        
        while (!this.dead && this.done) {
            System.out.println("It's time to decide whether to kill or not.");
            System.out.println("If you want to kill " + this.answer[0] +
                    ", please type `KILL`. If you want to keep him alive, just `LEAVE` the tarven.");
            String input = this.parser.getInput();
            String parsed = this.parser.parse(input);
            if ( parsed.equals("kill") ) {
                this.dead = true;
                System.out.println("You've killed " + this.answer[0] + " . He is a vice Sheriff.");
            } else if ( parsed.equals("leave") ) {
                System.out.println("You've left the tarven.");
                break;
            }
        }
    }
 
}

