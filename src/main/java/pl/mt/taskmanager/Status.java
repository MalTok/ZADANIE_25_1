package pl.mt.taskmanager;

public enum Status {
    NEW("Nowe"),
    FINISHED("Zakończone");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
