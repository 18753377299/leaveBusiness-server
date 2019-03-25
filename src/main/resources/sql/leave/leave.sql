CREATE TABLE
    leave_basic
    (
        id INT NOT NULL AUTO_INCREMENT,
        jobNum VARCHAR(6),
        employeeName VARCHAR(60),
        teamCode VARCHAR(6),
        teamName VARCHAR(120),
        projectCode VARCHAR(6),
        projectName VARCHAR(120),
        annualDay TINYINT,
        usedAnnualDay TINYINT,
        retreatDay TINYINT,
        usedRetreatDay TINYINT,
        sickDay TINYINT,
        usedSickDay TINYINT,
        insertTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP,
        operateTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
CREATE TABLE
    leave_main
    (
        id INT NOT NULL AUTO_INCREMENT,
        jobNum VARCHAR(6) NOT NULL,
        employeeName VARCHAR(60) NOT NULL,
        teamCode VARCHAR(6),
        teamName VARCHAR(120),
        projectCode VARCHAR(6),
        projectName VARCHAR(120),
        leaveType VARCHAR(1) NOT NULL,
        detailDesc text,
        startTime DATE,
        endTime DATE,
        sumDay INT,
        insertTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP,
        operateTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
CREATE TABLE
    leave_person
    (
        id INT NOT NULL AUTO_INCREMENT,
        usercode VARCHAR(10),
        username VARCHAR(255) NOT NULL,
        annual_leave INT,
        flag VARCHAR(255) NOT NULL,
        department_id INT,
        department_name VARCHAR(255) NOT NULL,
        team_id INT,
        team_name VARCHAR(255) NOT NULL,
        leavedate DATE,
        insertTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP,
        operateTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    CREATE TABLE
    leave_travel
    (
        id INT NOT NULL AUTO_INCREMENT,
        jobNum VARCHAR(6) COLLATE utf8_unicode_ci NOT NULL,
        employeeName VARCHAR(60) COLLATE utf8_unicode_ci NOT NULL,
        teamCode VARCHAR(6) COLLATE utf8_unicode_ci,
        teamName VARCHAR(120) COLLATE utf8_unicode_ci,
        projectCode VARCHAR(6) COLLATE utf8_unicode_ci,
        projectName VARCHAR(120) COLLATE utf8_unicode_ci,
        travelType VARCHAR(1) COLLATE utf8_unicode_ci NOT NULL,
        travelSite VARCHAR(120) COLLATE utf8_unicode_ci,
        travelDesc VARCHAR(250) COLLATE utf8_unicode_ci,
        startTime DATE,
        endTime DATE,
        travelDay FLOAT,
        insertTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP,
        operateTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    
    
    