package com.adu.api.repository;

import com.adu.api.model.MaterialRoof;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MaterialRoofRepository extends ReactiveCrudRepository<MaterialRoof, Long> {

    Flux<MaterialRoof> findByColor(String color);    
}
