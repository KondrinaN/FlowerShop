
--------------------------------------------------------
Insert into Users ("Login", "Surname", "Name", "Patronymic", "Address", "Cashbalance", "Discount", "Password", "UserRole") values ('User1', 'Surname1', 'Name1','Patronymic1','Address1', 12000, 30, 'User1', 1);
Insert into Users ("Login", "Surname", "Name", "Patronymic", "Address", "Cashbalance", "Discount", "Password", "UserRole") values ('User2', 'Surname2', 'Name2','Patronymic2','Address2', 22000, 0, 'User2', 1);;
Insert into Users ("Login", "Surname", "Name", "Patronymic", "Address", "Cashbalance", "Discount", "Password", "UserRole") values ('admin', '', '','','', 0, 0, 'admin123', 0);


Insert into Flowers ("NameFlower", "Balance", "Price", "FlowerAvailability") values ('NameFlower1', 15, 120, 0);
Insert into Flowers ("NameFlower", "Balance", "Price", "FlowerAvailability") values ('NameFlower2', 35, 70, 1);
Insert into Flowers ("NameFlower", "Balance", "Price", "FlowerAvailability") values ('NameFlower3', 0, 90, 0);
Insert into Flowers ("NameFlower", "Balance", "Price", "FlowerAvailability") values ('NameFlower4', 2, 150, 1);
Insert into Flowers ("NameFlower", "Balance", "Price", "FlowerAvailability") values ('NameFlower5', 10, 100, 0);

Insert into Orders ("Users_Id", "Status", "Amount", "DateCreate", "DateClose") values (1, 0, 5, to_date('2018-09-22 11:00:00', 'YYYY-MM-DD hh:mm:ss'), to_date('2018-09-25 10:00:00', 'YYYY-MM-DD hh:mm:ss'));
Insert into Orders ("Users_Id", "Status", "Amount", "DateCreate", "DateClose") values (2, 1, 10, to_date('2018-09-27 12:00:00', 'YYYY-MM-DD hh:mm:ss'), to_date('2018-10-01 08:00:00', 'YYYY-MM-DD hh:mm:ss'));
Insert into Orders ("Users_Id", "Status", "Amount", "DateCreate", "DateClose") values (2, 1, 3, to_date('2018-10-01 10:00:00', 'YYYY-MM-DD hh:mm:ss'), to_date('2018-10-12 09:00:00', 'YYYY-MM-DD hh:mm:ss'));
Insert into Orders ("Users_Id", "Status", "Amount", "DateCreate", "DateClose") values (1, 2, 12, to_date('2018-10-03 11:00:00', 'YYYY-MM-DD hh:mm:ss'), to_date('2018-10-05 11:00:00', 'YYYY-MM-DD hh:mm:ss'));

Insert into RowsOrders ("Order_Id", "NameProduct", "Count", "Price") values (2, 'NameProduct1', 3, 35);
Insert into RowsOrders ("Order_Id", "NameProduct", "Count", "Price") values (3, 'NameProduct2', 4, 120);
Insert into RowsOrders ("Order_Id", "NameProduct", "Count", "Price") values (1, 'NameProduct3', 1, 150);
Insert into RowsOrders ("Order_Id", "NameProduct", "Count", "Price") values (4, 'NameProduct4', 20, 100);

COMMIT;