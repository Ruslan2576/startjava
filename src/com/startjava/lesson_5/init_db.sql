
\c
drop table if exists jaegers;
create table jaegers (
    id              serial not null primary key,
    model_name      text not null,
    mark            char(6) not null,
    height          numeric not null,
    weight          numeric not null,
    status          text not null,
    origin          text not null,
    launch          date not null,
    kaiju_kill      integer not null
);

\i populate.sql
\i queries.sql