/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

/**
 *
 * @author Jason
 */
public class DatabaseAdapter implements DbInterfaceStaff, DbInterfaceBio {

    @Override
    public String[][] getBioList() {//Returns sample dataset for biography
        String[][] bios
                = {{"0", "Hard worker studied consumer law for 30 years", "0", "Consumer", "20/12/2020"},
                {"1", "25 years experience working in the field", "1", "Consumer", "20/12/2021"},
                {"2", "Bestselling financial author", "2", "Financial", "20/12/2021"},
                {"3", "Has assisted over 300 clients", "3", "Consumer", "20/12/2021"},
                {"4", "Has helped many customers in this field", "0", "Retail", "20/12/2021"}};
        return bios;
    }

    @Override
    public String[][] getStaffList() {//Returns sample dataset for staff
        String[][] staff = 
        {{"0", "John Holland", "52", "11/11/2014"}, 
            {"1", "Steven York", "50", "12/04/2015"}, 
            {"2", "Roger Truk", "25", "09/12/2019"}, 
            {"3", "Mike Smith", "35", "12/04/2006"}};
        return staff;
    }
}
