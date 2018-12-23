package modells;

import javafx.scene.image.ImageView;

/**
 * Created by Loving on 15.12.2018.
 */
public class TableData {
    private String time;
    private ImageView imageView;
    private String flight;
    private String destination;
    private Integer terminal;
    private String status;

    public TableData() {
    }

    public TableData(String time, ImageView imageView, String flight, String destination,Integer terminal, String status) {
        this.time = time;
        imageView.setFitHeight(50);
        imageView.setFitWidth(220);
        this.imageView = imageView;
        this.flight = flight;
        this.destination = destination;
        this.terminal=terminal;
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getTerminal() {
        return terminal;
    }

    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }
    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
