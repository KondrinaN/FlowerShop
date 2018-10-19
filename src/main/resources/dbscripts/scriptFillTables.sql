Insert into Users (IdUser, Surname, Name, Patronymic, Address, Cashbalance, Discount, Password) values (USERS_SEQ.NEXTVAL, 'Surname1', 'Name1','Patronymic1','Address1', 12000, 30, "k��x_۠ZdF4}��");
Insert into Users (IdUser, Surname, Name, Patronymic, Address, Cashbalance, Discount, Password) values (USERS_SEQ.NEXTVAL, 'Surname2', 'Name2','Patronymic2','Address2', 22000, 0, "����9��M����X*");;

Insert into Flowers (IdFlower, NameFlower, Balance, Price) values (FLOWERS_SEQ.NEXTVAL, 'NameFlower1', 15, 120);
Insert into Flowers (IdFlower, NameFlower, Balance, Price) values (FLOWERS_SEQ.NEXTVAL, 'NameFlower2', 35, 70);
Insert into Flowers (IdFlower, NameFlower, Balance, Price) values (FLOWERS_SEQ.NEXTVAL, 'NameFlower3', 0, 90);
Insert into Flowers (IdFlower, NameFlower, Balance, Price) values (FLOWERS_SEQ.NEXTVAL, 'NameFlower4', 2, 150);
Insert into Flowers (IdFlower, NameFlower, Balance, Price) values (FLOWERS_SEQ.NEXTVAL, 'NameFlower5', 10, 100);

Insert into RowsOrders (IdRowOrder, NameProduct, Count, Price) values (ROWS_ORDERS_SEQ.NEXTVAL, 'NameProduct1', 3, 35);
Insert into RowsOrders (IdRowOrder, NameProduct, Count, Price) values (ROWS_ORDERS_SEQ.NEXTVAL, 'NameProduct2', 4, 120);
Insert into RowsOrders (IdRowOrder, NameProduct, Count, Price) values (ROWS_ORDERS_SEQ.NEXTVAL, 'NameProduct3', 1, 150);
Insert into RowsOrders (IdRowOrder, NameProduct, Count, Price) values (ROWS_ORDERS_SEQ.NEXTVAL, 'NameProduct4', 20, 100);

Insert into Orders (IdOrder, Users_Id, Status, Amount, DateCreate, DateClose) values (ORDERS_SEQ.NEXTVAL, 1, "закрыт");
Insert into Orders (IdOrder, Users_Id, Status, Amount, DateCreate, DateClose) values (ORDERS_SEQ.NEXTVAL, 2, "оплачен");
Insert into Orders (IdOrder, Users_Id, Status, Amount, DateCreate, DateClose) values (ORDERS_SEQ.NEXTVAL, 3, "оплачен");
Insert into Orders (IdOrder, Users_Id, Status, Amount, DateCreate, DateClose) values (ORDERS_SEQ.NEXTVAL, 4, "создан");

COMMIT;