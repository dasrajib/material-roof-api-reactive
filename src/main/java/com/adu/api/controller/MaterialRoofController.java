package com.adu.api.controller;

import com.adu.api.model.MaterialRoof;
import com.adu.api.service.MaterialRoofService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/materialroof")
@RequiredArgsConstructor
@Tag(name = "Roof Material Management", description = "APIs for managing roof material")
public class MaterialRoofController {

    private final MaterialRoofService materialroofService;

    @GetMapping
    @Operation(summary = "Get all roof material")
    public Flux<MaterialRoof> getAllMaterialRoof() {
        return materialroofService.getAllMaterialRoof();
    }

    @GetMapping("/{materialroof_id}")
    @Operation(summary = "Get materialroof by ID")
    public Mono<MaterialRoof> getMaterialRoofById(@PathVariable Long materialroof_id) {
        return materialroofService.getMaterialRoofById(materialroof_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new materialroof")
    public Mono<MaterialRoof> createMaterialRoof(@RequestBody MaterialRoof materialroof) {
        return materialroofService.createMaterialRoof(materialroof);
    }

    @PutMapping("/{materialroof_id}")
    @Operation(summary = "Update an existing materialroof")
    public Mono<MaterialRoof> updateMaterialRoof(@PathVariable Long materialroof_id, @RequestBody MaterialRoof materialroof) {
        return materialroofService.updateMaterialRoof(materialroof_id, materialroof);
    }

    @DeleteMapping("/{materialroof_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a materialroof")
    public Mono<Void> deleteMaterialRoof(@PathVariable Long materialroof_id) {
        return materialroofService.deleteMaterialRoof(materialroof_id);
    }
}
