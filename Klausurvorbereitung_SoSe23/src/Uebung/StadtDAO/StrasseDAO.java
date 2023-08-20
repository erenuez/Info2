package Uebung.StadtDAO;

public class StrasseDAO {
    int id;
    int stadtVonID;
    int StadtNachID;
    double distanz;

    public StrasseDAO(int id, int stadtVonID, int stadtNachID, double distanz) {
        this.id = id;
        this.stadtVonID = stadtVonID;
        StadtNachID = stadtNachID;
        this.distanz = distanz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStadtVonID() {
        return stadtVonID;
    }

    public void setStadtVonID(int stadtVonID) {
        this.stadtVonID = stadtVonID;
    }

    public int getStadtNachID() {
        return StadtNachID;
    }

    public void setStadtNachID(int stadtNachID) {
        StadtNachID = stadtNachID;
    }

    public double getDistanz() {
        return distanz;
    }

    public void setDistanz(double distanz) {
        this.distanz = distanz;
    }
}
