```mysql

CREATE TABLE Users
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    login_id      VARCHAR(255) NOT NULL UNIQUE, 
    password      VARCHAR(255) NOT NULL,
    name          VARCHAR(255) NOT NULL,
    nickname      VARCHAR(255) NOT NULL UNIQUE, 
    email         VARCHAR(255) NOT NULL UNIQUE, 
    membership    VARCHAR(255),
    phone         VARCHAR(255) NOT NULL UNIQUE,
    created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_login_at DATETIME,
    deleted_at    DATETIME,
    is_deleted    BOOLEAN      NOT NULL DEFAULT FALSE
);










```