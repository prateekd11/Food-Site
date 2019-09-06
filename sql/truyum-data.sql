use truyum;

insert into menu_item(me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery) 
            values('Sandwich',99.00,'Yes','2017-03-15','Main Course','Yes') ,
            ('Burger',129.00,'Yes','2019-12-23','Main Course','No'),
            ('Pizza',149.00,'Yes','2018-08-21','Main Course','No'),
            ('French Fries',57.00,'No','2017-07-02','Starters','Yes'),
            ('Chocolate Brownie',32.00,'Yes','2022-11-02','Dessert','Yes');

     
select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from menu_item;

select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from menu_item where me_active = 'Yes' and me_date_of_launch <= curdate();

select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from menu_item where me_id=1;

update menu_item set me_active='No' , me_category='Starters' where me_id=1;

insert into user(us_name) values('USER1') , ('USER2');

insert into cart(ct_us_id,ct_pr_id) values(1,1) , (1,2) , (1,3);

select m.me_name,m.me_free_delivery,m.me_price from menu_item as m, cart as c 
where c.ct_us_id = 1 and m.me_id = c.ct_pr_id;


select sum(m.me_price) as Total from menu_item as m,cart as c where c.ct_us_id=1 and m.me_id=c.ct_pr_id;

delete from cart where ct_us_id = 1 and ct_pr_id = 1;