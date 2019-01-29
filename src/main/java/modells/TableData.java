package modells;

import javafx.scene.image.ImageView;

/**
 * Created by Loving on 15.12.2018.
 */
public class TableData {
    private Long dataId;
    private Long id;
    private String time;
    private ImageView imageView;
    private String flight;
    private String destination;
    private String terminal;
    private String status;

    public TableData() {
    }

    public TableData(String time, ImageView imageView, String flight, String destination, String terminal, String status) {
        this.time = time;
        imageView.setFitHeight(50);
        imageView.setFitWidth(220);
        this.imageView = imageView;
        this.flight = flight;
        this.destination = destination;
        this.terminal=terminal;
        this.status = status;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }
    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
