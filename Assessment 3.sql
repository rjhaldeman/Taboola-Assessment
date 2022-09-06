//Table to store product information for part a.
create table product
(name varchar(20),
category varchar(20),
date_added date,
author varchar(35))


//Table to store productprice information for part b.
create table productprice
(name varchar(20),
price dec(4,2),
discount_percent int(3) DEFAULT 0,
updated date,
author varchar(35))


//Table to store product price changes as outlined in part c.
create table productprice_audits
(   change_id int(20),
    price dec(4,2),
    discount_percent int(3) DEFAULT 0,
    updated date,
    author varchar(35),
    updated_at date NOT NULL,
    operation CHAR(3)  NOT NULL,
    CHECK(operation = 'INS' or operation='DEL' or operation = 'UPD')
)


//The best way I found to keep track of changes was to use a trigger to catch any INSERT DELETE or UPDATES called on the table productprice.
//I found that using a virtual table was the best way to accomplish this goal.
//Full transparency, I was unable to successfully implement this feature since the IDE I was using could not account for virtual tables.
//Below is my best guess for the SQL code that was meant to accomplish this.
CREATE TRIGGER log_price_changes
ON productprice
AFTER INSERT, DELETE, UPDATE
AS
BEGIN
    SET NOCOUNT ON;
    INSERT INTO productprice_audits(
        change_id, 
        price,
        discount_percent,
        updated,
        author, 
        updated_at, 
        operation)
    
    SELECT
        i.change_id,
        price,
        discount_percent,
        updated,
        author,
        CURRENT_TIMESTAMP,
        'INS'
    FROM
        inserted i
    UNION
    SELECT
        d.change_id,
        price,
        discount_percent,
        updated,
        author,
        CURRENT_TIMESTAMP,
        'DEL'
    FROM
        deleted d
    UNION
    SELECT
        d.change_id,
        price,
        discount_percent,
        updated,
        author,
        CURRENT_TIMESTAMP,
        'UPD',
        CHECK(i.change_id = NOT NULL and d.change_id = NOT NULL)
    FROM
        deleted d, inserted i;
END



//Here is some sample data added to the first two tables.
insert into product
    (name, category,date_added,author)
        values('Coffee Mug', 'Food and Drink', CURRENT_TIMESTAMP,'Riley'),
              ('Hairbrush', 'Bathroom', CURRENT_TIMESTAMP,'Riley'),
              ('Fork Set', 'Kitchen', CURRENT_TIMESTAMP,'Riley')
              
insert into productprice
        (name, price, discount_percent, updated, author)
        values ('Coffee Mug', 11.99, 0, CURRENT_TIMESTAMP,'Riley'),
        ('Hairbrush', 6.99, 0, CURRENT_TIMESTAMP,'Riley'),
        ('Fork Set', 17.99, 0, CURRENT_TIMESTAMP,'Riley')
        

//These are queries I used to help debug as I went about this project.
select * from product
select * from productprice
select * from productprice_audits

drop table product
drop table productprice
drop table productprice_audits



//Here we have a straightforward join query as requested from the end of problem 3.
select product.name, product.category, productprice.price, productprice.updated, productprice.author
from product
inner join productprice 
on productprice.name = product.name;




