/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Jason
 */
public class ManageBiographySystem {

    public static void main(String[] args) {
        ArrayList staffDetails;
        ArrayList bioList;
        bioList = new ArrayList();
        staffDetails = new ArrayList();
        String input = "";
        while (input != "x") {//Prints options
            System.out.println("----------------------------------");
            System.out.println("Enter 'a' to fetch biographies");
            System.out.println("Enter 'b' to create new biography");
            System.out.println("Enter 'c' to edit a biography");
            System.out.println("Enter 'd' to delete a biography");
            System.out.println("Enter 'e' to view biographies");
            System.out.println("Enter 'f' to fetch staff info");
            System.out.println("Enter 'g' to view staff");
            System.out.println("Enter 'h' to save");
            System.out.println("Enter 'x' to quit");
            input = read();
            switch (input) {//Switch statement to call the different functioins
                case "a":
                    bioList = getBios();//Returns staff biographies
                    break;
                case "b":
                    addBio(bioList, staffDetails);//Adds a new biography
                    break;

                case "c":
                    editBio(bioList);//edits existing biography
                    break;

                case "d":
                    deleteBio(bioList);//delete biography
                    break;
                case "e":
                    viewBios(bioList, staffDetails);//view biography
                    break;
                case "f":
                    staffDetails = getStaff();//gets staff
                    break;
                case "g":
                    viewStaff(staffDetails);//Displays staff members
                    break;
                case "h":
                    save();//placeholder
                    break;
                case "x":
                    Exit();//closes the program
                    return;

                default:
                    System.out.println("Unrecognised input");
            }
        }

    }

    public static void save() {
        System.out.println("Saving complete"); // would update database 
    }

    public static ArrayList addBio(ArrayList<BiographiesInterface> bios, ArrayList<Staff> staff) {
        ArrayList specialities = new ArrayList();
        if (staff.size() > 0) {//checks staff isn't empty
            for (int i = 0; i < bios.size(); i++) {
                specialities.add(bios.get(i).getType());//gets the types of every biography

            }
            System.out.println("Enter Speciality of new biography");//enter new variables for new bio
            String newType = read();
            System.out.println("Enter text of new biography");
            String newText = read();
            System.out.println("Enter staff Id of new biography");
            String newStaff = read();
            if (Integer.parseInt(newStaff) <= (staff.size() - 1)) {//Checks staff member specified exists in staff list
                BiographyInterface newBio;
                int bioId = 0;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//gets the current date in format dd/MM/YYY
                String date = sdf.format(new Date());
                for (int i = 0; i < bios.size(); i++) {
                    for (int j = 0; j < bios.get(i).getBios().size(); j++) {
                        BiographyInterface a = (BiographyInterface) (bios.get(i).getBios().get(j));
                        if (Integer.parseInt(a.getId()) - 1 >= bioId) {//sets bio id to be 1 higher than the highest bio id
                            bioId = Integer.parseInt(a.getId()) + 1;
                        }
                    }
                }
                String[][] constructorInput = {{String.valueOf(bioId), newText, newStaff, newType, date}};
                newBio = new Biography(0, constructorInput);//creates new biography

                addNewBio(bios, specialities, newType, newBio);
            } else {
                System.out.println("No staff member with that id");
            }
        } else {
            System.out.println("Please load staff");
        }
        return bios;
    }
    public static ArrayList addNewBio (ArrayList<BiographiesInterface> bios, ArrayList specialities, String newType, BiographyInterface newBio){
        if (specialities.contains(newType))//if theres an instance of biographies with the correct type 
                {//it adds the new biography to that, otherwise it creates a new biographies
                    for (int i = 0; i < bios.size(); i++) {
                        if (bios.get(i).getType().equals(newType)) {
                            bios.get(i).addBio(newBio);
                        }
                    }
                } else {
                    BiographiesInterface newBiographies;
                    newBiographies = new Biographies(newType);
                    newBiographies.addBio(newBio);
                    bios.add(newBiographies);
                }
        return bios;
    }

    public static ArrayList editBio(ArrayList<BiographiesInterface> bios) {
        System.out.println("Enter id of biography you wish to change");
        String idInput = read();
        System.out.println("Enter text of biography you want to change");
        String input = read();
        int found = 0;
        if (bios.size() > 0) {//checks bios isn't empty
            for (int i = 0; i < bios.size(); i++) {//gets biography with specified id
                for (int j = 0; j < bios.get(i).getBios().size(); j++) {
                    BiographyInterface a = (BiographyInterface) (bios.get(i).getBios().get(j));
                    if (a.getId().equals(idInput)) {
                        found =1;
                        updateBio(bios, input, j,i);
                    }
                }
            }
        } else {
            System.out.println("Please load bios first");
        }
        if (found == 0) {
            System.out.println("Could not find biography with that Id");
        }
        return bios;
    }
    public static ArrayList updateBio(ArrayList<BiographiesInterface> bios, String input, int index2,int index1){
        ArrayList<BiographyInterface> bioList = bios.get(index1).getBios();
                        bioList.get(index2).setText(input);//updates biography

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//updates the date edited to current date
                        String date = sdf.format(new Date());
                        bioList.get(index2).setEdited(date);                      
                        System.out.println("Updated biography");
                        return bioList;
    }
    public static ArrayList deleteBio(ArrayList<BiographiesInterface> bios) {
        String input;
        System.out.println("Enter the id of the bio you want to delete");
        input = read();
        int found = 0;
        if (bios.size() > 0) {
            for (int i = 0; i < bios.size(); i++) {
                for (int j = 0; j < bios.get(i).getBios().size(); j++) {
                    BiographyInterface a = (BiographyInterface) (bios.get(i).getBios().get(j));
                    if (a.getId().equals(input)) {
                        found = 1;
                        System.out.println("Enter 'confirm' to delete");
                        input = read();
                        if (input.equals("confirm")) {
                            bios.get(i).getBios().remove(j);//deletes bio with specified id
                            System.out.println("Biography deleted");
                        }
                    }
                }
            }
            if (found == 0) {
                System.out.println("Could not find biography");

            }
        } else {
            System.out.println("Please load bios");
        }
        return bios;
    }

    public static void viewBios(ArrayList<BiographiesInterface> bios, ArrayList staff) {
        String input;
        ArrayList specialities;
        specialities = new ArrayList();
        if (bios.size() > 0) {
            System.out.println("Enter Speciality you wish to view");
            for (int i = 0; i < bios.size(); i++) {
                specialities.add(bios.get(i).getType());
                System.out.println(bios.get(i).getType() + " Bios:" + bios.get(i).getBios().size());
            }
            input = read();
            if (specialities.contains(input)) {
                for (int i = 0; i < bios.size(); i++) {
                    if (bios.get(i).getType().equals(input)) {
                        for (int j = 0; j < bios.get(i).getBios().size(); j++) {
                            BiographyInterface a = (BiographyInterface) (bios.get(i).getBios().get(j));
                            System.out.println("---------------");
                            System.out.println("Bio Id: " + a.getId());
                            System.out.println("Staff Id: " + a.getStaffId());
                            if (staff.size() > 0) {// if staff is loaded displays the staff details along with the biography details
                                for (int k = 0; k < staff.size(); k++) {
                                    StaffInterface b = (StaffInterface) (staff.get(k));
                                    if (b.getId().equals(a.getStaffId())) {
                                        System.out.println("Name: " + b.getName());
                                        System.out.println("Age: " + b.getAge());
                                        System.out.println("Date of Employment: " + b.getDoe());
                                    }
                                }
                            }
                            System.out.println("Bio: " + a.getText());//prints details of biographies with specified speciality

                            System.out.println("Speciality: " + a.getSpeciality());
                            System.out.println("Date Edited: " + a.getEdited());
                        }
                    }
                }
            } else {
                System.out.println("No Biographies with that speciality");
            }
        } else {
            System.out.println("Please load Biographies first");
        }

    }

    public static ArrayList getBios() {
        BiographiesInterface bs;
        BiographyInterface by;
        DbInterfaceBio db;
        db = new DatabaseAdapter();
        ArrayList specialities;
        specialities = new ArrayList();
        ArrayList<BiographiesInterface> bios;
        bios = new ArrayList();
        System.out.println("Loading Bios");
        String[][] biographies = db.getBioList();
        for (int i = 0; i < biographies.length; i++) {//creates Biographies classes for each type
            if (specialities.contains(biographies[i][3]) == false) {
                specialities.add(biographies[i][3]);
                bs = new Biographies(biographies[i][3]);
                bios.add(bs);

            }
        }
        for (int i = 0; i < biographies.length; i++) {//creates biographies and adds them to Biographies class
            for (int j = 0; j < bios.size(); j++) {
                if (biographies[i][3].equals(bios.get(j).getType())) {
                    by = new Biography(i, biographies);
                    bios.get(j).addBio(by);
                }
            }
        }
        System.out.println("Loaded Bios");
        return bios;
    }

    public static void Exit() {
        System.out.println("Goodbye");
    }

    //loads staff into array
    public static ArrayList getStaff() {
        DbInterfaceStaff Ds;
        Ds = new DatabaseAdapter();
        ArrayList staffList;
        StaffInterface Sf;
        String[][] staff = Ds.getStaffList();
        staffList = new ArrayList();
        System.out.println("getting staff");
        for (int i = 0; i < staff.length; i++) {//creates new staff object and adds it into array
            Sf = new Staff(i, staff);
            staffList.add(Sf);
        }
        System.out.println("got staff");
        return staffList;
    }

    //Displays the staff members details
    public static void viewStaff(ArrayList<Staff> staffList) {
        if (staffList.size() > 0) {
            for (int i = 0; i < staffList.size(); i++) {
                System.out.println("--------------------");
                System.out.println("Id= " + staffList.get(i).getId());
                System.out.println("name = " + staffList.get(i).getName());
                System.out.println("Date of employment= " + staffList.get(i).getDoe());
                System.out.println("Age= " + staffList.get(i).getAge());
            }
        } else {
            System.out.println("Please load staff list");
        }
    }

    ;
    // gets input
    public static String read() {
        String input;
        Scanner newinput = new Scanner(System.in);
        input = newinput.nextLine();
        return input;

    }

}
