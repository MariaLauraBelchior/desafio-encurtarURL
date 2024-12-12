package dev.fiasco.desafioencurta.entities;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Document(collation = "links")
public class Link {

    @Id
    private String id;
    private String urlLong;
    private String urlShort; 
    private String urlQrCode;
    private LocalDateTime urlCreated;
    
    public Link() {
    }

    public Link(String id, String urlLong, String urlShort, String urlQrCode, LocalDateTime urlCreated) {
        this.id = id;
        this.urlLong = urlLong;
        this.urlShort = urlShort;
        this.urlQrCode = urlQrCode;
        this.urlCreated = urlCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlLong() {
        return urlLong;
    }

    public void setUrlLong(String urlLong) {
        this.urlLong = urlLong;
    }

    public String getUrlShort() {
        return urlShort;
    }

    public void setUrlShort(String urlShort) {
        this.urlShort = urlShort;
    }

    public String getUrlQrCode() {
        return urlQrCode;
    }

    public void setUrlQrCode(String urlQrCode) {
        this.urlQrCode = urlQrCode;
    }

    public LocalDateTime getUrlCreated() {
        return urlCreated;
    }

    public void setUrlCreated(LocalDateTime urlCreated) {
        this.urlCreated = urlCreated;
    }

    
}
