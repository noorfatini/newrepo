package src.main.java.com.fullstack.demo;

public class CourseOffering {
    private String offeringId;
    private String offeringName;
    private Course course;
    private Instructor instructor;
    private String startDate;
    private String endDate;
    private int capacity;
    private String deliveryMode;

    public CourseOffering(String offeringId, String offeringName, Course course, Instructor instructor, String startDate, String endDate, int capacity, String deliveryMode) {
        this.offeringId = offeringId;
        this.offeringName = offeringName;
        this.course = course;
        this.instructor = instructor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacity = capacity;
        this.deliveryMode = deliveryMode;
    }

    public String getOfferingId() {
        return offeringId;
    }

    public String getOfferingName() {
        return offeringName;
    }

    public Course getCourse() {
        return course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void printOfferingSummary() {
        System.out.println("Offering ID: " + getOfferingId());
        System.out.println("Offering Name: " + getOfferingName());
        System.out.println("Course: " + getCourse().getTitle());
        System.out.println("Instructor: " + getInstructor().getInstructorName());
        System.out.println("Start Date: " + getStartDate());
        System.out.println("End Date: " + getEndDate());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Delivery Mode: " + getDeliveryMode());
    }
}
