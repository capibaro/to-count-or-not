create table bill
(
   b_id                 bigint not null auto_increment,
   c_id                 int not null,
   m_id                 int not null,
   ca_id                int not null,
   b_price              decimal not null,
   b_type               numeric(1,0) not null,
   b_time               timestamp not null,
   primary key (b_id),
   key (c_id),
   key (ca_id),
   key (m_id),
   key (b_type, b_time)
);

create table card
(
   c_id                 int not null auto_increment,
   u_id                 int not null,
   c_name               varchar(20) not null,
   primary key (c_id),
   key (u_id)
);

create table category
(
   ca_id                int not null auto_increment,
   d_id                 int not null,
   ca_name              varchar(10) not null,
   primary key (ca_id),
   key (d_id)
);

create table division
(
   d_id                 int not null auto_increment,
   u_id                 int not null,
   d_name               varchar(10) not null,
   primary key (d_id),
   key (u_id)
);

create table member
(
   m_id                 int not null auto_increment,
   u_id                 int not null,
   m_name               varchar(10) not null,
   primary key (m_id),
   key (u_id)
);

create table usr
(
   u_id                 int not null auto_increment,
   u_name               varchar(20) not null,
   u_password           char(44) not null,
   u_salt               char(44) not null,
   primary key (u_id),
   key (u_name)
);

create VIEW  card_balance
as
select c_id,c_name,u_id,b_id,b_price,b_type,b_time from bill inner join card using(c_id);

create VIEW  category_balance
 as
select ca_id,ca_name,d_id,b_id,b_price,b_type,b_time from bill inner join category using(ca_id);

create VIEW  division_balance
 as
select d_id,d_name,u_id,b_id,b_price,b_type,b_time from bill inner join category using(ca_id) inner join division using(d_id);

create VIEW  member_balance
 as
select m_id,m_name,u_id,b_id,b_price,b_type,b_time from bill inner join member using(m_id);

create VIEW  flow
as
select b_id,ca_name,d_name,u_id,b_price,b_type,b_time from bill inner join category using(ca_id) inner join division using(d_id);