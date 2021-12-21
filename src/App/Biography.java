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
public class Biography implements BiographyInterface {
    String id;
    String text;
    String staffId;
    String speciality;
    String edited;

    public Biography(int i, String[][] bioList) {
        this.id = bioList[i][0];
        this.text = bioList[i][1];
        this.staffId = bioList[i][2];
        this.speciality = bioList[i][3];
        this.edited = bioList[i][4];
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getText() {
        return text;
    }
    @Override
    public void setText(String Text) {
        this.text = Text;
    }
    @Override
    public String getStaffId() {
        return staffId;
    }
    @Override
    public void setStaffid(String Staffid) {
        this.staffId = Staffid;
    }
    @Override
    public String getSpeciality() {
        return speciality;
    }
    @Override
    public void setSpeciality(String Speciality) {
        this.speciality = Speciality;
    }
    @Override
    public String getEdited() {
        return edited;
    }
    @Override
    public void setEdited(String Edited) {
        this.edited = Edited;
    }
   
}
