package WorkoutFB;

public class Day {

    private String dayOfWeek;
    private String goals;
    private int weight;
    private String[] workOuts;
    private String workoutType;

    public Day(String dayOfWeek, String goals, int weight, String workoutType) {
        this.dayOfWeek = dayOfWeek;
        this.goals = goals;
        this.weight = weight;
        this.workoutType = workoutType;
    }

    public String getDay() {
        return this.dayOfWeek;
    }

    public String getGoals() {
        return this.goals;
    }

    public int getWeight(){
        return this.weight;
    }

    public String[] getWorkOuts(){
        return this.workOuts;
    }

    public String getWorkoutType() {
        return this.workoutType;
    }

    public void createWorkouts() {

        String benchNums = "";
        String squatNums = "";
        String rowsNums = "";
        String sitUpsNums = "";
        String inclineBenchNums = "";
        String ropePullDownsNums = "";
        String pectoralFliesNums = "";
        String skullCrushersNums = "";
        String latPullDownsNums = "";
        String bicepCurlsNums = "";
        String pullUpsNums = "";
        String hammerCurlsNums = "";
        String hackSquatNums = "";
        String hamstringCurlsNums= "";
        String RDLNums = "";
        String calfRaisesNums = "";
        
        double loseWeightBigWorkouts = getWeight()*.75;
        double maintainWeightBigWorkouts = getWeight();
        double gainWeightBigWorkouts = getWeight()*1.25;
        
        double loseWeightSmallWorkouts = getWeight()*.15;
        double maintainWeightSmallWorkouts = getWeight()*.2;
        double gainWeightSmallWorkouts = getWeight()*.25;

        
        switch(getGoals()){
            case "Lose":
                benchNums = "set: 10x3, Weight: " + loseWeightBigWorkouts;
                squatNums = "set: 12x3, Weight: " + loseWeightBigWorkouts;
                rowsNums = "set: 10x3, Weight: " + loseWeightBigWorkouts;
                sitUpsNums = "20x3, Weight: " + maintainWeightBigWorkouts;
                inclineBenchNums = "set: 10x3, Weight: " + loseWeightBigWorkouts;
                ropePullDownsNums = "set: 15x3, Weight: " + loseWeightSmallWorkouts;
                pectoralFliesNums = "set: 12x3, Weight: " + loseWeightSmallWorkouts;
                skullCrushersNums = "set: 12x3, Weight: " + loseWeightSmallWorkouts;
                latPullDownsNums = "set: 10x3, Weight: " + loseWeightBigWorkouts;
                bicepCurlsNums = "set: 15x3, Weight: " + loseWeightSmallWorkouts;
                pullUpsNums = "set: AMRAPx2, Weight: " + maintainWeightBigWorkouts;
                hammerCurlsNums = "set: 15x3, Weight: " + loseWeightSmallWorkouts;
                hackSquatNums = "set: 12x3, Weight: " + loseWeightBigWorkouts;
                hamstringCurlsNums= "set: 15x3, Weight: " + loseWeightSmallWorkouts;
                RDLNums = "set: 12x3, Weight: " + loseWeightBigWorkouts;
                calfRaisesNums = "set: 20x4, Weight: " + loseWeightBigWorkouts;
                break;
            case "Maintain":
                benchNums = "set: 8x4, Weight: " + maintainWeightBigWorkouts;
                squatNums = "set: 8x4, Weight: " + maintainWeightBigWorkouts;
                rowsNums = "set: 8x4, Weight: " + maintainWeightSmallWorkouts;
                sitUpsNums = "25x3, Weight: " + maintainWeightBigWorkouts;
                inclineBenchNums = "set: 8x4, Weight: " + maintainWeightBigWorkouts;
                ropePullDownsNums = "set: 12x3, Weight: " + maintainWeightSmallWorkouts;
                pectoralFliesNums = "set: 10x3, Weight: " + maintainWeightSmallWorkouts;
                skullCrushersNums = "set: 10x3, Weight: " + maintainWeightSmallWorkouts;
                latPullDownsNums = "set: 8x4, Weight: " + maintainWeightBigWorkouts;
                bicepCurlsNums = "set: 12x3, Weight: " + maintainWeightSmallWorkouts;
                pullUpsNums = "set: AMRAPx3, Weight: " + maintainWeightBigWorkouts;
                hammerCurlsNums = "set: 12x3, Weight: " + maintainWeightSmallWorkouts;
                hackSquatNums = "set: 10x3, Weight: " + maintainWeightBigWorkouts;
                hamstringCurlsNums= "set: 12x4, Weight: " + maintainWeightSmallWorkouts;
                RDLNums = "set: 10x4, Weight: " + maintainWeightBigWorkouts;
                calfRaisesNums = "set: 25x4, Weight: "  + maintainWeightBigWorkouts;
                break;
            case "Gain":
                benchNums = "set: 10x3, Weight: " + gainWeightBigWorkouts;
                squatNums = "set: 12x3, Weight: " + gainWeightBigWorkouts;
                rowsNums = "set: 10x3, Weight: " + gainWeightBigWorkouts;
                sitUpsNums = "30x3, Weight: " + gainWeightSmallWorkouts;
                inclineBenchNums = "set: 10x3, Weight: " + gainWeightBigWorkouts;
                ropePullDownsNums = "set: 15x3, Weight: " + gainWeightSmallWorkouts;
                pectoralFliesNums = "set: 12x3, Weight: " + gainWeightSmallWorkouts;
                skullCrushersNums = "set: 12x3, Weight: " + gainWeightSmallWorkouts;
                latPullDownsNums = "set: 10x3, Weight: " + gainWeightBigWorkouts;
                bicepCurlsNums = "set: 15x3, Weight: " + gainWeightSmallWorkouts;
                pullUpsNums = "set: AMRAPx4, Weight: " + gainWeightSmallWorkouts;
                hammerCurlsNums = "set: 15x3, Weight: " + gainWeightSmallWorkouts;
                hackSquatNums = "set: 12x3, Weight: " + gainWeightBigWorkouts;
                hamstringCurlsNums= "set: 15x3, Weight: " + gainWeightBigWorkouts;
                RDLNums = "set: 12x3, Weight: " + gainWeightBigWorkouts;
                calfRaisesNums = "set: 30x4, Weight: "+ gainWeightBigWorkouts;
                break;
        }        

        switch (this.workoutType) {
            case "Full Body":
                String[] tempWorkOuts = { "Bench " + benchNums, "Squat " + squatNums, "BicepCurls " + bicepCurlsNums, "Rows " + rowsNums, "SitUps " + sitUpsNums };
                workOuts = tempWorkOuts;
                break;
            case "Push":
                String[] tempPushWorkOuts = { "Bench " + benchNums, "InclineBench " + inclineBenchNums, "RopePullDowns " + ropePullDownsNums, "PectoralFlies " + pectoralFliesNums, "SkullCrushers " + skullCrushersNums };
                workOuts = tempPushWorkOuts;
                break;
            case "Pull":
                String[] tempPullWorkOuts = { "Rows " + rowsNums, "LatPullDowns " + latPullDownsNums, "BicepCurls " + bicepCurlsNums, "PullUps " + pullUpsNums, "HammerCurls " + hammerCurlsNums };
                workOuts = tempPullWorkOuts;
                break;
            case "Legs":
                String[] tempLegsWorkOuts = { "Squat " + squatNums, "Hacksquat " + hackSquatNums, "Hamstring Curls " + hamstringCurlsNums, "RDLs " + RDLNums, "Calf Raises " + calfRaisesNums };
                workOuts = tempLegsWorkOuts;
                break;

        }

    }
}
