public class FoodItem {
    
    private int calories;
    private int protein;
    private int fats;
    private int carbs;

    public FoodItem(int p, int f, int c){
        protein = p;
        fats = f;
        carbs = c;
        calories = calculateCals(p,f,c);
    }

    public void calcCals(){
        calories = ((protein*4) + (fats*9) + (carbs*4));
    }

    public int calculateCals(int p, int f, int c){
        return ((p*4) + (f*9) + (c*4));
    }

    public int getCalories(){
        return calories;
    }
    
    public int getProtein(){
        return protein;
    }
    
    public int getFats(){
        return fats;
    }
    
    public int getCarbs(){
        return carbs;
    }

    public void setCalories(int cal){
        calories = cal;
    }
    
    public void setProtein(int p){
        protein = p;
    }
    
    public void setFats(int f){
        fats = f;
    }
    
    public void setCarbs(int c){
        carbs = c;
    }
}