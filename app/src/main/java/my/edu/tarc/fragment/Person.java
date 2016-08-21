package my.edu.tarc.fragment;

public class Person {
    String personName;

    String personDsg;
    boolean selected;
    Person(String name, String dsg) {
        this.personName = name;

        this.personDsg = dsg;
    }
    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public String getPersonDsg() {
        return personDsg;
    }
    public void setPersonDsg(String personDsg) {
        this.personDsg = personDsg;
    }

    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }
}