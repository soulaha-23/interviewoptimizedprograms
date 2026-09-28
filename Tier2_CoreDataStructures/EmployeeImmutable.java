import java.util.*;

public final class EmployeeImmutable {

    private final int id;
    private final String name;
    private final Date joiningDate;
    private final List<String> skills;

    public EmployeeImmutable(
            int id,
            String name,
            Date joiningDate,
            List<String> skills) {

        this.id = id;
        this.name = name;

        this.joiningDate =
                new Date(joiningDate.getTime());

        this.skills =
                new ArrayList<>(skills);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getJoiningDate() {
        return new Date(joiningDate.getTime());
    }

    public List<String> getSkills() {
        return Collections.unmodifiableList(skills);
    }
}

class EmployeeImmutableDemo {

    public static void main(String[] args) {

        Date joining = new Date();
        List<String> skills = new ArrayList<>(List.of("Java", "SQL"));

        EmployeeImmutable employee =
                new EmployeeImmutable(1, "Ravi", joining, skills);

        joining.setTime(0);
        skills.add("Python");

        System.out.println(employee.getName());
        System.out.println(employee.getJoiningDate().equals(joining));
        System.out.println(employee.getSkills());
    }
}
