public class Project {
    // Member Variables
    private String name;
    private String description;

    // Constructors
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Project(String name) {
        this.name = name;
        this.description = null;
    }
    public Project() {
        this.name = null;
        this.description = null;
    }
    // Getters
    public String getProjectName() {
        return this.name;
    }

    public String getProjectDescription() {
        return this.description;
    }
    // Setters
    public void setProjectName(String new_name) {
        this.name = new_name;
    }

    public void setProjectDesc(String new_desc) {
        this.description = new_desc;
    }
    // others
    public String elevatorPitch() {
        String pitch = this.name + " : " + this.description;
        return pitch;
    }
}