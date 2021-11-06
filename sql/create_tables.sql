create table reminder
(
    id      bigint not null
        constraint reminder_pkey
            primary key,
    content varchar(255),
    subject varchar(255)
);
create sequence reminder_id_seq;

INSERT INTO reminder
values (1, "Take the pill", "Remember to take the pill");