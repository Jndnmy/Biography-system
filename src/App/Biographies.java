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
public class Biographies implements BiographiesInterface {

    String type;
    ArrayList bios;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String Type) {
        this.type = Type;
    }

    @Override
    public ArrayList getBios() {
        return bios;
    }

    @Override
    public void setBios(ArrayList Bios) {
        this.bios = Bios;
    }

    @Override
    public void addBio(Object Bio) {//Adds Biography to Bios
        this.bios.add(Bio);
    }

    @Override
    public void deleteBio(int i) {//deletes Biography at specific index
        this.bios.remove(i);
    }

    public Biographies(String Type) {
        this.type = Type;
        this.bios = new ArrayList();
    }
}
