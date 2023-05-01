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

package prog2.finalgroup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyProgramUtility {

    /**
     * Reads a CSV file of citizen data and returns a list of Citizen objects
     *
     * @param filePath the path to the CSV file
     * @return a List of Citizen objects
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static List<Citizen> readCitizensFromFile(String filePath) throws IOException {
        List<Citizen> citizens = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("D:/cs122_9301team8/_9301DeTorresDelizoLacanilaoLimbocRagudosRoxasFinalGroupProject/res/data.csv"));

        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");

            String fullName = values[0] + " " + values[1];
            String email = values[2];
            String address = values[3].replaceAll("\"", "");
            int age = Integer.parseInt(values[4]);
            boolean resident = values[5].equalsIgnoreCase("resident");
            int district = Integer.parseInt(values[6]);
            char gender = values[7].charAt(0);

            citizens.add(new Citizen(fullName, email, address, age, resident, district, gender));
        }

        br.close();
        return citizens;
    } // end of readCitizensFromFile method

    // TODO: Add more methods to process the list and generate useful information
    // Here are the potential examples:
    // - countByGender(List<Citizen> citizens): returns the count of male and female citizens in the list
    // - countByDistrict(List<Citizen> citizens): returns the count of citizens in each district
    // - countSeniors(List<Citizen> citizens): returns the count of senior citizens (age 60 and above) in the list
    // - getResidents(List<Citizen> citizens): returns a new List containing only the citizens who are residents
    // - getCitizensByAgeRange(List<Citizen> citizens, int minAge, int maxAge): returns a new List containing only the citizens whose age falls within the specified range
    // - getOldestCitizen(List<Citizen> citizens): returns the Citizen object with the highest age
    // - getYoungestCitizen(List<Citizen> citizens): returns the Citizen object with the lowest age
    // - getAverageAge(List<Citizen> citizens): returns the average age of all the citizens in the list
    // - findCitizensByKeyword(List<Citizen> citizens, String keyword): returns a new List containing only the citizens whose name or address contains the specified keyword
    // - getCitizensByDistrict(List<Citizen> citizens, int district): returns a new List containing only the citizens who belong to the specified district
    // - countNonResidents(List<Citizen> citizens): returns the count of citizens who are not residents

} // end of MyProgramUtility class