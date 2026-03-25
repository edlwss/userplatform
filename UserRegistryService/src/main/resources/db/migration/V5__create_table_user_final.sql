CREATE TABLE users_final (
                             id BIGSERIAL PRIMARY KEY,
                             created_event VARCHAR(255) NOT NULL,
                             user_id BIGINT NOT NULL,
                             first_name_user VARCHAR(255) NOT NULL,
                             last_name_user VARCHAR(255) NOT NULL
);