create sequence hibernate_sequence start 1 increment 1
create table author (id int8 not null, first_name varchar(255), last_name varchar(255), primary key (id))
create table book (id int8 not null, isbn varchar(255), page_count int4 not null, title varchar(255), author_id int8 not null, primary key (id))
alter table if exists book add constraint FKklnrv3weler2ftkweewlky958 foreign key (author_id) references author
create sequence hibernate_sequence start 1 increment 1
create table author (id int8 not null, first_name varchar(255), last_name varchar(255), primary key (id))
create table book (id int8 not null, isbn varchar(255), page_count int4 not null, title varchar(255), author_id int8 not null, primary key (id))
alter table if exists book add constraint FKklnrv3weler2ftkweewlky958 foreign key (author_id) references author
