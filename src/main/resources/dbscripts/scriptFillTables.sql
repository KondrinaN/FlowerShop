CREATE sequence USERS_SEQ;
CREATE sequence FLOWERS_SEQ;
CREATE sequence ROWS_ORDERS_SEQ;
CREATE sequence ORDERS_SEQ;
--------------------------------------------------------
Insert into Users ("IdUser", "Surname", "Name", "Patronymic", "Address", "Cashbalance", "Discount", "Password") values (USERS_SEQ.NEXTVAL, 'Surname1', 'Name1','Patronymic1','Address1', 12000, 30, 'k��x_۠ZdF4}��');
Insert into Users ("IdUser", "Surname", "Name", "Patronymic", "Address", "Cashbalance", "Discount", "Password") values (USERS_SEQ.NEXTVAL, 'Surname2', 'Name2','Patronymic2','Address2', 22000, 0, '����9��M����X*');;

Insert into Flowers ("IdFlower", "NameFlower", "Balance", "Price") values (FLOWERS_SEQ.NEXTVAL, 'NameFlower1', 15, 120);
Insert into Flowers ("IdFlower", "NameFlower", "Balance", "Price") values (FLOWERS_SEQ.NEXTVAL, 'NameFlower2', 35, 70);
Insert into Flowers ("IdFlower", "NameFlower", "Balance", "Price") values (FLOWERS_SEQ.NEXTVAL, 'NameFlower3', 0, 90);
Insert into Flowers ("IdFlower", "NameFlower", "Balance", "Price") values (FLOWERS_SEQ.NEXTVAL, 'NameFlower4', 2, 150);
Insert into Flowers ("IdFlower", "NameFlower", "Balance", "Price") values (FLOWERS_SEQ.NEXTVAL, 'NameFlower5', 10, 100);

Insert into Orders ("IdOrder", "Users_Id", "Status", "Amount", "DateCreate", "DateClose") values (ORDERS_SEQ.NEXTVAL, 1, 'закрыт', 5, to_date('2018-09-22 11:00:00', 'YYYY-MM-DD hh:mm:ss'), to_date('2018-09-25 10:00:00', 'YYYY-MM-DD hh:mm:ss'));
Insert into Orders ("IdOrder", "Users_Id", "Status", "Amount", "DateCreate", "DateClose") values (ORDERS_SEQ.NEXTVAL, 2, 'оплачен', 10, to_date('2018-09-27 12:00:00', 'YYYY-MM-DD hh:mm:ss'), to_date('2018-10-01 08:00:00', 'YYYY-MM-DD hh:mm:ss'));
Insert into Orders ("IdOrder", "Users_Id", "Status", "Amount", "DateCreate", "DateClose") values (ORDERS_SEQ.NEXTVAL, 2, 'оплачен', 3, to_date('2018-10-01 10:00:00', 'YYYY-MM-DD hh:mm:ss'), to_date('2018-10-12 09:00:00', 'YYYY-MM-DD hh:mm:ss'));
Insert into Orders ("IdOrder", "Users_Id", "Status", "Amount", "DateCreate", "DateClose") values (ORDERS_SEQ.NEXTVAL, 1, 'создан', 12, to_date('2018-10-03 11:00:00', 'YYYY-MM-DD hh:mm:ss'), to_date('2018-10-05 11:00:00', 'YYYY-MM-DD hh:mm:ss'));

Insert into RowsOrders ("IdRowOrder", "Order_Id", "NameProduct", "Count", "Price") values (ROWS_ORDERS_SEQ.NEXTVAL, 2, 'NameProduct1', 3, 35);
Insert into RowsOrders ("IdRowOrder", "Order_Id", "NameProduct", "Count", "Price") values (ROWS_ORDERS_SEQ.NEXTVAL, 3, 'NameProduct2', 4, 120);
Insert into RowsOrders ("IdRowOrder", "Order_Id", "NameProduct", "Count", "Price") values (ROWS_ORDERS_SEQ.NEXTVAL, 1, 'NameProduct3', 1, 150);
Insert into RowsOrders ("IdRowOrder", "Order_Id", "NameProduct", "Count", "Price") values (ROWS_ORDERS_SEQ.NEXTVAL, 4, 'NameProduct4', 20, 100);



COMMIT;