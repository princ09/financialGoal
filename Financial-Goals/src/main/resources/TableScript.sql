create database financial_goals;
use  financial_goals;

create table goals(
goal_id int auto_increment not null primary key,
goal_name varchar(20),
goal_decs varchar(50),
goal_target_price int,
goal_completed char(1) default 'N'
);
create table goal_savings(
saving_id int auto_increment primary key,
saving_name varchar(20),
saving_value int,
saving_goal_id int,
constraint fk_goal_id foreign key (saving_goal_id) references goals(goal_id)
);
