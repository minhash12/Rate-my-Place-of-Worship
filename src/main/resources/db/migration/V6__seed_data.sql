CREATE TABLE seed_data
(
    id     INTEGER      NOT NULL,
    place  VARCHAR(255) NOT NULL,
    seeded BOOLEAN      NOT NULL,
    CONSTRAINT pk_seed_data PRIMARY KEY (id)
);

insert into seed_data (id, place, seeded) values (1,'Reading', false)
