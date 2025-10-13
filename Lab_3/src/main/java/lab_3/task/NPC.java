package lab_3.task;

public class NPC {
    private String name;
    private int age;
    private String role;
    private int health;
    private boolean isHostile;
    
    public NPC(String name, int age, String role, int health, boolean isHostile) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.health = health;
        this.isHostile = isHostile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isHostile() {
        return isHostile;
    }

    public void setHostile(boolean isHostile) {
        this.isHostile = isHostile;
    }
}
