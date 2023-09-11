create table "comments"
(
    id         uuid primary key               not null,
    rating_id  uuid                           not null,
    comment    text,
    created_at timestamp(6) without time zone not null,
    updated_at timestamp(6) without time zone not null

);

ALTER TABLE comments
    ADD CONSTRAINT FK_COMMENT_ON_RATING FOREIGN KEY (rating_id) REFERENCES ratings (id);
