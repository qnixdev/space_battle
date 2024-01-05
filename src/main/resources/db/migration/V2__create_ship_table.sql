--
-- Name: ship; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE ship (
    id uuid NOT NULL,
    name VARCHAR(127) NOT NULL,
    weapon_power INT NOT NULL,
    strength INT NOT NULL,
    team VARCHAR(63) NOT NULL,
    PRIMARY KEY(id)
);
COMMENT ON COLUMN ship.id IS '(DC2Type:uuid)';
ALTER TABLE ship OWNER TO postgres;