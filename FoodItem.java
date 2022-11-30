public class FoodItem {
    
    private String name;
    private int calories;
    private int protein;
    private int fats;
    private int carbs;
    private int servingSize;

    public FoodItem(String n,int p, int f, int c, int s){
        name = n;
        protein = p;
        fats = f;
        carbs = c;
        servingSize = s;
        calories = calculateCals(p,f,c);
    }

    public void calcCals(){
        calories = ((protein*4) + (fats*9) + (carbs*4));
    }

    public int calculateCals(int p, int f, int c){
        return ((p*4) + (f*9) + (c*4));
    }

    public String getName(){
        return name;
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

    public int getServingSize(){
        return servingSize;
    }

    public void setName(String n){
        name = n;
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
    
    public void setServingSize(int s){
        servingSize = s;
    }
}