create table IF NOT EXISTS TB_CUSTOMER
(
    ID_CUSTOMER INTEGER auto_increment,
    FIRSTNAME   CHARACTER VARYING(50) not null,
    LASTNAME    CHARACTER VARYING(50) not null,
    TELEPHONE   CHARACTER VARYING(20) not null,
    constraint TB_CUSTOMER_ID_CUSTOMER_PK
        primary key (ID_CUSTOMER)
);

create table IF NOT EXISTS TB_LK_SLOT_RESERVATION
(
    ID_LK_SLOT_RESERVATION INTEGER auto_increment,
    CODE                   CHARACTER VARYING(5) not null,
    DESCRIPTION            CHARACTER VARYING(50),
    constraint TB_LK_SLOT_RESERVATION_ID_LK_SLOT_RESERVATION_PK
        primary key (ID_LK_SLOT_RESERVATION)
);

create table IF NOT EXISTS TB_LK_STATUS_RESERVATION
(
    ID_LK_STATUS_RESERVATION INTEGER auto_increment,
    CODE                     CHARACTER VARYING(10) not null,
    DESCRIPTION              CHARACTER VARYING(50),
    constraint TB_LK_STATUS_RESERVATION_ID_LK_SLOT_RESERVATION_PK
        primary key (ID_LK_STATUS_RESERVATION)
);

create table IF NOT EXISTS TB_MANAGER
(
    ID_MANAGER INTEGER auto_increment,
    FIRSTNAME  CHARACTER VARYING(50) not null,
    LASTNAME   CHARACTER VARYING(50) not null,
    TELEPHONE  CHARACTER VARYING(20) not null,
    constraint TB_MANAGER_ID_MANAGER_PK
        primary key (ID_MANAGER)
);

create table IF NOT EXISTS TB_REHEARSAL_SPACE
(
    ID_REHEARSAL_SPACE INTEGER auto_increment,
    NAME               CHARACTER VARYING(50) not null,
    FK_MANAGER         INTEGER               not null,
    constraint TB_REHEARSAL_SPACE_ID_REHEARSAL_SPACE_PK
        primary key (ID_REHEARSAL_SPACE),
    constraint TB_REHEARSAL_SPACE_TB_MANAGER_ID_MANAGER_FK
        foreign key (FK_MANAGER) references TB_MANAGER
);

create table IF NOT EXISTS TB_RESERVATION
(
    ID_RESERVATION           INTEGER auto_increment,
    CODE                     CHARACTER VARYING(100) not null,
    RESERVATION_DATE         TIMESTAMP              not null,
    FK_CUSTOMER              INTEGER                not null,
    FK_REHEARSAL_SPACE       INTEGER                not null,
    FK_LK_SLOT_RESERVATION   INTEGER                not null,
    FK_LK_STATUS_RESERVATION INTEGER                not null,
    constraint TB_RESERVATION_ID_RESERVATION_PK
        primary key (ID_RESERVATION),
    constraint TB_RESERVATION_TB_CUSTOMER_ID_CUSTOMER_FK
        foreign key (FK_CUSTOMER) references TB_CUSTOMER,
    constraint TB_RESERVATION_TB_LK_SLOT_RESERVATION_ID_LK_SLOT_RESERVATION_FK
        foreign key (FK_LK_SLOT_RESERVATION) references TB_LK_SLOT_RESERVATION,
    constraint TB_RESERVATION_TB_LK_STATUS_RESERVATION_ID_LK_STATUS_RESERVATION_FK
        foreign key (FK_LK_STATUS_RESERVATION) references TB_LK_STATUS_RESERVATION,
    constraint TB_RESERVATION_TB_REHEARSAL_SPACE_ID_REHEARSAL_SPACE_FK
        foreign key (FK_REHEARSAL_SPACE) references TB_REHEARSAL_SPACE
);

