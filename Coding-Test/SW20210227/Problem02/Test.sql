Create table customer(
    id int PRIMARY KEY,
    name varchar(64),
    birthday DATE,
    mileage int,
);

Insert into customer VALUES(1, "Elice", '15/01/2010', 100);
Insert into customer VALUES(2, "Cheshire", '10/03/2005', 100);
Insert into customer VALUES(3, "DOdo", '30/04/2010', 100);

SELECT * FROM customer
WHERE id == 1 OR id ==2;