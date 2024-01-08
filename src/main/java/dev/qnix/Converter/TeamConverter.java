package dev.qnix.Converter;

import dev.qnix.Entity.Ship;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TeamConverter implements AttributeConverter<Ship.Team, String> {
    @Override
    public String convertToDatabaseColumn(Ship.Team team) {
        return null == team ? null : team.getTitle();
    }

    @Override
    public Ship.Team convertToEntityAttribute(String value) {
        if (null == value) {
            return null;
        }

        return Stream.of(Ship.Team.values())
            .filter(st -> st.getTitle().equals(value))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new)
        ;
    }
}