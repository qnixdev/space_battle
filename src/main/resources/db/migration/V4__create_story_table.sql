--
-- Name: story; Type: TABLE; Schema: public
--
CREATE TABLE story (
    id uuid NOT NULL,
    id_user UUID NOT NULL,
    id_ship_one UUID NOT NULL,
    ship_one_quantity INT NOT NULL,
    id_ship_two UUID NOT NULL,
    ship_two_quantity INT NOT NULL,
    id_winner_ship UUID DEFAULT NULL,
    ship_one_remainder_health INT DEFAULT NULL,
    ship_two_remainder_health INT DEFAULT NULL,
    PRIMARY KEY(id)
);
CREATE INDEX IDX_E448ED182261A62 ON story (id_user);
CREATE INDEX IDX_E448ED12AC1D5E3 ON story (id_ship_one);
CREATE INDEX IDX_E448ED1DD2D6611 ON story (id_ship_two);
CREATE INDEX IDX_E448ED1A9255C2F ON story (id_winner_ship);
COMMENT ON COLUMN story.id IS '(DC2Type:uuid)';
COMMENT ON COLUMN story.id_user IS '(DC2Type:uuid)';
COMMENT ON COLUMN story.id_ship_one IS '(DC2Type:uuid)';
COMMENT ON COLUMN story.id_ship_two IS '(DC2Type:uuid)';
COMMENT ON COLUMN story.id_winner_ship IS '(DC2Type:uuid)';
ALTER TABLE story ADD CONSTRAINT FK_E448ED182261A62 FOREIGN KEY (id_user) REFERENCES "user" (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE story ADD CONSTRAINT FK_E448ED12AC1D5E3 FOREIGN KEY (id_ship_one) REFERENCES ship (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE story ADD CONSTRAINT FK_E448ED1DD2D6611 FOREIGN KEY (id_ship_two) REFERENCES ship (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE story ADD CONSTRAINT FK_E448ED1A9255C2F FOREIGN KEY (id_winner_ship) REFERENCES ship (id) NOT DEFERRABLE INITIALLY IMMEDIATE;