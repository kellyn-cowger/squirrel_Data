import java.util.Scanner;
public class SquirrelData {
    public SquirrelData() {
        // constructor which runs all of the data methods on squirrels
        ImportData data = new ImportData();
        Squirrel[] nycSquirrels = data.readData();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Search for Squirrels Based On Color Combination (like this: Gray+White)(Colors: Gray, White, Black, Cinnamon):");
        String color = keyboard.nextLine();
        System.out.println(squirrelFromColor(color, nycSquirrels));
        System.out.println("Search for Squirrels Based On Hectacre (like this: 02E, 37B)(Numbers: 01-42, Letters: A-I):");
        String hectacre = keyboard.nextLine();
        System.out.println(squirrelFromHectacre(hectacre, nycSquirrels));
        System.out.println("This census contains the data of 3023 squirrels.");
        System.out.println(percentAction(nycSquirrels));
        System.out.println(howManyAte(nycSquirrels));
        System.out.println(mostSquirrelsIn(nycSquirrels));
        System.out.println("Bonus! Would you like to see some interesting comments about squirrels? (Y/N)");
        String response = keyboard.nextLine();
        if(response.equals("Y")){
            System.out.println("Okay, here they are:\n" + funFacts(nycSquirrels));
        }
        else{
            System.out.println("Okay, have a nice day!");
        }
        keyboard.close();
    }

    // method which allows the user to search for a squirrel by inputting a color
    public String squirrelFromColor(String color, Squirrel[] nycSquirrels){
        String colorSquirrels = "";
        // iterates through the list, looks for a match
        for (int i = 0; i< nycSquirrels.length; i++){
            String myColor = nycSquirrels[i].getFurCombination();
            if (myColor.equals(color)){
                colorSquirrels += "Squirrel " + i + " - " + nycSquirrels[i].getSquirrelID() + "\n";
            }
        }
        // if the string is still empty, there is no match
        if (colorSquirrels.equals("")){
            colorSquirrels = "No squirrels matched this color combination";
        }
        return colorSquirrels;
    }

    // method which allows the user  to search for a squirrel by inputting a hectacre
    public String squirrelFromHectacre(String hectacre, Squirrel[] nycSquirrels){
        String hectacreSquirrels = "";
        // iterates through the list, looks for match
        for (int i = 0; i< nycSquirrels.length; i++){
            String myAcre = nycSquirrels[i].getHectacre();
            if (myAcre.equals(hectacre)){
                hectacreSquirrels += "Squirrel " + i + " - " + nycSquirrels[i].getSquirrelID() + "\n";
            }
        }
        if (hectacreSquirrels.equals("")){
            hectacreSquirrels = "No squirrels found in this hectacre";
        }
        return hectacreSquirrels;
    }

    // method which takes the percentages of how many squirrels did what in regard to humans
    // NOTE: not all squirrels were recording doing any actions, which is why the percentages do not add perfectly
    public String percentAction(Squirrel[] nycSquirrels){
        String percentDidWhat = "";
        int countRun = 0;
        int countStay = 0;
        int countInterest = 0;
        // checks the three categories for each squirrel
        for(int i = 0; i < nycSquirrels.length; i++){
            boolean actionOne = nycSquirrels[i].getDidApproach();
            boolean actionTwo = nycSquirrels[i].getNoReaction();
            boolean actionThree = nycSquirrels[i].getDidRun();
            if (actionOne) {
                countInterest++;
            }
            if (actionTwo) {
                countStay++;
            }
            if (actionThree) {
                countRun++;
            }
        }
        double ran = (countRun / (double) nycSquirrels.length) * 100 + 1;
        double stay = (countStay / (double) nycSquirrels.length) * 100 + 1;
        double interest = (countInterest / (double) nycSquirrels.length) * 100 + 1;
        percentDidWhat = ran + "% of squirrels ran from humans\n" + stay + "% of squirrels were indifferent to humans\n" + interest + "% of squirrels were interested in humans/ran towards them";
        return percentDidWhat;
    }

    // method which checks how many squirrels were recorded as "eating"
    public String howManyAte(Squirrel[] nycSquirrels){
        int ate = 0;
        for (int i = 0; i < nycSquirrels.length; i++) {
            boolean eating = nycSquirrels[i].getWasEating();
            if (eating){
                ate++;
            }
        }
        return ate + " of NYC's " + nycSquirrels.length + " squirrels were recorded as \"eating\"";
    }

    // method which reports which hectacre had the most squirrels and how many that was
   public String mostSquirrelsIn(Squirrel[] nycSquirrels) {
    int [] frequencies = new int[nycSquirrels.length];
    int numFound = 0;
    Squirrel[] duplicate = nycSquirrels;
    // nested loops which make their way through nycSquirrels (duplicate) to count # of times hectacre is repeated
    for (int i = 0; i < nycSquirrels.length; i++) {
        String hectacre = duplicate[i].getHectacre();
        numFound = 1;
        for(int n = i + 1; n < nycSquirrels.length; n++){
        String check = duplicate[n].getHectacre();
            if (hectacre.equals(check)){
                numFound++;
                frequencies[n] = -1;
            }
        }
        if (frequencies[i] != -1){
            frequencies[i] = numFound;
        }
    }
    int greatestRepeats = 0;
    int location = 0;
    int firstRepeats = 0;
    boolean first = true;
    // first records int firstRepeats so we can check at the end if the greatestRepeat variable is changing/all hectacres have the same number of squirrels
    for (int i = 0; i < frequencies.length; i++){
        if (first){
            if(frequencies[i] > greatestRepeats){
                greatestRepeats = frequencies[i];
                firstRepeats = frequencies[i];
                location = i;
                first = false;
            }
        }
        else if (frequencies[i] > greatestRepeats){
            greatestRepeats = frequencies[i];
            location = i;
        }
        }
    // checks that it isn't just reporting the first case, which would indicate that all hectacres have the same # of squirrels
    if (firstRepeats == greatestRepeats){
        return "All hectacres have the same number of squirrels.";
    }
    else {
        String answer = "Hectacre " + nycSquirrels[location].getHectacre() + " had the most squirrels, with " + greatestRepeats + " squirrels in total.";
        return answer;
    }
    }

    // not one of the criteria for the project, but it prints out "interesting" comments on squirrel behavior
    // "interesting" just means "NA" was not entered as the value
    public String funFacts(Squirrel[] nycSquirrels){
        String facts = "";
        // loop to sort out NA comments and record squirrels with interesting comments
        for (int i = 0; i < nycSquirrels.length; i++){
            String fact = nycSquirrels[i].getOtherActivity();
            if(!fact.equals("NA")){
                facts += "Squirrel " + i + " (" + nycSquirrels[i].getSquirrelID() + ") - " + fact + "\n";
            }
        }
        return facts;
    }
}
