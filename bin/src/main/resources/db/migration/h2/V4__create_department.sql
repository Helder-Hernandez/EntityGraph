create table department (id bigint generated by default as identity, name varchar(255), company_id bigint, primary key (id));

alter table department add constraint FKh1m88q0f7sc0mk76kju4kcn6f foreign key (company_id) references company;