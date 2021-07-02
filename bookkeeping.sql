drop
table if exists member_balance;

drop 
table if exists flow;

drop 
table if exists division_balance;

drop 
table if exists category_balance;

drop 
table if exists card_balance;

drop table if exists bill;

drop table if exists card;

drop table if exists category;

drop table if exists division;

drop table if exists member;

drop table if exists usr;

create table bill
(
   b_id                 bigint not null auto_increment,
   c_id                 int not null,
   m_id                 int not null,
   ca_id                int not null,
   b_price              decimal not null,
   b_type               numeric(1,0) not null,
   b_time               timestamp not null,
   primary key (b_id)
);

create table card
(
   c_id                 int not null auto_increment,
   u_id                 int not null,
   c_name               varchar(20) not null,
   primary key (c_id)
);

create table category
(
   ca_id                int not null auto_increment,
   d_id                 int not null,
   ca_name              varchar(10) not null,
   primary key (ca_id)
);

create table division
(
   d_id                 int not null auto_increment,
   u_id                 int not null,
   d_name               varchar(10) not null,
   primary key (d_id)
);

create table member
(
   m_id                 int not null auto_increment,
   u_id                 int not null,
   m_name               varchar(10) not null,
   primary key (m_id)
);

create table usr
(
   u_id                 int not null auto_increment,
   u_name               varchar(20) not null,
   u_password           char(44) not null,
   u_salt               char(44) not null,
   primary key (u_id)
);

create VIEW  card_balance
 as
select card.c_id,c_name,u_id,b_id,b_price,b_type,b_time from card,bill 
where card.c_id=bill.c_id;

create VIEW  category_balance
 as
select category.ca_id,ca_name,d_id,b_id,b_price,b_type,b_time from
category,bill where category.ca_id=bill.ca_id;

create VIEW  division_balance
 as
select division.d_id,d_name,u_id,category.ca_id,b_id,b_price,b_type,
b_time from division,category,bill where division.d_id=category.d_id 
and category.ca_id=bill.ca_id;

create VIEW  flow
 as
select b_id,card.u_id,c_name,m_name,ca_name,d_name,b_price,b_type,
b_time from bill,card,member,category,division where bill.c_id=card.c_id 
and bill.m_id=member.m_id and bill.ca_id=category.ca_id 
and category.d_id=division.d_id;

create VIEW  member_balance
 as
select member.m_id,m_name,u_id,b_id,b_price,b_type,b_time from member,bill
where member.m_id=bill.m_id;

alter table bill add constraint FK_card_bill foreign key (c_id)
      references card (c_id) on delete restrict on update restrict;

alter table bill add constraint FK_category_bill foreign key (ca_id)
      references category (ca_id) on delete restrict on update restrict;

alter table bill add constraint FK_member_bill foreign key (m_id)
      references member (m_id) on delete restrict on update restrict;

alter table card add constraint FK_user_card foreign key (u_id)
      references usr (u_id) on delete restrict on update restrict;

alter table category add constraint FK_division_category foreign key (d_id)
      references division (d_id) on delete restrict on update restrict;

alter table division add constraint FK_usr_division foreign key (u_id)
      references usr (u_id) on delete restrict on update restrict;

alter table member add constraint FK_usr_member foreign key (u_id)
      references usr (u_id) on delete restrict on update restrict;