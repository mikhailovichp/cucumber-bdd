package Config;

/**
 * Created by Petert on 5/24/19.
 */
public class VarVault {
    private static VarVault myself = new VarVault();
    private String inn;
    private String newsZagolovok;
    private String petitionZagolovok;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String building;

    private VarVault() {
    }

    public static VarVault getInstance() {
        if (myself == null) {
            myself = new VarVault();
        }

        return myself;
    }

    public void ClearTestData() {
        myself = new VarVault();
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getInn() {
        return this.inn;
    }

    public void setNewsZagolovok(String zagolovok) {this.newsZagolovok = zagolovok;}

    public String getNewsZagolovok() {return this.newsZagolovok;}

    public void setPetitionZagolovok(String zagolovok) {this.petitionZagolovok = zagolovok;}

    public String getPetitionZagolovok() {return this.petitionZagolovok;}

    public void setfirstName(String firstName) {this.firstName = firstName;}

    public String getFirstName() {return this.firstName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getLastName() {return this.lastName;}

    public void setStreet(String street) {this.street = street;}

    public String getStreet() {return this.street;}

    public void setCity(String city) {this.city = city;}

    public String getCity() {return this.city;}

    public void setBuilding(String building) {this.building = building;}

    public String getBuilding() {return this.building;}
}
