public class Squirrel {
    private double longitude; // 0
    private double latitude; // 1
    private String squirrelID; // 
    private String hectacre;
    private String shift;
    private int date;
    private int numberInHectacre;
    private String age;
    private String primaryFur;
    private String highlightFur;
    private String furCombination; // 10
    private String colorNotes;
    private String location;
    private String distanceAboveGround;
    private String locationComments;
    private boolean wasRunning;
    private boolean wasChasing;
    private boolean wasClimbing;
    private boolean wasEating;
    private boolean wasForaging;
    private String otherActivity; // 20
    private boolean madeKuks;
    private boolean madeQuaas;
    private boolean madeMoans;
    private boolean tailFlags;
    private boolean tailTwitches;
    private boolean didApproach;
    private boolean noReaction;
    private boolean didRun;
    private String otherInteraction;
    private String longLatCombine; // 30
    private int communityDistrict;
    private int boroughBoundary;
    private int cityCouncilDistrict;
    private int policePrecinct;

    public Squirrel(){
        longitude = 0.0;
        latitude = 0.0;
        squirrelID = "00-ST-00-00";
        hectacre = "00";
        shift = "Shift Time";
        date = 00000000;
        numberInHectacre = 0;
        age = "Squirrel Age";
        primaryFur = "Squirrel Primary";
        highlightFur = "Squirrel Secondary";
        furCombination = "Squirrel Primary+Squirrel Secondary";
        colorNotes = "Color Notes";
        location = "Squirrel Location";
        distanceAboveGround = "Squirrel Elevation";
        locationComments = "Location Notes";
        wasRunning = false;
        wasChasing = false;
        wasClimbing = false;
        wasEating = false;
        wasForaging = false;
        otherActivity = "Activity Notes";
        madeKuks = false;
        madeQuaas = false;
        madeMoans = false;
        tailFlags = false;
        tailTwitches = false;
        didApproach = false;
        noReaction = false;
        didRun = false;
        otherInteraction = "Interaction Notes";
        longLatCombine = "POINT (0.0, 0.0)";
        communityDistrict = 0;
        boroughBoundary = 0;
        cityCouncilDistrict = 0;
        policePrecinct = 0;
    }
    // uses a string array to "package" all of the different parameters to make them easier to process
    public Squirrel(String[] paras){
        longitude = Double.parseDouble(paras[0]);
        latitude = Double.parseDouble(paras[1]);
        squirrelID = paras[2];
        hectacre = paras[3];
        shift = paras[4];
        date = Integer.parseInt(paras[5]);
        numberInHectacre = Integer.parseInt(paras[6]);
        age = paras[7];
        primaryFur = paras[8];
        highlightFur = paras[9];
        furCombination = paras[10];
        colorNotes = paras[11];
        location = paras[12];
        distanceAboveGround = paras[13];
        locationComments = paras[14];
        wasRunning = Boolean.parseBoolean(paras[15]);
        wasChasing = Boolean.parseBoolean(paras[16]);
        wasClimbing = Boolean.parseBoolean(paras[17]);
        wasEating = Boolean.parseBoolean(paras[18]);
        wasForaging = Boolean.parseBoolean(paras[19]);
        otherActivity = paras[20];
        madeKuks = Boolean.parseBoolean(paras[21]);
        madeQuaas = Boolean.parseBoolean(paras[22]);
        madeMoans = Boolean.parseBoolean(paras[23]);
        tailFlags = Boolean.parseBoolean(paras[24]);
        tailTwitches = Boolean.parseBoolean(paras[25]);
        didApproach = Boolean.parseBoolean(paras[26]);
        noReaction = Boolean.parseBoolean(paras[27]);
        didRun = Boolean.parseBoolean(paras[28]);
        otherInteraction = paras[29];
        longLatCombine = paras[30];
        communityDistrict = Integer.parseInt(paras[31]);
        boroughBoundary = Integer.parseInt(paras[32]);
        cityCouncilDistrict = Integer.parseInt(paras[33]);
        policePrecinct = Integer.parseInt(paras[34]);
    }

    public void setSquirrelID(String squirrelID){
        this.squirrelID = squirrelID;
    }

    public String getSquirrelID(){
        return squirrelID;
    }

    public void setHectacre(String hectacre){
        this.hectacre = hectacre;
    }

    public String getHectacre(){
        return hectacre;
    }

    public void setfurCombination(String primaryFur){
        this.primaryFur = primaryFur;
    }

    public String getFurCombination(){
        return furCombination;
    }

    public void setwasRunning(Boolean wasRunning){
        this.wasRunning = wasRunning;
    }

    public boolean getWasRunning(){
        return wasRunning;
    }

    public void setwasChasing(Boolean wasChasing){
        this.wasChasing = wasChasing;
    }

    public boolean getWasChasing(){
        return wasChasing;
    }

    public void setwasClimbing(Boolean wasClimbing){
        this.wasClimbing = wasClimbing;
    }

    public boolean getWasClimbing(){
        return wasClimbing;
    }

    public void setwasEating(Boolean wasEating){
        this.wasEating = wasEating;
    }

    public boolean getWasEating(){
        return wasEating;
    }

    public void setwasForaging(Boolean wasForaging){
        this.wasForaging = wasForaging;
    }

    public boolean getWasForaging(){
        return wasForaging;
    }

    public void setotherActivity(String otherActivity) {
        this.otherActivity = otherActivity;
    }

    public String getOtherActivity(){
        return otherActivity;
    }

    public void setDidAppoach(Boolean didApproach){
        this.didApproach = didApproach;
    }

    public boolean getDidApproach(){
        return didApproach;
    }

    public void setNoReaction(Boolean noReaction){
        this.noReaction = noReaction;
    }

    public boolean getNoReaction(){
        return noReaction;
    }

    public void setDidRun(Boolean didRun){
        this.didRun = didRun;
    }

    public boolean getDidRun(){
        return didRun;
    }


    public String toString() {
        String mySquirrel = "Squirrel " + squirrelID + " was found at " + longLatCombine + " on " + date;
        return mySquirrel;
    }
}