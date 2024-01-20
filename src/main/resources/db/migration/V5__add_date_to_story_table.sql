--
-- Name: story; Type: TABLE; Schema: public
--
ALTER TABLE story ADD date_battle_at TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT NULL;
UPDATE story SET date_battle_at = CURRENT_TIMESTAMP AT TIME ZONE 'Europe/Kiev' WHERE story.date_battle_at IS NULL;
ALTER TABLE story ALTER date_battle_at SET NOT NULL;