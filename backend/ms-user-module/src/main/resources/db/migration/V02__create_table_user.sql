create table user_tb (
    id varchar(50) primary key,
    email varchar(150) not null,
    password varchar(150) not null,
    status boolean default false,
    role_id varchar(50)  not null,
    created_by varchar(50),
    created_at timestamp default current_timestamp,
    updated_at timestamp default null,
    deleted_at timestamp default null,
    company_id varchar(50) not null,
    foreign key (role_id) references role_tb (id)
);

create table user_role_permission_tb (
    user_id varchar(50),
    role_id varchar(50),
    permission_id varchar(50),
    company_id varchar(50) not null,
    primary key(user_id, role_id, permission_id),
    foreign key (user_id) references user_tb (id),
    foreign key (role_id) references role_tb (id),
    foreign key (permission_id) references permission_tb (id)
);

