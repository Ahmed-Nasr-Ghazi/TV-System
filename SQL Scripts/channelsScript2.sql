


CREATE TABLE channels (
  name VARCHAR(30) NOT NULL,
  url VARCHAR(60) NULL DEFAULT NULL,
  country VARCHAR(20) NULL DEFAULT NULL,
  status VARCHAR(7) NULL DEFAULT NULL,
  PRIMARY KEY (`name`)
);

insert into channels
values(
('cbc','www.cbc.com','Egypt','active'),
('mbc','www.mbc.com','KSA','pending')
);