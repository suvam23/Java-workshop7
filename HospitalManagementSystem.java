package workshop7;

/**
 * THE Person class represents a generic person in the hospital management system.
 * This is the parent class for patient and Doctor classes.
 * It contains the basic personal information common to all individuals.
 * 
 */
class Person{
	String personID;
	String name;
	int age;
	String gender;
	String address;
	int contactDetails;
	/**
	 * Constructor to create a Person object with all details
	 * 
	 * @param personID Unique identifier for the person
	 * @param name Full name of the person
	 * @param age Age of the person
	 * @param gender Gender of the person
	 * @param address Residential address
	 * @param contactDetails Contact information (phone number)
	 */
	public Person(String personID, String name, int age, String gender, String address, int contactDetails) {
		this.personID=personID;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.address=address;
		this.contactDetails=contactDetails;
	}
	/**
	 * Displays all the personal details of the person.
	 * This method prints the person's ID, name, age, gender, address, contactDetails
	 */
	public void viewPersonalDetails() {
		System.out.println("ID: "+ personID +" Name: "+ name +" Age: "+ age +" Gender: "+ gender +" Address: "+ address +" Contact Details: "+ contactDetails);
	}
}

/**
 * The patient class represents a patient in the hospital management system.
 * It extends the Person class and adds patient-specific functionality.
 * Patients can book appointments
 */
class Patient extends Person{
	String patientID;
	/**
	 * Constructor to create a Patient object
	 * 
	 * @param personID Inherited from Person class
	 * @param name Inherited from Person class
	 * @param age Inherited from Person class
	 * @param gender Inherited from Person class
	 * @param address Inherited from Person class
	 * @param contactDetails  Inherited from Person class
	 * @param patientID  Unique Identifier for the patient
	 */
	public Patient(String personID, String name, int age, String gender, String address, int contactDetails, String patientID) {
		super(personID, name, age, gender, address, contactDetails);
		this.patientID = patientID;
	}
	/**
	 * books a new appointment with a doctor
	 * @param doctor The doctor to book appointment with
	 * @param date The date of the appointment
	 */
	public void bookAppointment(Doctor doctor, String date) {
		System.out.println(name +" booked appointment with Dr. "+doctor.name+" on "+date);
	}
}

/**
 * The doctor class represents a medical doctor in the hospital management system.
 * It extends the person class and adds doctor-specific functionality.
 * Doctors can see patient details and prescribe treatments.
 * 
 */
class Doctor extends Person{
	String doctorID;
	String department;
	/**
	 * Constructor to create a doctor object.
	 * 
	 * @param personID Inherited from Person class
	 * @param name Inherited from Person class
	 * @param age Inherited form Person class
	 * @param gender Inherited from Person class
	 * @param address Inherited from Person class
	 * @param contactDetails Inherited from Person class
	 * @param doctorID Unique identifier for the doctor
	 * @param department Department where doctor works
	 * 
	 */
	public Doctor(String personID, String name, int age, String gender, String address, int contactDetails, String doctorID, String department) {
		super(personID, name, age, gender, address, contactDetails);
		this.doctorID = doctorID;
		this.department = department;
	}
	/**
	 * Displays detailed information about a patient
	 * @param patient The patient whose details to view
	 */
	public void seePatientDetails(Patient patient) {
		System.out.println("Dr. "+ name +" viewing patient: "+ patient.name);
	}
	/**
	 * Prescribes a treatment for a patient during an appointment
	 * @param patient The patient to prescribe treatment for 
	 * @param medicine Prescribed medicine
	 */
	public void prescribeTreatment(Patient patient, String medicine) {
		System.out.println("Dr. "+ name +" prescribed "+ medicine + " to "+ patient.name);
	}
}
/***
 * The Appointment class represents a medical appointment in the hospital management system.
 * It connects patients with doctors at a specific date and time.
 * 
 */
class Appointment{
	String appointmentID;
	String date;
	String time;
	/**
	 * Constructor to create an appointment object.
	 * 
	 * @param appointmentID Unique identifier for the appointment
	 * @param date Date of appointment in format YYYY-MM-DD
	 * @param time Time of appointment in format HH:MM AM/PM
	 * 
	 */
	public Appointment(String appointmentID, String date, String time) {
		this.appointmentID=appointmentID;
		this.date=date;
		this.time=time;
	}
	/**
	 * Reschedules the appointment to a new date
	 * 
	 * @param newDate The new date for the appointment
	 */
	public void rescheduleAppointment(String newDate) {
		this.date=newDate;
		System.out.println("Appointment rescheduled to: "+newDate);
	}
	/**
	 * Cancels the appointment and prints the cancellation message
	 * Changes status to "Canceled"
	 * 
	 */
	public void cancelAppointment() {
		System.out.println("Appointment cancelled");
	}
	/**
	 * Displays detailed information about the appointment
	 * Shows appointment ID, date, time.
	 */
	public void viewAppointmentDetails() {
		System.out.println("Appointment: "+appointmentID+" on "+date+" at "+time);
	}
}
/**
 * The Treatment class represents a medical treatment prescribed by a doctor.
 * It contains details about the treatment type, description, and prescribed medication. 
 */
class Treatment{
	String treatmentID;
	String type;
	String description;
	/**
	 * Constructor to create  a treatment object
	 * 
	 * @param treatmentID unique identifier for the treatment
	 * @param type type of treatment
	 * @param description Detailed description of treatment
	 */
	public Treatment(String treatmentID, String type, String description) {
		this.treatmentID = treatmentID;
		this.type = type;
		this.description=description;
	}
	/**
	 * Updated the description of the treatment
	 * @param newDescription the new description
	 */
	public void updateDescription(String newDescription) {
		this.description = newDescription;
		System.out.println("Treatment description updated");
	}
	/**
	 * Displays the detailed information about the treatment.
	 * shows treatment ID, type, description, 
	 */
	public void viewTreatmentDetails() {
		System.out.println("Treatment "+treatmentID+": "+type+" - "+description);
	}
}

/**
 * The HospitalManagementSystem class demonstrates the functionality of the hospital management system with a main method.
 * 
 * Default constructor
 */
public class HospitalManagementSystem {

	//default constructor
	/**
	 * Main method that runs the hospital management system.
	 * Creates doctor and patient objects and demonstrates their functionality.
	 * @param args Command line argument
	 */
	public static void main(String[] args) {
		//Default constructor
		Doctor d = new Doctor("D001", "Dipesh Chhetri", 21, "Male", "Kathmandu", 97494, "D334", "Neurology");
		Patient p = new Patient("P001", "Divyani Khatri", 19, "Female", "Kathmandu", 9874560, "D333");
		
		d.viewPersonalDetails();
		p.viewPersonalDetails();
		
		p.bookAppointment(d, "2026-01-10");
		d.seePatientDetails(p);
		d.prescribeTreatment(p, "Paracetamol");
		
		
	}

}