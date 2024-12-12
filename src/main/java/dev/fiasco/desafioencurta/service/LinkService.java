package dev.fiasco.desafioencurta.service;

import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import dev.fiasco.desafioencurta.entities.Link;
import dev.fiasco.desafioencurta.repositories.LinkRepository;

@Service
public class LinkService {
    
    private LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String generateRandomUrl() {
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }

    public Link shortenedUrl(String urlOriginal) {
        Link link = new Link();
        link.setUrlLong(urlOriginal);
        link.setUrlShort(generateRandomUrl());
        link.setUrlCreated(LocalDateTime.now());
        link.setUrlQrCode("QRCODE unavailable at the moment!");

        return linkRepository.save(link);
    }

    /*public String getUrlOriginal(String urlShort) {
        try {
            return linkRepository.findByUrlOriginal(urlShort); 
        } catch (Exception e) {
            throw new RuntimeException("URL does not exist in our records", e);
        }
    }*/
}
