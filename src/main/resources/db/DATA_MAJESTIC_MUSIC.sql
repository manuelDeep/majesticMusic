INSERT INTO TB_LK_STATUS_RESERVATION (CODE, DESCRIPTION)
VALUES ('P', 'Pending');

INSERT INTO TB_LK_STATUS_RESERVATION (CODE, DESCRIPTION)
VALUES ('A', 'Accepted');

INSERT INTO TB_LK_STATUS_RESERVATION (CODE, DESCRIPTION)
VALUES ('R', 'Refused');




INSERT INTO TB_LK_SLOT_RESERVATION (CODE, DESCRIPTION)
VALUES ('M', 'Morning');

INSERT INTO TB_LK_SLOT_RESERVATION (CODE, DESCRIPTION)
VALUES ('A', 'Afternoon');

INSERT INTO TB_LK_SLOT_RESERVATION (CODE, DESCRIPTION)
VALUES ('E', 'Evening');




INSERT INTO TB_CUSTOMER (FIRSTNAME, LASTNAME, TELEPHONE)
VALUES ('Manuel', 'De Paduanis', '3287146683');

INSERT INTO TB_CUSTOMER (FIRSTNAME, LASTNAME, TELEPHONE)
VALUES ('Michael', 'Phelps', '3334785632');





INSERT INTO TB_MANAGER (FIRSTNAME, LASTNAME, TELEPHONE)
VALUES ('Andrew', 'Robertson', '3698562356');

INSERT INTO TB_MANAGER (FIRSTNAME, LASTNAME, TELEPHONE)
VALUES ('Edgar', 'Vass', '3201458965');

INSERT INTO TB_MANAGER (FIRSTNAME, LASTNAME, TELEPHONE)
VALUES ('Sharon', 'Stone', '1784565230');





INSERT INTO TB_REHEARSAL_SPACE (NAME, FK_MANAGER)
VALUES ('Dancing', 1);

INSERT INTO TB_REHEARSAL_SPACE (NAME, FK_MANAGER)
VALUES ('Zumba', 3);

INSERT INTO TB_REHEARSAL_SPACE (NAME, FK_MANAGER)
VALUES ('Karate', 2);

