drop database bugsDb;
create DATABASE IF NOT EXISTS bugsDb;
USE bugsDb;


create table if not exists employee
(idEmployee int unique auto_increment primary key,
name varchar(25),
username varchar(12),
password varchar(15))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

create table if not exists product
(idProduct int unique auto_increment primary key,
name varchar(20),
description varchar(100),
finished int)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

create table if not exists bug
(idBug int unique auto_increment primary key,
description varchar(100),
screenshot varchar(20),
tag varchar(20),
statusBug int,
priority varchar(10),
registeredBy int,
assignedTo int,
idProduct int,
foreign key(registeredBy) references employee(idEmployee),
foreign key(idProduct) references product(idProduct),
foreign key(assignedTo) references employee(idEmployee))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

create table if not exists comment_thread
(idComm int unique auto_increment primary key,
message varchar(200),
idEmployee int,
idBug int,
foreign key(idEmployee) references employee(idEmployee),
foreign key(idBug) references bug(idBug))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO `employee` (`idEmployee`, `name`, `username`, `password`) VALUES
(1, 'Matei Andrei', 'mateiandrei', '123456'),
(2, 'Saul Goodman', 'jimmy', 'bcs123'),
(3, 'John Doe', 'jdoe', 'nobugspls');

INSERT INTO `product` (`idProduct`, `name`,`description`, `finished`) VALUES
(1, 'Product One',"Description for product one",1),
(2, 'Product Two',"Description for product two",0),
(3, 'Product Three',"No description yet",0);


INSERT INTO `bug` (`idBug`, `description`, `screenshot`, `tag`, `statusBug`, `priority`, `registeredBy`, `assignedTo`, `idProduct`) VALUES
(1, 'Login button crashes if pressed twice', '-', 'functional', 1, 'high', 1, 2, 2),
(2, 'Credit card payment not working.', 'ss.png', 'functional', 1, 'high', 3, 1, 2);


INSERT INTO `comment_thread` (`idComm`, `message`, `idEmployee`, `idBug`) VALUES
(1, 'How did this happen?', 2, 2),
(2, 'Beats me.', 1, 2);




