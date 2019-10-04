CREATE SEQUENCE ticket_reservation_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS ticket_reservation
(
    id            BIGINT        NOT NULL
        CONSTRAINT ticket_reservation_pkey
            PRIMARY KEY,
    uuid          VARCHAR(60)   NOT NULL,
    user_email    VARCHAR(60)   NOT NULL,
    total_amount  NUMERIC(6, 2) NOT NULL,
    created_by    VARCHAR(60)   NOT NULL,
    created_date  TIMESTAMP     NOT NULL,
    modified_by   VARCHAR(60)   NOT NULL,
    modified_date TIMESTAMP     NOT NULL
);

CREATE SEQUENCE ticket_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS ticket
(
    id                    BIGINT      NOT NULL
        CONSTRAINT ticket_pkey
            PRIMARY KEY,
    ticket_type_id        BIGINT      NOT NULL REFERENCES dictionary.ticket_type,
    ticket_status_id      BIGINT      NOT NULL REFERENCES dictionary.ticket_status,
    ticket_reservation_id BIGINT      NOT NULL REFERENCES ticket_reservation,
    user_name             VARCHAR(60) NOT NULL,
    user_surname          VARCHAR(60) NOT NULL,
    expiration_date       TIMESTAMP   NOT NULL,
    end_session_date      TIMESTAMP   NOT NULL,
    created_by            VARCHAR(60) NOT NULL,
    created_date          TIMESTAMP   NOT NULL,
    modified_by           VARCHAR(60) NOT NULL,
    modified_date         TIMESTAMP   NOT NULL
);
