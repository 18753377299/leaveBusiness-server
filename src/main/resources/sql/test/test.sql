CREATE TABLE  dept
    (
        deptno Integer,
        dname VARCHAR(255),
        db_source VARCHAR(255),
         PRIMARY KEY (deptno)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    
  CREATE TABLE  account
    (
        accountId  Integer,
        deptId Integer,
        amount VARCHAR(255),
         PRIMARY KEY (accountId),
         constraint `fk` foreign key (`deptId`) references `dept`(`deptno`)      
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
