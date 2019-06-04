create table bill
(
    order_id varchar(32)         not null
        primary key,
    amount   decimal default '0' null
)
    comment '订单表';

create table product
(
    id           varchar(32) not null
        primary key,
    product_name varchar(32) null
)
    comment '产品表';

