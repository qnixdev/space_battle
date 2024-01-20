--
-- Name: user; Type: TABLE; Schema: public
--
CREATE TABLE "user" (
    id uuid NOT NULL,
    xid VARCHAR(63) NOT NULL,
    date_last_activity_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY(id)
);
COMMENT ON COLUMN "user".id IS '(DC2Type:uuid)';
CREATE UNIQUE INDEX UNIQ_5373C96682261A62 ON "user" (xid);