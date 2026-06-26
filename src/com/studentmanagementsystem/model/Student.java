package src.com.studentmanagementsystem.model;

public class Student {
    private int id;
    private String name;
    private int rollNo;
    private String dob;
    private int attendance;
    private boolean feesPaid;
    private String personalDetails;

    public Student() {
    }

    public Student(String name, int rollNo, String dob, int attendance, boolean feesPaid, String personalDetails) {
        this.name = name;
        this.rollNo = rollNo;
        this.dob = dob;
        this.attendance = attendance;
        this.feesPaid = feesPaid;
        this.personalDetails = personalDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRollNo() { 
        return rollNo; 
    }
    
    public String getName() {
        return name; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public boolean isFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(boolean feesPaid) {
        this.feesPaid = feesPaid;
    }

    public String getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(String personalDetails) {
        this.personalDetails = personalDetails;
    }

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
