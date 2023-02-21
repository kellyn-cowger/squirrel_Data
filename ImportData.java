import java.io.*;
public class ImportData {
    public Squirrel[] readData(){
        Squirrel[] nycSquirrels = new Squirrel[3023];
        // tries to make a new file and read from it one line at a time
        try {
            File squirrelFile = new File("nyc_squirrelsv6.csv");
            BufferedReader in = new BufferedReader(new FileReader(squirrelFile));
            // skip the first line because it won't make a squirrel (it just says what the columns are)
            in.readLine();
            for (int i = 0; i < nycSquirrels.length; i++){
                String oneSquirrel = in.readLine();
                Squirrel nextSquirrel = parseSquirrel(oneSquirrel);
                // assigns squirrels to an array
                nycSquirrels[i] = nextSquirrel;
                
            }
            in.close();  
        }
        catch (IOException e){
            System.out.println("error: " + e.getMessage());
        }
        return nycSquirrels;
    }

    // takes a single line (one squirrel's worth of data) and seperates it by commas and places each parameter into a String[] array
    // this array makes it easier to record the large amounts of information associated with one squirrel
    public Squirrel parseSquirrel(String oneSquirrel){
        String[] paras = new String[35];
        for (int i = 0; i < 35; i++){
            int comma = oneSquirrel.indexOf(",");
            String data ="";
            if (comma == -1) {
                data = oneSquirrel;
                paras[i] = data;
            }
            else{
                data = oneSquirrel.substring(0, comma);
                paras[i] = data;
                oneSquirrel = oneSquirrel.substring(comma + 1);
            }
        }
        Squirrel newSquirrel = new Squirrel(paras);
        return newSquirrel;
    }
}
