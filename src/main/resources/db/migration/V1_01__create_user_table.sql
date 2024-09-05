CREATE TABLE "user"
(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(128),
    password VARCHAR(10),
    first_name1 VARCHAR(128),
    last_name VARCHAR(128),
    created_date TIMESTAMP,
    updated_date TIMESTAMP
);
