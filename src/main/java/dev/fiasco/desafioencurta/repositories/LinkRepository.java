package dev.fiasco.desafioencurta.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.fiasco.desafioencurta.entities.Link;

public interface LinkRepository extends MongoRepository <Link , String > {
    
    Link findByUrlOriginal(String urlShort);
}
