INSERT INTO dictionary.place_status (id, code, created_by, created_date, modified_by, modified_date)
VALUES (1, 'FREE', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place_status (id, code, created_by, created_date, modified_by, modified_date)
VALUES (2, 'OCCUPIED', 'movie-repository', now(), 'movie-repository', now());

INSERT INTO dictionary.ticket_type (id, code, price, created_by, created_date, modified_by, modified_date)
VALUES (1, 'CHILD', 12.5, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.ticket_type (id, code, price, created_by, created_date, modified_by, modified_date)
VALUES (2, 'STUDENT', 18, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.ticket_type (id, code, price, created_by, created_date, modified_by, modified_date)
VALUES (3, 'ADULT', 25, 'movie-repository', now(), 'movie-repository', now());

INSERT INTO dictionary.ticket_status (id, code, created_by, created_date, modified_by, modified_date)
VALUES (1, 'RESERVED', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.ticket_status (id, code, created_by, created_date, modified_by, modified_date)
VALUES (2, 'CONFIRMED', 'movie-repository', now(), 'movie-repository', now());

INSERT INTO dictionary.room_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (1, 'R1', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.room_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (2, 'R2', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.room_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (3, 'R3', 'movie-repository', now(), 'movie-repository', now());

INSERT INTO dictionary.room (id, room_number_id, created_by, created_date, modified_by, modified_date)
VALUES (1, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.room (id, room_number_id, created_by, created_date, modified_by, modified_date)
VALUES (2, 2, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.room (id, room_number_id, created_by, created_date, modified_by, modified_date)
VALUES (3, 3, 'movie-repository', now(), 'movie-repository', now());

INSERT INTO dictionary.place_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (1, 'A1', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (2, 'A2', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (3, 'A3', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (4, 'A4', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (5, 'A5', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (6, 'B1', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (7, 'B2', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (8, 'B3', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (9, 'B4', 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place_number (id, code, created_by, created_date, modified_by, modified_date)
VALUES (10, 'B5', 'movie-repository', now(), 'movie-repository', now());

INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (1, 1, 1, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (2, 1, 2, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (3, 1, 3, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (4, 1, 4, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (5, 1, 5, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (6, 1, 6, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (7, 1, 7, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (8, 1, 8, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (9, 1, 9, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (10, 1, 10, 1, 'movie-repository', now(), 'movie-repository', now());

INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (11, 2, 1, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (12, 2, 2, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (13, 2, 3, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (14, 2, 4, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (15, 2, 5, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (16, 2, 6, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (17, 2, 7, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (18, 2, 8, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (19, 2, 9, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (20, 2, 10, 1, 'movie-repository', now(), 'movie-repository', now());

INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (21, 3, 1, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (22, 3, 2, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (23, 3, 3, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (24, 3, 4, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (25, 3, 5, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (26, 3, 6, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (27, 3, 7, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (28, 3, 8, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (29, 3, 9, 1, 'movie-repository', now(), 'movie-repository', now());
INSERT INTO dictionary.place (id, room_id, place_number_id, place_status_id, created_by, created_date, modified_by, modified_date)
VALUES (30, 3, 10, 1, 'movie-repository', now(), 'movie-repository', now());