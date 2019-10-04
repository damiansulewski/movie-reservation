CREATE SEQUENCE ticket_type_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS dictionary.ticket_type
(
    id            BIGINT             NOT NULL
        CONSTRAINT ticket_type_pkey
            PRIMARY KEY,
    code          VARCHAR(20) UNIQUE NOT NULL,
    price         NUMERIC(6, 2)      NOT NULL,
    created_by    VARCHAR(60)        NOT NULL,
    created_date  TIMESTAMP          NOT NULL,
    modified_by   VARCHAR(60)        NOT NULL,
    modified_date TIMESTAMP          NOT NULL
);

CREATE SEQUENCE ticket_status_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS dictionary.ticket_status
(
    id            BIGINT             NOT NULL
        CONSTRAINT ticket_status_pkey
            PRIMARY KEY,
    code          VARCHAR(20) UNIQUE NOT NULL,
    created_by    VARCHAR(60)        NOT NULL,
    created_date  TIMESTAMP          NOT NULL,
    modified_by   VARCHAR(60)        NOT NULL,
    modified_date TIMESTAMP          NOT NULL
);

CREATE SEQUENCE place_status_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS dictionary.place_status
(
    id            BIGINT             NOT NULL
        CONSTRAINT place_status_pkey
            PRIMARY KEY,
    code          VARCHAR(20) UNIQUE NOT NULL,
    created_by    VARCHAR(60)        NOT NULL,
    created_date  TIMESTAMP          NOT NULL,
    modified_by   VARCHAR(60)        NOT NULL,
    modified_date TIMESTAMP          NOT NULL
);

CREATE SEQUENCE place_number_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS dictionary.place_number
(
    id            BIGINT             NOT NULL
        CONSTRAINT place_number_pkey
            PRIMARY KEY,
    code          VARCHAR(20) UNIQUE NOT NULL,
    created_by    VARCHAR(60)        NOT NULL,
    created_date  TIMESTAMP          NOT NULL,
    modified_by   VARCHAR(60)        NOT NULL,
    modified_date TIMESTAMP          NOT NULL
);

CREATE SEQUENCE room_number_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS dictionary.room_number
(
    id            BIGINT             NOT NULL
        CONSTRAINT room_number_pkey
            PRIMARY KEY,
    code          VARCHAR(20) UNIQUE NOT NULL,
    created_by    VARCHAR(60)        NOT NULL,
    created_date  TIMESTAMP          NOT NULL,
    modified_by   VARCHAR(60)        NOT NULL,
    modified_date TIMESTAMP          NOT NULL
);
