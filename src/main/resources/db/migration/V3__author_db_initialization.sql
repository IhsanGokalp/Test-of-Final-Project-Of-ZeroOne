create table tblauthors(
    author_id bigserial primary key,
    firstName varchar,
    lastName varchar,
    birthDate date,
    deathDate date,
    bibliography text
);

alter table tblbooks drop column author;

alter table tblbooks add column author_id bigint references tblauthors;