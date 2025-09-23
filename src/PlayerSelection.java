import java.util.Scanner;

public class PlayerSelection {
    public static void main( String[] args) {

        String name;
        byte age, jerseyNumber;
        double height, weight;

        //Accepting input from the user
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        name = input.nextLine();
        System.out.println("How old are you?");
        age = input.nextByte();
        System.out.println("How tall are you in meters?");
        height = input.nextFloat();
        System.out.println("How much do you weight?");
        weight = input.nextFloat();
        System.out.println("What is your jersey number");
        jerseyNumber = input.nextByte();

        // converting weight to kg and height to centimeters
        final double POUND = 0.45359237;
        final int METER = 100;
        weight = weight * POUND;
        height = height * METER;
        int weightInt = (int) weight;
        int heightInt = (int) height;


        //Checking eligibility of player
        boolean playerEligible = age >= 18 && age < 35 && weightInt < 90;
        String eligibility;
        if (playerEligible)
            eligibility = "Eligible";
        else
            eligibility = "Not Eligible";


        boolean playerProblem = age <= 18 || weightInt >= 90;
        if (playerProblem)
            System.out.println("Player has a problem (either too young or too heavy)");

        //Categorizing players by age
        String category;
        if (age < 20) {
            category = "Rising Star";
        }
        else if (age < 30){
            category = "Prime Player";
        }
        else {
            category = "Veteran";}


        //Using Switch Cases to assign position based on jersey number
        String position;
        switch (jerseyNumber) {
            case 1:
                position = "Goalkeeper";
                break;
            case 2:
            case 5:
                position = "Defender";
                break;
            case 6:
            case 8:
                position = "Midfielder";
                break;
            case 7:
            case 11:
                position = "Winger";
                break;
            case 9:
                position = "Striker";
                break;
            case 10:
                position = "Playmaker";
                break;
            default:
                position = "Player position is unknown";
                break;
        }

        // Select player for starting lineup. Rule: if category is Prime Player and weight < 80,
        // then starting lineup; else bench.
        String lineupDecision;
        if (age > 20) {
            if (age < 30) {
                if (weightInt < 80)
                    lineupDecision = "Player is the starting lineup";
                else
                    lineupDecision = "Player is not in the starting lineup";
            }
            else
                lineupDecision = "Player is not in the starting lineup";
        }
        else
            lineupDecision = "Player is not in the starting lineup";


        boolean attacker = (jerseyNumber == 7 || jerseyNumber == 9 || jerseyNumber == 11 || jerseyNumber == 10);
        String attackerJersey;
        if(attacker)
            attackerJersey = "Yes";
        else
            attackerJersey = "No";


        String status = playerEligible ? "Play" : "Rest";


        System.out.println("Player name : " + name);
        System.out.println("Age : " + age + "(" + category + ")");
        System.out.println("Height : " + heightInt + "cm");
        System.out.println("Weight : " + weightInt + "kg");
        System.out.println("Position : " + position);
        System.out.println("Attacker jersey : " + attackerJersey);
        System.out.println("Eligibility : " + eligibility);
        System.out.println("Lineup Decision : " + lineupDecision);
        System.out.println("Final Decision : " + status);


    }
}


