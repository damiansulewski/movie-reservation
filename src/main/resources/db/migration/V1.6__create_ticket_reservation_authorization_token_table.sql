CREATE SEQUENCE ticket_reservation_authorization_token_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS ticket_reservation_authorization_token
(
    id                      BIGINT      NOT NULL
        CONSTRAINT ticket_reservation_authorization_token_pkey
            PRIMARY KEY,
    ticket_reservation_uuid VARCHAR(60) NOT NULL,
    user_email              VARCHAR(60) NOT NULL,
    token                   VARCHAR(60) NOT NULL,
    used                    BOOLEAN     NOT NULL,
    created_by              VARCHAR(60) NOT NULL,
    created_date            TIMESTAMP   NOT NULL,
    modified_by             VARCHAR(60) NOT NULL,
    modified_date           TIMESTAMP   NOT NULL
);