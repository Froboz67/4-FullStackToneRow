BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS state;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE state (
	state_abbreviation char(2) NOT NULL,
	state_name varchar(50) NOT NULL,
	population int NOT NULL,
	area int NOT NULL,
	capital int /*NOT*/ NULL, --temporarily nullable because it's a foreign key to city.city_id
	sales_tax numeric(5,3) NOT NULL,
	state_nickname varchar(100) NULL,
	census_region varchar(10) NULL,
	CONSTRAINT PK_state PRIMARY KEY(state_abbreviation),
	CONSTRAINT UQ_state_name UNIQUE(state_name),
    CONSTRAINT UQ_state_nickname UNIQUE(state_nickname),
	CONSTRAINT CHK_census_region CHECK (census_region IS NULL OR census_region IN ('Northeast', 'South', 'Midwest', 'West'))
);

COMMIT TRANSACTION;
