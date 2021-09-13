CREATE TABLE IF NOT EXISTS customers(
   id          BIGINT AUTO_INCREMENT PREPARE KEY,
   first_name VARCHAR(50)  NOT NULL,
   last_name  VARCHAR(100) NOT NULL,
   address    VARCHAR(500) NOT NULL,
   budget     DECIMAL      NOT NULL
);