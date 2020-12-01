public class ProjectTest {
    public static void main(String args[]) {
        Project project1 = new Project("Java", "Java coding course");
        System.out.println(project1.getProjectName());
        System.out.println(project1.getProjectDescription());
        System.out.println(project1.elevatorPitch());
    }
}