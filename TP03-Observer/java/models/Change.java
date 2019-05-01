package models;

public class Change {
    private String change;
    private String oldValue;
    private String newValue;

    public Change(String change, String oldValue, String newValue) {
        this.change = change;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @Override
    public String toString() {
        return "Change{" +
                "change='" + change + '\'' +
                ", oldValue='" + oldValue + '\'' +
                ", newValue='" + newValue + '\'' +
                '}';
    }
}
