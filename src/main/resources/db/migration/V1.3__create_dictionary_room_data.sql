CREATE SEQUENCE room_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS dictionary.room
(
    id             BIGINT      NOT NULL
        CONSTRAINT room_pkey
            PRIMARY KEY,
    room_number_id BIGINT      NOT NULL REFERENCES dictionary.room_number,
    created_by     VARCHAR(60) NOT NULL,
    created_date   TIMESTAMP   NOT NULL,
    modified_by    VARCHAR(60) NOT NULL,
    modified_date  TIMESTAMP   NOT NULL
);

CREATE SEQUENCE place_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS dictionary.place
(
    id              BIGINT      NOT NULL
        CONSTRAINT place_pkey
            PRIMARY KEY,
    room_id         BIGINT      NOT NULL REFERENCES dictionary.room,
    ticket_id       BIGINT REFERENCES ticket,
    place_number_id BIGINT      NOT NULL REFERENCES dictionary.place_number,
    place_status_id BIGINT      NOT NULL REFERENCES dictionary.place_status,
    created_by      VARCHAR(60) NOT NULL,
    created_date    TIMESTAMP   NOT NULL,
    modified_by     VARCHAR(60) NOT NULL,
    modified_date   TIMESTAMP   NOT NULL
);
