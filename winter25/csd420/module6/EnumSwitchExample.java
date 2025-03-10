enum Level {
    LOW("Low priority"),
    MEDIUM("Medium priority"),
    HIGH("High priority");
    
    private final String description;
    
    Level(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}

public class EnumSwitchExample {
    public static void main(String[] args) {
        Level level = Level.MEDIUM;
        
        switch (level) {
            case LOW:
                System.out.println(level.getDescription());
                break;
            case MEDIUM:
                System.out.println(level.getDescription());
                break;
            case HIGH:
                System.out.println(level.getDescription());
                break;
        }
    }
}