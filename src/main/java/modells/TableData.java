package modells;

import javafx.scene.image.Image;

/**
 * Created by Loving on 15.12.2018.
 */
public class TableData {
    private  String Vremya;
    private  Image Image;
    private  String Reys;
    private  String Mashrut;
    private  String Status;

    public TableData(String s, String s1) {
    }

    public TableData(String vremya, javafx.scene.image.Image image, String reys, String mashrut, String status) {
        Vremya = vremya;
        Image = image;
        Reys = reys;
        Mashrut = mashrut;
        Status = status;
    }

    public String getVremya() {
        return Vremya;
    }

    public void setVremya(String vremya) {
        Vremya = vremya;
    }

    public javafx.scene.image.Image getImage() {
        return Image;
    }

    public void setImage(javafx.scene.image.Image image) {
        Image = image;
    }

    public String getReys() {
        return Reys;
    }

    public void setReys(String reys) {
        Reys = reys;
    }

    public String getMashrut() {
        return Mashrut;
    }

    public void setMashrut(String mashrut) {
        Mashrut = mashrut;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
