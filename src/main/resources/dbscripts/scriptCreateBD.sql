CREATE sequence USERS_SEQ;
CREATE sequence FLOWERS_SEQ;
CREATE sequence ROWS_ORDERS_SEQ;
CREATE sequence ORDERS_SEQ;
--------------------------------------------------------
--  DDL for Table Users
--------------------------------------------------------

  CREATE TABLE "Users"
   (	"IdUser" NUMBER(10,0) PRIMARY KEY,
        "Surname" VARCHAR2(45 CHAR) NOT NULL,
        "Name" VARCHAR2(45 CHAR) NOT NULL,
        "Patronymic" VARCHAR2(45 CHAR) NULL,
        "Address" VARCHAR2(45 CHAR) NOT NULL,
        "Cashbalance" NUMBER(10,2) NOT NULL,
        "Discount" NUMBER(3,0) NOT NULL,
        "Password" VARCHAR2(45 CHAR) NOT NULL
   );
--------------------------------------------------------
--  DDL for Table Flowers
--------------------------------------------------------

  CREATE TABLE "Flowers"
   (	"IdFlower" NUMBER(10,0) PRIMARY KEY,
        "NameFlower" VARCHAR2(45 CHAR) NOT NULL,
        "Balance" NUMBER(10,0) NOT NULL,
        "Price" NUMBER(10,2) NOT NULL,
   );
--------------------------------------------------------
--  DDL for Table RowsOrders
--------------------------------------------------------

  CREATE TABLE "RowsOrders"
   (	"IdRowOrder" NUMBER(10,0) PRIMARY KEY,
        "NameProduct" VARCHAR2(45 CHAR) NOT NULL,
        "Count" NUMBER(10) NOT NULL,
        "Price" NUMBER(10,2) NOT NULL,
   );
--------------------------------------------------------
--  DDL for Table Orders
--------------------------------------------------------

  CREATE TABLE "Orders"
   (
        "IdOrder" NUMBER(10,0) PRIMARY KEY,
        "Users_Id" NUMBER(10,0) NOT NULL,
        "Status" VARCHAR2(45 CHAR) NOT NULL,
        "Amount" NUMBER(10,2) NOT NULL,
        "DateCreate" TIMESTAMP NOT NULL,
        "DateClose" TIMESTAMP NULL,

        CONSTRAINT "Orders_Users_FK1" FOREIGN KEY ("Users_Id") REFERENCES "Users" ("IdUser")
   );

COMMIT;