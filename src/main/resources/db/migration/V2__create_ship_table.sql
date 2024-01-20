--
-- Name: ship; Type: TABLE; Schema: public
--
CREATE TABLE ship (
    id uuid NOT NULL,
    name VARCHAR(127) NOT NULL,
    weapon_power INT NOT NULL,
    strength INT NOT NULL,
    jedi_factor INT NOT NULL,
    team VARCHAR(63) NOT NULL,
    PRIMARY KEY(id)
);
COMMENT ON COLUMN ship.id IS '(DC2Type:uuid)';

INSERT INTO ship (id, name, weapon_power, strength, jedi_factor, team) VALUES (gen_random_uuid(), 'Jedi Starfighter', 5, 30, 15, 'empire');
INSERT INTO ship (id, name, weapon_power, strength, jedi_factor, team) VALUES (gen_random_uuid(), 'CloakShape Fighter', 2, 70, 2, 'empire');
INSERT INTO ship (id, name, weapon_power, strength, jedi_factor, team) VALUES (gen_random_uuid(), 'Super Star Destroyer', 70, 500, 0, 'empire');
INSERT INTO ship (id, name, weapon_power, strength, jedi_factor, team) VALUES (gen_random_uuid(), 'RZ-1 A-wing interceptor', 4, 50, 4, 'empire');
INSERT INTO ship (id, name, weapon_power, strength, jedi_factor, team) VALUES (gen_random_uuid(), 'Rebel Cool Ship', 30, 5, 30, 'rebel');