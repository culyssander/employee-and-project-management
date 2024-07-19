create table role_tb (
    id varchar(50) primary key,
    name varchar(50) not null,
    company_id varchar(50) not null
);

create table permission_tb (
    id varchar(50) primary key,
    name varchar(50) not null,
    description varchar(200) null,
    company_id varchar(50) not null
);

create table role_permission_tb (
    role_id varchar(50),
    permission_id varchar(50),
    company_id varchar(50) not null,
    primary key(role_id, permission_id),
    foreign key (role_id) references role_tb (id),
    foreign key (permission_id) references permission_tb (id)
);
