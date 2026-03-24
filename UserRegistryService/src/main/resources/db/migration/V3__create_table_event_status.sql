CREATE TABLE event_status (
                              id BIGSERIAL PRIMARY KEY,
                              code_status INTEGER NOT NULL,
                              name_status VARCHAR(50) NOT NULL,
                              description VARCHAR(255) NOT NULL
);

