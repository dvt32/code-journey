/*

Условия за курсовата задача по БД.

Да се направи база от данни - релационна или обектно-ориентирана, върху предварително зададената предметна област.
За обектно ориентирана база ще има бонус 0.5 върху крайната оценка.
Задължителни условия в случай, че базата е релационна - да има структурен тип от данни ИЛИ XML данни в поне една от таблиците.

Върху така направената база от данни да се изгради java приложение, което да се свърза с JDBC и да има основни екрани за добавяне, редакция и изтриване на записи в основните таблици на базата от данни.

Курсовата задача трябва да включва SQL скрипт за създаване на таблиците и Java проекта - пакетиран в zip.

*/

/*
  Real estate DB table creation SQL script
*/

-------------------------

/*
	1. CREATE TYPES & TABLES
	
*/

-- Create types

CREATE TYPE name_t 
AS OBJECT (
	firstName VARCHAR(30),
	lastName VARCHAR(30)
);

CREATE TYPE property_t 
AS OBJECT (
	address VARCHAR(50),
	ownerName name_t,
	priceInLeva DECIMAL(10, 2)
) NOT FINAL; 

CREATE TYPE house_t
UNDER property_t (
	numberOfRooms INT,
	sizeInSquareMeters INT
);

CREATE TYPE businessproperty_t
UNDER property_t(
	businessPropertyType VARCHAR(20),
	sizeInSquareMeters INT
);

CREATE TYPE agency_t 
AS OBJECT (
	id INT,
	name VARCHAR(30),
	address VARCHAR(50)
);

CREATE TYPE agent_t 
AS OBJECT (
	agentId INT,
	name name_t,
	phone CHAR(12),
	dateStarted DATE,
	agency REF agency_t
);

CREATE TYPE listing_t 
AS OBJECT (
	listingNumber INT,
	dateListed DATE,
	agent REF agent_t,
	property REF property_t
);

CREATE TYPE buyer_t 
AS OBJECT (
	id INT,
	name name_t,
	phone CHAR(12),
	propertyType VARCHAR(20),
	numberOfDesiredRooms INT,
	businessPropertyType VARCHAR(20),
	minimumDesiredPriceInLeva INT,
	maximumDesiredPriceInLeva INT
);

CREATE TYPE works_with_t 
AS OBJECT (
	buyer REF buyer_t,
	agent REF agent_t
);

-- Create tables

CREATE TABLE Property
OF property_t (PRIMARY KEY (address));

CREATE TABLE Agency 
OF agency_t (PRIMARY KEY (id));

CREATE TABLE Agent
OF agent_t (PRIMARY KEY (agentId));

CREATE TABLE Listing
OF listing_t (PRIMARY KEY (listingNumber));

CREATE TABLE Buyer 
OF buyer_t (PRIMARY KEY (id));

CREATE TABLE Works_With
OF works_with_t;


/*
	2. INSERT INTO TABLES
*/

-- INSERT INTO Property

INSERT INTO Property VALUES (
	house_t(
		'2350 Gibson Road', 
		name_t('John', 'Smith'), 
		23500,
		5,
		196
	)
);

INSERT INTO Property VALUES (
	house_t(
		'197 Watson Street', 
		name_t('Raymond', 'Chou'), 
		78900, 
		6, 
		203
	)
);

INSERT INTO Property VALUES (
	house_t(
		'2525 Pottsdamer Street', 
		name_t('Jim', 'Lee'), 
		10050, 
		5, 
		180
	)
);

INSERT INTO Property VALUES (
	house_t(
		'193 Love BLVD', 
		name_t('Kim', 'Abudal'), 
		93000, 
		5,
		401
	)
);

INSERT INTO Property VALUES (
	house_t(
		'647 Maston Road', 
		name_t('Robert', 'Clue'), 
		13500, 
		5,
		102
	)
);

INSERT INTO Property VALUES (
	businessproperty_t(
		'1350 Navada Street', 
		name_t('Jack', 'Green'), 
		67409, 
		'office space', 
		467
	)
);

INSERT INTO Property VALUES (
	businessproperty_t(
		'256 Florida Street', 
		name_t('Michael', 'Kohen'), 
		17928, 
		'gas station', 
		245
	)
);

INSERT INTO Property VALUES (
	businessproperty_t(
		'1717 Kansas Street', 
		name_t('Leah', 'Mars'), 
		34500, 
		'office space', 
		356
	)
);

INSERT INTO Property VALUES (
	businessproperty_t(
		'2613 Academic Way', 
		name_t('Marry', 'Song'), 
		99705, 
		'office space', 
		670
	)
);

INSERT INTO Property VALUES (
	businessproperty_t(
		'179 Tinker Road', 
		name_t('Leon', 'Kant'), 
		9000, 
		'store front', 
		128
	)
);

-- INSERT INTO Agency

INSERT INTO Agency VALUES (
	agency_t(
		135210, 
		'Goldman Sash', 
		'799 Georgia Way'
	)
);

INSERT INTO Agency VALUES (
	agency_t(
		146277, 
		'Holloway', 
		'124 Texas Street'
	)
);

INSERT INTO Agency VALUES (
	agency_t(
		165034, 
		'Good Target', 
		'135 California Street'
	)
);

INSERT INTO Agency VALUES (
	agency_t(
		230754, 
		'Cozy Home', 
		'277 Beach Road'
	)
);

INSERT INTO Agency VALUES (
	agency_t(
		210211, 
		'Fast Searcher', 
		'1010 Alas Road'
	)
);

-- INSERT INTO Agent

INSERT INTO Agent VALUES (
	agent_t(
		100, 
		name_t('Leet', 'Kim'), 
		'0351456362', 
		TO_DATE('2012-01-23', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agency a WHERE id=210211)
	)
);

INSERT INTO Agent VALUES (
	agent_t(
		112, 
		name_t('Jim', 'Alpha'), 
		'0711356364',
		TO_DATE('2012-03-26', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agency a WHERE id=210211)
	)
);

INSERT INTO Agent VALUES (
	agent_t(
		123, 
		name_t('George', 'Grey'), 
		'0763216362',
		TO_DATE('2015-02-23', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agency a WHERE id=135210)
	)
);

INSERT INTO Agent VALUES (
	agent_t(
		145, 
		name_t('Sarah', 'Core'), 
		'0135145909',
		TO_DATE('2016-07-03', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agency a WHERE id=135210) 	
	)
);

INSERT INTO Agent VALUES (
	agent_t(
		168, 
		name_t('Livia', 'Watson'), 
		'0137145638',
		TO_DATE('2014-01-17', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agency a WHERE id=146277)
	)
);

INSERT INTO Agent VALUES (
	agent_t(
		189, 
		name_t('Nik', 'Ray'), 
		'0135873630',
		TO_DATE('2014-01-28', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agency a WHERE id=146277)
	)
);

INSERT INTO Agent VALUES (
	agent_t(
		201, 
		name_t('Cris', 'Paul'), 
		'0136141236',
		TO_DATE('2016-05-23', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agency a WHERE id=165034)
	)
);

INSERT INTO Agent VALUES (
	agent_t(
		223, 
		name_t('Lena', 'Clay'), 
		'0137145123',
		TO_DATE('2014-08-19', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agency a WHERE id=165034)
	)
);

INSERT INTO Agent VALUES (
	agent_t(
		267, 
		name_t('Kevin', 'Nil'), 
		'0190145636',
		TO_DATE('2011-07-20', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agency a WHERE id=230754)
	)
);

INSERT INTO Agent VALUES (
	agent_t(
		310, 
		name_t('Hugh', 'Grant'), 
		'0132145639', 
		TO_DATE('2012-12-31', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agency a WHERE id=230754)
	)
);

-- INSERT INTO Listing

INSERT INTO Listing VALUES (
	listing_t(
		1212,
		TO_DATE('2013-02-04', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agent a WHERE agentId=100),
		(SELECT REF(p) FROM Property p WHERE address='2350 Gibson Road')
	)
);

INSERT INTO Listing VALUES (
	listing_t(
		1500,
		TO_DATE('2013-05-06', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agent a WHERE agentId=112),
		(SELECT REF(p) FROM Property p WHERE address='197 Watson Street')
	)
);

INSERT INTO Listing VALUES (
	listing_t(
		1617,
		TO_DATE('2016-12-04', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agent a WHERE agentId=123),
		(SELECT REF(p) FROM Property p WHERE address='2525 Pottsdamer Street')
	)
);

INSERT INTO Listing VALUES (
	listing_t(
		1718,
		TO_DATE('2016-02-09', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agent a WHERE agentId=145),
		(SELECT REF(p) FROM Property p WHERE address='193 Love BLVD')
	)
	
);

INSERT INTO Listing VALUES (
	listing_t(
		1900,
		TO_DATE('2014-12-19', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agent a WHERE agentId=168),
		(SELECT REF(p) FROM Property p WHERE address='647 Maston Road')
	)
);

INSERT INTO Listing VALUES (
	listing_t(
		2101,
		TO_DATE('2015-06-06', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agent a WHERE agentId=189),
		(SELECT REF(p) FROM Property p WHERE address='1350 Navada Street')
	)
);

INSERT INTO Listing VALUES (
	listing_t(
		2305,
		TO_DATE('2017-05-25', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agent a WHERE agentId=201),
		(SELECT REF(p) FROM Property p WHERE address='256 Florida Street')
	)
);

INSERT INTO Listing VALUES (
	listing_t(
		2500,
		TO_DATE('2014-12-04', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agent a WHERE agentId=223),
		(SELECT REF(p) FROM Property p WHERE address='1717 Kansas Street')
	)
);

INSERT INTO Listing VALUES (
	listing_t(
		2790,
		TO_DATE('2013-10-01', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agent a WHERE agentId=267),
		(SELECT REF(p) FROM Property p WHERE address='2613 Academic Way')
	)
);

INSERT INTO Listing VALUES (
	listing_t(
		3001,
		TO_DATE('2015-09-05', 'YYYY-MM-DD'),
		(SELECT REF(a) FROM Agent a WHERE agentId=310),
		(SELECT REF(p) FROM Property p WHERE address='179 Tinker Road')
	)
);

-- INSERT INTO Buyer

INSERT INTO Buyer VALUES (
	buyer_t(
		799, 
		name_t('John', 'Nay'), 
		'0125345791', 
		'house', 
		5, 
		'not applied', 
		10000, 
		63500
	)
);

INSERT INTO Buyer VALUES (
	buyer_t(
		801, 
		name_t('Retina', 'Grey'), 
		'0146345790', 
		'house', 
		5, 
		'not applied', 
		10000, 
		40000
	)
);

INSERT INTO Buyer VALUES (
	buyer_t(
		813, 
		name_t('Reg', 'Neal'), 
		'0189345791', 
		'house', 
		5, 
		'not applied', 
		30000, 
		63500
	)
);

INSERT INTO Buyer VALUES (
	buyer_t(
		845, 
		name_t('Gena', 'Sarah'), 
		'0789345790', 
		'house', 
		5, 
		'not applied', 
		20000, 
		96000
	)
);

INSERT INTO Buyer VALUES (
	buyer_t(
		875, 
		name_t('Bill', 'Clay'), 
		'0888345798', 
		'not applied', 
		0, 
		'office space', 
		10000, 
		90000
	)
);

INSERT INTO Buyer VALUES (
	buyer_t(
		999, 
		name_t('Hilton', 'Clag'), 
		'0999345792', 
		'not applied', 
		0, 
		'office space', 
		30000, 
		79000
	)
);

-- INSERT INTO Works_With

INSERT INTO Works_With VALUES (
	(SELECT REF(b) FROM Buyer b WHERE id=799),
	(SELECT REF(a) FROM Agent a WHERE agentId=100)
);

INSERT INTO Works_With VALUES (
	(SELECT REF(b) FROM Buyer b WHERE id=801),
	(SELECT REF(a) FROM Agent a WHERE agentId=145)
);

INSERT INTO Works_With VALUES (
	(SELECT REF(b) FROM Buyer b WHERE id=813),
	(SELECT REF(a) FROM Agent a WHERE agentId=123)
);

INSERT INTO Works_With VALUES (
	(SELECT REF(b) FROM Buyer b WHERE id=845),
	(SELECT REF(a) FROM Agent a WHERE agentId=168)
);

INSERT INTO Works_With VALUES (
	(SELECT REF(b) FROM Buyer b WHERE id=875),
	(SELECT REF(a) FROM Agent a WHERE agentId=189)
);

INSERT INTO Works_With VALUES (
	(SELECT REF(b) FROM Buyer b WHERE id=999),
	(SELECT REF(a) FROM Agent a WHERE agentId=223)
);