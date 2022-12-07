package edu.eci.arsw.papermind.backend.exception;

import java.util.Date;

public class ErrorDetails {
    private Date timeStamp;
    private String mansaje;
    private String details;

    public ErrorDetails(Date timeStamp, String mensaje, String details) {
        super();
        this.timeStamp = timeStamp;
        this.mansaje = mensaje;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMansaje() {
        return mansaje;
    }

    public void setMansaje(String mansaje) {
        this.mansaje = mansaje;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
