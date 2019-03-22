CREATE TABLE
    riskcheck_main
    (
        riskcheckno CHAR(22) NOT NULL,
        comcode CHAR(8) NOT NULL,
        checkmodel VARCHAR(3),
        insuredtype VARCHAR(1),
        insuredcode VARCHAR(30),
        insuredname VARCHAR(120),
        addressdetail VARCHAR(255),
        addresscode VARCHAR(6),
        businesssource VARCHAR(6),
        businessclass VARCHAR(2),
        unitnature VARCHAR(1),
        operatorcode VARCHAR(10),
        operatorcode_uni VARCHAR(10),
        undwrtsubmitdate DATE,
        underwriteflag VARCHAR(1),
        underwritedate DATE,
        underwritecode VARCHAR(10),
        underwritename VARCHAR(120),
        checkcomcode VARCHAR(8),
        checker VARCHAR(10),
        checkdate DATE,
        madedate datetime NULL DEFAULT NOW(),
        mobileflag CHAR(1) NOT NULL,
        highlightrisk TEXT,
        score DECIMAL(5,2),
        executionid VARCHAR(255),
        repulsesugggest VARCHAR(1000),
        pointx_2000 DECIMAL(20,15),
        pointy_2000 DECIMAL(20,15),
        pointx_02 DECIMAL(20,15),
        pointy_02 DECIMAL(20,15),
        inserttimeforhis  datetime NULL DEFAULT NOW(),
        operatetimeforhis  datetime NULL DEFAULT NOW(),
        addressprovince VARCHAR(30),
        addresscity VARCHAR(40),
        addresscounty VARCHAR(225),
        PRIMARY KEY (riskcheckno) 
    );
    
INSERT INTO riskcheck_main (riskcheckno, comcode, checkmodel, insuredtype, insuredcode, insuredname, addressdetail, addresscode, businesssource, businessclass, unitnature, operatorcode, operatorcode_uni, undwrtsubmitdate, underwriteflag, underwritedate, underwritecode, underwritename, checkcomcode, checker, checkdate, madedate, mobileflag, highlightrisk, score, executionid, repulsesugggest, pointx_2000, pointy_2000, pointx_02, pointy_02, inserttimeforhis, operatetimeforhis, addressprovince, addresscity, addresscounty) VALUES ('RX00200000000201900059', '00000000', '002', '2', '3800200000001318', '111', '222', '', '', '', '', '', null, null, 'T', null, '', '', '', '', str_to_date('2019-03-22', '%Y-%m-%d'), str_to_date('2019-03-22 14:17:23', '%Y-%m-%d %T'), ' ', '', 0.00, '', null, 115.035195312500000, 39.776845062500000, null, null, null, str_to_date('2019-03-22 15:08:07', '%Y-%m-%d %T'), 'hebei', 'zhangjiankou', 'zhuluxian');

CREATE TABLE
    riskcheck_assess
    (
        riskcheckno CHAR(22) NOT NULL,
        envdanger DECIMAL(5,2),
        impdanger DECIMAL(5,2),
        builddanger DECIMAL(5,2),
        cargodanger DECIMAL(5,2),
        typdanger DECIMAL(5,2),
        flooddanger DECIMAL(5,2),
        inserttimeforhis  datetime NULL DEFAULT NOW(),
        operatetimeforhis  datetime NULL DEFAULT NOW(),
        PRIMARY KEY (riskcheckno)
    );
    
INSERT INTO riskcheck_assess (riskcheckno, envdanger, impdanger, builddanger, cargodanger, typdanger, flooddanger, inserttimeforhis, operatetimeforhis) VALUES ('RX00200000000201900059', null, null, null, null, null, null, null, null);



