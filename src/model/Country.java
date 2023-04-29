package model;
public class Country implements Comparable<Country>{
    String name;
    int bronces;
    int platas;
    int oros;

    public Country(String name, int bronces, int platas, int oros) {
        this.name = name;
        this.bronces = bronces;
        this.platas = platas;
        this.oros = oros;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBronces() {
        return bronces;
    }

    public void setBronce(int bronces) {
        this.bronces = bronces;
    }

    public int getPlatas() {
        return platas;
    }

    public void setPlata(int platas) {
        this.platas = platas;
    }

    public int getOros() {
        return oros;
    }

    public void setOro(int oros) {
        this.oros = oros;
    }

    public int getTotalmedallas() {
        return oros+platas+bronces;
    }



   @Override
    public int compareTo(Country o) {
        int value = this.getOros() - o.getOros();
        if (value == 0) {
            value = this.getPlatas() - o.getPlatas();
            if (value == 0) {
                value = this.getBronces() - o.getBronces();
                if (value == 0) {
                    value = this.name.compareTo(o.getName());
                }
            }
        }
        return value;
    }




}
