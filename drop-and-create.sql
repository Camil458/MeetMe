
    alter table event 
       drop 
       foreign key FKi8bsvlthqr8lngsyshiqsodak;

    alter table verification_token 
       drop 
       foreign key FKrdn0mss276m9jdobfhhn2qogw;

    drop table if exists event;

    drop table if exists user;

    drop table if exists verification_token;

    create table event (
       id bigint not null auto_increment,
        date varchar(255),
        description varchar(255),
        lat float(53) not null,
        link varchar(255),
        lng float(53) not null,
        location varchar(255),
        photo_link varchar(255),
        ticket_info varchar(255),
        title varchar(255),
        user_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled bit,
        first_name varchar(255),
        last_name varchar(255),
        locked bit,
        password varchar(255),
        role varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table verification_token (
       id bigint not null auto_increment,
        expiry_date datetime(6) not null,
        token varchar(255) not null,
        user_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    alter table event 
       add constraint FKi8bsvlthqr8lngsyshiqsodak 
       foreign key (user_id) 
       references user (id);

    alter table verification_token 
       add constraint FKrdn0mss276m9jdobfhhn2qogw 
       foreign key (user_id) 
       references user (id);

    alter table event 
       drop 
       foreign key FKi8bsvlthqr8lngsyshiqsodak;

    alter table verification_token 
       drop 
       foreign key FKrdn0mss276m9jdobfhhn2qogw;

    drop table if exists event;

    drop table if exists user;

    drop table if exists verification_token;

    create table event (
       id bigint not null auto_increment,
        date varchar(255),
        description varchar(255),
        lat float(53) not null,
        link varchar(255),
        lng float(53) not null,
        location varchar(255),
        photo_link varchar(255),
        ticket_info varchar(255),
        title varchar(255),
        user_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled bit,
        first_name varchar(255),
        last_name varchar(255),
        locked bit,
        password varchar(255),
        role varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table verification_token (
       id bigint not null auto_increment,
        expiry_date datetime(6) not null,
        token varchar(255) not null,
        user_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    alter table event 
       add constraint FKi8bsvlthqr8lngsyshiqsodak 
       foreign key (user_id) 
       references user (id);

    alter table verification_token 
       add constraint FKrdn0mss276m9jdobfhhn2qogw 
       foreign key (user_id) 
       references user (id);

    alter table event 
       drop 
       foreign key FKi8bsvlthqr8lngsyshiqsodak;

    alter table verification_token 
       drop 
       foreign key FKrdn0mss276m9jdobfhhn2qogw;

    drop table if exists event;

    drop table if exists user;

    drop table if exists verification_token;

    create table event (
       id bigint not null auto_increment,
        date varchar(255),
        description varchar(255),
        lat float(53) not null,
        link varchar(255),
        lng float(53) not null,
        location varchar(255),
        photo_link varchar(255),
        ticket_info varchar(255),
        title varchar(255),
        user_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled bit,
        first_name varchar(255),
        last_name varchar(255),
        locked bit,
        password varchar(255),
        role varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table verification_token (
       id bigint not null auto_increment,
        expiry_date datetime(6) not null,
        token varchar(255) not null,
        user_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    alter table event 
       add constraint FKi8bsvlthqr8lngsyshiqsodak 
       foreign key (user_id) 
       references user (id);

    alter table verification_token 
       add constraint FKrdn0mss276m9jdobfhhn2qogw 
       foreign key (user_id) 
       references user (id);

    alter table event 
       drop 
       foreign key FKi8bsvlthqr8lngsyshiqsodak;

    alter table verification_token 
       drop 
       foreign key FKrdn0mss276m9jdobfhhn2qogw;

    drop table if exists event;

    drop table if exists user;

    drop table if exists verification_token;

    create table event (
       id bigint not null auto_increment,
        date varchar(255),
        description varchar(255),
        lat float(53) not null,
        link varchar(255),
        lng float(53) not null,
        location varchar(255),
        photo_link varchar(255),
        ticket_info varchar(255),
        title varchar(255),
        user_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled bit,
        first_name varchar(255),
        last_name varchar(255),
        locked bit,
        password varchar(255),
        role varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table verification_token (
       id bigint not null auto_increment,
        expiry_date datetime(6) not null,
        token varchar(255) not null,
        user_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    alter table event 
       add constraint FKi8bsvlthqr8lngsyshiqsodak 
       foreign key (user_id) 
       references user (id);

    alter table verification_token 
       add constraint FKrdn0mss276m9jdobfhhn2qogw 
       foreign key (user_id) 
       references user (id);

    alter table event 
       drop 
       foreign key FKi8bsvlthqr8lngsyshiqsodak;

    alter table verification_token 
       drop 
       foreign key FKrdn0mss276m9jdobfhhn2qogw;

    drop table if exists event;

    drop table if exists user;

    drop table if exists verification_token;

    create table event (
       id bigint not null auto_increment,
        date varchar(255),
        description varchar(255),
        lat float(53) not null,
        link varchar(255),
        lng float(53) not null,
        location varchar(255),
        photo_link varchar(255),
        ticket_info varchar(255),
        title varchar(255),
        user_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled bit,
        first_name varchar(255),
        last_name varchar(255),
        locked bit,
        password varchar(255),
        role varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table verification_token (
       id bigint not null auto_increment,
        expiry_date datetime(6) not null,
        token varchar(255) not null,
        user_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    alter table event 
       add constraint FKi8bsvlthqr8lngsyshiqsodak 
       foreign key (user_id) 
       references user (id);

    alter table verification_token 
       add constraint FKrdn0mss276m9jdobfhhn2qogw 
       foreign key (user_id) 
       references user (id);

    alter table event 
       drop 
       foreign key FKi8bsvlthqr8lngsyshiqsodak;

    alter table verification_token 
       drop 
       foreign key FKrdn0mss276m9jdobfhhn2qogw;

    drop table if exists event;

    drop table if exists user;

    drop table if exists verification_token;

    create table event (
       id bigint not null auto_increment,
        date varchar(255),
        description varchar(255),
        lat float(53) not null,
        link varchar(255),
        lng float(53) not null,
        location varchar(255),
        photo_link varchar(255),
        ticket_info varchar(255),
        title varchar(255),
        user_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled bit,
        first_name varchar(255),
        last_name varchar(255),
        locked bit,
        password varchar(255),
        role varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table verification_token (
       id bigint not null auto_increment,
        expiry_date datetime(6) not null,
        token varchar(255) not null,
        user_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    alter table event 
       add constraint FKi8bsvlthqr8lngsyshiqsodak 
       foreign key (user_id) 
       references user (id);

    alter table verification_token 
       add constraint FKrdn0mss276m9jdobfhhn2qogw 
       foreign key (user_id) 
       references user (id);
