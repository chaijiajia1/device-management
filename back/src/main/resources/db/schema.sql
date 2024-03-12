DROP TABLE IF EXISTS user;

CREATE TABLE user (
                      email VARCHAR(320) PRIMARY KEY,
                      username VARCHAR(250) UNIQUE,
                      password VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS device;

CREATE TABLE device (
                        device_id varchar(250)  PRIMARY KEY,
                        name VARCHAR(250) UNIQUE,
                        type VARCHAR(250),
                        username VARCHAR(250),
                        active VARCHAR(250)
);
DROP TABLE IF EXISTS message;
CREATE table message(
    id int primary key auto_increment,
    device_id varchar(250),
    message varchar(250)
);

-- DROP TRIGGER IF EXISTS trig;
-- CREATE TRIGGER trig
--     AFTER INSERT ON message
--     FOR EACH ROW
-- BEGIN
--     UPDATE device
--     SET active = NOW()
--     WHERE device_id = NEW.device_id;
-- END;为啥不能建trigger
