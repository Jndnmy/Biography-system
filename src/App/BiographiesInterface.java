/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.ArrayList;

/**
 *
 * @author Jason
 */
public interface BiographiesInterface {
    
    public void setType(String Type);

    public void setBios(ArrayList Bios);
    
    public void addBio(Object Bio);
    
    public void deleteBio(int i);

    public String getType();

    public ArrayList getBios();
}
