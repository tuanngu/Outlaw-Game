package outlaw;

public class Player {
    private String name = "Marvin Catalon";
    private int[] stats = new int[2]; // stats[0] = killed outlaw
    
    public Player() {
    
    }
    
    public int getKilled() {
        // Killed outlaw
        return stats[0];
    }
    
    public String getName() {
        return name;
    }
    
    public void setKilled(int killed) {
        stats[0] = killed;
    }
    
    public void setName(String inname) {
        /** 
         * Register the name the player will use 
         * If the user does not enter the name,
         * then the name is set to 'Jo'
         */
        name = inname;
        if ( inname == null || inname == "" ) {
            name = "Marvin Catalon";
        }
    }
    
    public void printAllStats(Player user) {
        System.out.println("        Player Stats         ");
        System.out.println("-----------------------------");
        System.out.println("  Name: \t" + user.getName());
        System.out.println("Killed: \t" + user.getKilled());
        System.out.println("-----------------------------");
        
    }

    
}