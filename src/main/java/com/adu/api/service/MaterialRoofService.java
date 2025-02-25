package com.adu.api.service;

import com.adu.api.model.MaterialRoof;
import com.adu.api.repository.MaterialRoofRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MaterialRoofService {

    private final MaterialRoofRepository materialroofRepository;

    public Flux<MaterialRoof> getAllMaterialRoof() {
        return materialroofRepository.findAll();
    }

    public Mono<MaterialRoof> getMaterialRoofById(Long materialroof_id) {
        return materialroofRepository.findById(materialroof_id);
    }

    public Mono<MaterialRoof> createMaterialRoof(MaterialRoof materialroof) {
        return materialroofRepository.save(materialroof);
    }

    public Mono<MaterialRoof> updateMaterialRoof(Long materialroof_id, MaterialRoof materialroof) {
        return materialroofRepository.findById(materialroof_id)
                .flatMap(existingMaterialRoof -> {
                    existingMaterialRoof.setDescription(materialroof.getDescription());
                    existingMaterialRoof.setColor(materialroof.getColor());
                    existingMaterialRoof.setPrice(materialroof.getPrice());

                    existingMaterialRoof.setUpdated_at(LocalDateTime.now());
                
                    return materialroofRepository.save(existingMaterialRoof);
                });
    }

    public Mono<Void> deleteMaterialRoof(Long materialroof_id) {
        return materialroofRepository.deleteById(materialroof_id);
    }
}
