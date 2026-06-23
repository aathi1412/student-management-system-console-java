package src.com.studentmanagementsystem.model;
public  class Faculty {
    private String name;
    private String subject;

    public Faculty(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() { return name; }

    public void update(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void display() {
        System.out.println("\n--- Faculty Details ---");
        System.out.println("Name: " + name);
        System.out.println("Subject: " + subject);
    }
}
