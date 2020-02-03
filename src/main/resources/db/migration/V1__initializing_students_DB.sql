create table tblstudents(
    id bigserial primary key,
    first_name varchar,
    surname varchar,
    university_id varchar unique
);