# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table task (
  id                            bigint auto_increment not null,
  title                         varchar(255) not null,
  done                          boolean default false not null,
  constraint pk_task primary key (id)
);


# --- !Downs

drop table if exists task;

