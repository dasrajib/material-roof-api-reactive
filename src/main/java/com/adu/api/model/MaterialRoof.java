package com.adu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("material_roof")
public class MaterialRoof  {

    @Id
    private Long material_roof_id;
    private String description;
    private String color;
    private Float price;
    private LocalDateTime updated_at;
    private LocalDateTime created_at;


}
