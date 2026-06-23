package src.com.studentmanagementsystem.model;

public class Student {
    private String name;
    private int rollNo;
    private String dob;
    private int attendance;
    private boolean feesPaid;
    private String personalDetails;

    public Student(String name, int rollNo, String dob, int attendance, boolean feesPaid, String personalDetails) {
        this.name = name;
        this.rollNo = rollNo;
        this.dob = dob;
        this.attendance = attendance;
        this.feesPaid = feesPaid;
        this.personalDetails = personalDetails;
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }

    public void update(String name, String dob, int attendance, boolean feesPaid, String personalDetails) {
        this.name = name;
        this.dob = dob;
        this.attendance = attendance;
        this.feesPaid = feesPaid;
        this.personalDetails = personalDetails;
    }

    public void display() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("DOB: " + dob);
        System.out.println("Attendance: " + attendance + "%");
        System.out.println("Fees Paid: " + (feesPaid ? "Yes" : "No"));
        System.out.println("Personal Details: " + personalDetails);
    }
}
