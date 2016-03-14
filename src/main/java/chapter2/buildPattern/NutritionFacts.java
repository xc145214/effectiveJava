package chapter2.buildPattern;

/**
 * 重叠构造器模式：不灵活
 * Created by Administrator on 2016/3/8.
 */
public class NutritionFacts {
    private final int servingSize;          //(ml） required
    private final int servings;             //（per container） required
    private final int calories;             //  optional
    private final int fat;                //(g) optional
    private final int sodium;               //(mg) optional
    private final int carbohydrate;         //(g) optionlal

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts(240,8,100,0,56,25);
        System.out.println(cocaCola);
    }
}
