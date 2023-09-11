--
-- Place of Worship Table
--
create table "place_of_worship"
(
    id         uuid primary key not null,
    name       varchar(256)     not null,
    type       varchar(256)     not null,
    website    varchar(256),
    created_at timestamp(6) without time zone not null,
    updated_at timestamp(6) without time zone not null

);
