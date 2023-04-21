/**
 * Group 8
 * Class Code and Course Number: 9301 - CS 122
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     LACANILAO, Marvin Patrick D. - 2230153
 *     DE TORRES, John Rey I. - 2234944
 *     DELIZO, John Marco - 2234758
 *     LIMBOC, Trixie Mae W. - 2233674
 *     RAGUDOS, Hannah T.- 2233361
 *     ROXAS, Johan Rickardo A. - 2233375
 * </p>
 */

import java.util.Objects;
public class Citizen implements Comparable<Citizen> {
    private String fullName; // The full name of the citizen
    private String email; // The email of the citizen
    private String address; // The address of the citizen
    private int age; // The age of the citizen
    private boolean resident; // The residential status of the citizen (true if resident, false if not)
    private int district; // The district number of the citizen
    private char gender; // The gender of the citizen (M or F)

    /**
     * Constructs an object of Citizen with user-defined values.
     * @param fullName The full name of the citizen
     * @param email    The email of the citizen
     * @param address  The address of the citizen
     * @param age      The age of the citizen
     * @param resident The residential status of the citizen
     * @param district The district number of the citizen
     * @param gender   The gender of the citizen (M or F)
     */
    public Citizen(String fullName, String email, String address, int age, boolean resident,
                   int district, char gender) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.resident = resident;
        this.district = district;
        this.gender = gender;
    } // end of Citizen default constructor

    /**
     * Mutator method for the full name attribute.
     * @param fullName The new full name of the citizen
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    } // end of setFullName mutator method

    /**
     * Mutator method for the email attribute.
     * @param email The new email of the citizen
     */
    public void setEmail(String email) {
        this.email = email;
    } // end of steEmail method

    /**
     * Mutator method for the address attributes
     * @param address The new address of the citizen
     */
    public void setAddress(String address) {
        this.address = address;
    } // end of setAddress mutator method

    /**
     * Mutator method for the age attribute.
     * @param age The new age of the citizen
     */
    public void setAge(int age) {
        this.age = age;
    } // end of setAge mutator method

    /**
     * Mutator method for the residential status attribute.
     * @param resident The new residential status of the citizen
     */
    public void setResident(boolean resident) {
        this.resident = resident;
    } // end of setResident mutator method

    /**
     * Mutator method for the district attribute.
     * @param district The new district number of the citizen
     */
    public void setDistrict(int district) {
        this.district = district;
    } // end of setDistrict method

    /**
     * Mutator method for the gender attribute.
     * @param gender The new gender of the citizen (M or F)
     */
    public void setGender(char gender) {
        this.gender = gender;
    } // end of setGender mutator method

    /**
     * Accessor method for the full name attribute.
     * @return The full name of the citizen
     */
    public String getFullName() {
        return fullName;
    } // end of getFullName accessor method

    /**
     * Accessor method for the email attribute.
     * @return The email of the citizen
     */
    public String getEmail() {
        return email;
    } // end of getEmail accessor method

    /**
     * Accessor method for the address attribute.
     * @return The address of the citizen
     */
    public String getAddress() {
        return address;
    } // end getAddress accessor method

    /**
     * Accessor method for the age attribute.
     * @return The age of the citizen
     */
    public int getAge() {
        return age;
    } // end of getAge accessor method

    /**
     * Accessor method for the residential status attribute.
     * @return The residential status of the citizen
     */
    public boolean isResident() {
        return resident;
    } // end of isResident accessor method

    /**
     * Accessor method for the district attribute.
     * @return The district number of the citizen
     */
    public int getDistrict() {
        return district;
    } // end of getDistrict accessor method

    /**
     * Accessor method for the gender attribute.
     * @return The gender of the citizen
     */
    public char getGender() {
        return gender;
    } // end of getGender accessor method

    /**
     * Determines if two Citizen objects are equal based on their attribute values.
     * @param o The object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return age == citizen.age && resident == citizen.resident && district == citizen.district && gender ==
                citizen.gender && Objects.equals(fullName, citizen.fullName) && Objects.equals(email, citizen.email)
                && Objects.equals(address, citizen.address);
    } // end of equals method

    /**
     * Generates a hash code for the Citizen object based on its attribute values.
     * @return The hash code for the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(fullName, email, address, age, resident, district, gender);
    } // end of hashCode method

    /**
     * Compares this Citizen object to another based on their full name attribute.
     * @param o The Citizen object to compare to
     * @return A negative integer, zero, or a positive integer as this object is less than,
     * equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Citizen o) {
        return fullName.compareTo(o.fullName);
    } // end of compareTo method

    /**
     * Returns a string representation of the Citizen object.
     * @return A string representation of the Citizen object
     */
    @Override
    public String toString() {
        return "Citizen{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", resident=" + resident +
                ", district=" + district +
                ", gender=" + gender +
                '}';
    } // end of toString method
} // end of Citizen class