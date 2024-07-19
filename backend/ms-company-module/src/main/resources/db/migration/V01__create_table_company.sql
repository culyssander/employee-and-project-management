create table company_tb (
    id varchar(50) primary key,
    name varchar(100) not null unique,
    email varchar(150),
    phone varchar(25),
    address varchar(150),
    city varchar(25),
    status boolean default true,
    zip varchar(10),
    image_url varchar(500),
    notes varchar(300),
    about varchar(1000),
    created_by varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default null
);