package com.dictionary.region.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Region {

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "code")
    private Long code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(name, region.name) && Objects.equals(code, region.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }
}
