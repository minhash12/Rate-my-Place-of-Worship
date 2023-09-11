CREATE EXTENSION IF NOT EXISTS postgis;


CREATE TABLE locations
(
    id                  UUID PRIMARY KEY               not null,
    address             varchar(256)                   not null,
    post_code           varchar(256)                   not null,
    location            GEOMETRY(POINT, 4326)         not null,
    place_of_worship_id UUID                           not null,
    created_at          timestamp(6) without time zone not null,
    updated_at          timestamp(6) without time zone not null
);

ALTER TABLE locations
    ADD CONSTRAINT FK_LOCATION_ON_POW FOREIGN KEY (place_of_worship_id) REFERENCES place_of_worship (id);
