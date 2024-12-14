package dev.fiasco.desafioencurta.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.fiasco.desafioencurta.dto.LinkDTO;
import dev.fiasco.desafioencurta.entities.Link;
import dev.fiasco.desafioencurta.service.LinkService;

@RestController
public class LinkController {
    
    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<LinkDTO> generateUrlShort(@RequestBody Map<String, String> request){

        String urlOriginal = request.get("urlOriginal");
        Link link = linkService.shortenedUrl(urlOriginal);

        String generateUserRedirectUrl = "http://localhost8080/link/" + link.getUrlShort();

        LinkDTO dto = new LinkDTO(
            link.getId(), 
            link.getUrlLong(), 
            generateUserRedirectUrl, 
            link.getUrlQrCode(), 
            link.getUrlCreated()   
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }


}
