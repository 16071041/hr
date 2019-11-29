package nuc.web.pojo;


import java.io.Serializable;

/**
 * 职称表
 *
 */
public class Position {

    private static final long serialVersionUID = 1L;

    private int id;
    private int position_number;
    private String name;
    private String level;
    private String notes;

    public Position() {
    }

    public Position(int id, int position_number, String name, String level, String notes) {
        this.id = id;
        this.position_number = position_number;
        this.name = name;
        this.level = level;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition_number() {
        return position_number;
    }

    public void setPosition_number(int position_number) {
        this.position_number = position_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", position_number=" + position_number +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
