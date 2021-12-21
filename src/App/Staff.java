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
public class Staff implements StaffInterface {
    String id;
    String name;
    String age;
    String doe;
    public Staff (int i, String[][] stafflist) {
        this.id = stafflist[i][0];
        this.name = stafflist[i][1];
        this.age = stafflist[i][2];
        this.doe = stafflist[i][3];
    };
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getAge() {
        return age;
    }
    @Override
    public void setAge(String Age) {
        this.age = Age;
    }
    @Override
    public String getDoe() {
        return doe;
    }
    @Override
    public void setDoe(String doe) {
        this.doe = doe;
    }
    
}
