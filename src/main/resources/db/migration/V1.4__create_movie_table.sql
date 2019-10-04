CREATE SEQUENCE movie_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS movie
(
    id                          BIGINT             NOT NULL
        CONSTRAINT movie_pkey
            PRIMARY KEY,
    uuid                        VARCHAR(60) UNIQUE NOT NULL,
    name                        VARCHAR(60)        NOT NULL,
    start_date                  TIMESTAMP          NOT NULL,
    end_date                    TIMESTAMP          NOT NULL,
    room_id                     BIGINT             NOT NULL REFERENCES dictionary.room,
    created_by                  VARCHAR(60)        NOT NULL,
    created_date                TIMESTAMP          NOT NULL,
    modified_by                 VARCHAR(60)        NOT NULL,
    modified_date               TIMESTAMP          NOT NULL
);