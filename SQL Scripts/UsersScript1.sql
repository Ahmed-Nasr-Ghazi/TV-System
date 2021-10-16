
create database tv_security_noop;

CREATE TABLE IF NOT EXISTS tv_security_noop.channels (
  name VARCHAR(30) NOT NULL,
  url VARCHAR(60) NULL DEFAULT NULL,
  country VARCHAR(20) NULL DEFAULT NULL,
  status VARCHAR(7) NULL DEFAULT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;

insert into channels
values('cbc,','www.cbc.com','Egypt','active'),
('mbc,','www.mbc.com','KSA','Pending');


DROP TABLE IF EXISTS users;
CREATE TABLE users (
  email varchar(50) NOT NULL,
  username varchar(50) NOT NULL,
  password char(68) NOT NULL,
  phone varchar(10) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

alter table users modify enabled TINYINT NOT NULL DEFAULT 0;

INSERT INTO `users` 
VALUES 
('user@mail.com','user','{noop}test123','0000000000',0),
('test@mail.com','test','{noop}test123','0000000000',0),
('admin@mail.com','admin','{noop}test123','1111111111',1),
('ahmed@mail.com','ahmed','{noop}test123','1111111111',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE authorities (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL default 'ROLE_USER',
  UNIQUE KEY `authorities_idx_1` (`username`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO authorities
VALUES 
('user','ROLE_USER'),
('ahmed','ROLE_USER'),
('admin','ROLE_ADMIN');
