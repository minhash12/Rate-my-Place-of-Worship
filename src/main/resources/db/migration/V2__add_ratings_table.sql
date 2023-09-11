create table "ratings"
(
    id                  uuid primary key               not null,
    place_of_worship_id uuid                           not null,
    age                 varchar(256),
    gender              varchar(256),
    ethnicity           varchar(256),
    type                varchar(256)                   not null,
    welcoming           numeric,
    facilities          numeric,
    toilets             numeric,
    car_parking         numeric,
    public_transport    numeric,
    cycle               numeric,
    disabled            numeric,
    community           numeric,
    young_people        numeric,
    inter_community     numeric,
    languages           varchar(256),
    created_at          timestamp(6) without time zone not null,
    updated_at          timestamp(6) without time zone not null

);

ALTER TABLE ratings
    ADD CONSTRAINT FK_RATING_ON_POW FOREIGN KEY (place_of_worship_id) REFERENCES place_of_worship (id);
