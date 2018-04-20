/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  juan
 * Created: Apr 16, 2018
 */

create table vote(
    id int primary key,
    candidate varchar(25)
);

create table votation(
    id int default -1,
    candidate1 int,
    candidate2 int
);

create table subscribed(
    URL varchar(100) primary key
)