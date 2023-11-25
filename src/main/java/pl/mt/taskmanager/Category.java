package pl.mt.taskmanager;

public enum Category {
    HOME("Domowe"),
    SHOPPING("Zakupy"),
    WORK("Praca"),
    STUDY("Nauka"),
    PETS("Zwierzęta"),
    PAYMENTS("Opłaty");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
