package nightmare;

import java.util.*;

/// Персонаж игрока
public class Player extends Users {
    // базовые значения свойств в зависимости от класса
    public static final Map<String, List<Integer>> CLASSES = initClasses();
    // базовые значения модификаторов для жизни и выносливости
    public static final Map<String, List<Double>> LIFE = initLife();
    // класс персонажа
    public String clazz;
    // занчения свойств силы, выносливости и так далее
    public int LevelPoints;
    public int Life;
    public int MaxLife;
    public int MaxStamina;
    public int Stamina;
    public List<Integer> Stats;

    private static Map<String, List<Integer>> initClasses() {
        Map<String, List<Integer>> clazzes = new HashMap<String, List<Integer>>();
        clazzes.put("Warrior", Collections.unmodifiableList(Arrays.asList(8, 6, 7, 9, 7, 9, 8)));
        clazzes.put("Paladin", Collections.unmodifiableList(Arrays.asList(9, 5, 8, 11, 5, 6, 2)));
        clazzes.put("Wizard", Collections.unmodifiableList(Arrays.asList(3, 9, 4, 6, 11, 5, 5)));
        clazzes.put("Rouge", Collections.unmodifiableList(Arrays.asList(6, 11, 8, 4, 8, 9, 6)));
        clazzes.put("Barbarian", Collections.unmodifiableList(Arrays.asList(11, 5, 6, 3, 5, 6, 5)));
        return Collections.unmodifiableMap(clazzes);
    }

    private static Map<String, List<Double>> initLife() {
        Map<String, List<Double>> lives = new HashMap<String, List<Double>>();
        lives.put("Warrior", Collections.unmodifiableList(Arrays.asList(1.0, 1.0)));
        lives.put("Paladin", Collections.unmodifiableList(Arrays.asList(1.0, 1.2)));
        lives.put("Wizard", Collections.unmodifiableList(Arrays.asList(0.3, 0.6)));
        lives.put("Rouge", Collections.unmodifiableList(Arrays.asList(0.7, 1.7)));
        lives.put("Barbarian", Collections.unmodifiableList(Arrays.asList(1.5, 0.9)));

        return Collections.unmodifiableMap(lives);
    }

    // Set player class
    public void setClass(String clazz) {
        this.clazz = clazz;
        Stats = CLASSES.get(clazz);

        Life = MaxLife = (int) (100 * LIFE.get(clazz).get(0));
        Stamina = MaxStamina = (int) (100 * LIFE.get(clazz).get(1));
    }
}
