package modells;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TabloData {
    private Long dataId;
    private Long id;
    private String time;
    private Image image;
    private String flight;
    private String destination;
    private String terminal;
    private String status;
    private String boardingClosed;
    private String checkInClosed;
    private String type;

    public TabloData() {
    }

    public TabloData(Long dataId, Long id, String time, ImageView imageView, String flight, String destination, String terminal, String status, String boardingClosed, String checkInClosed, String type) {
        this.dataId = dataId;
        this.id = id;
        this.time = time;
        this.image = image;
        this.flight = flight;
        this.destination = destination;
        this.terminal = terminal;
        this.status = status;
        this.boardingClosed = boardingClosed;
        this.checkInClosed = checkInClosed;
        this.type = type;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public String getBoardingClosed() {
        return boardingClosed;
    }

    public void setBoardingClosed(String boardingClosed) {
        this.boardingClosed = boardingClosed;
    }

    public String getCheckInClosed() {
        return checkInClosed;
    }

    public void setCheckInClosed(String checkInClosed) {
        this.checkInClosed = checkInClosed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
