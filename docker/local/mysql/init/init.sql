CREATE DATABASE IF NOT EXISTS onsen_db;

use onsen_db;

DROP TABLE IF EXISTS hotsprings;

CREATE TABLE hotsprings (
    name VARCHAR(100),
    star INT(15),
    password VARCHAR(255)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8
COLLATE = utf8_unicode_ci;