BEGIN TRANSACTION;

DROP TABLE IF EXISTS tonerow;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id SERIAL,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE tonerow (
	id SERIAL
	, name VARCHAR(56) NOT NULL UNIQUE
	, pzero INT NOT NULL
	, pone INT NOT NULL
	, ptwo INT NOT NULL
	, pthree INT NOT NULL
	, pfour INT NOT NULL
	, pfive INT NOT NULL
	, psix INT NOT NULL
	, pseven INT NOT NULL
	, peight INT NOT NULL
	, pnine INT NOT NULL
	, pten INT NOT NULL
	, peleven INT NOT NULL
	, user_id INT NOT NULL
	, CONSTRAINT PK_tonerow PRIMARY KEY (id)
	, CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

COMMIT TRANSACTION;