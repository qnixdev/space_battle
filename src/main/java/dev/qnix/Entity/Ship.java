package dev.qnix.Entity;

import com.fasterxml.jackson.annotation.JsonValue;
import dev.qnix.Service.Converter.TeamConverter;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "ship")
public class Ship {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 127, nullable = false)
    private String name;

    @Column(name = "weapon_power", nullable = false)
    private Integer weaponPower;

    @Column(name = "strength", nullable = false)
    private Integer strength;

    @Column(name = "jedi_factor", nullable = false)
    private Integer jediFactor;

    @Column(name = "team", length = 63, nullable = false)
    @Convert(converter = TeamConverter.class)
    private Team team;

    public String getNameAndSpecs() {
        return String.format("%1$s %2$s/%3$s/%4$s",
            this.getName(),
            this.getWeaponPower(),
            this.getStrength(),
            this.getJediFactor()
        );
    }

    @AllArgsConstructor
    @Getter
    public enum Team {
        EMPIRE("empire"), REBEL("rebel");

        @JsonValue
        private final String title;
    }
}