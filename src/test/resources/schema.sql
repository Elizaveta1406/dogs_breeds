
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50)
);

CREATE TABLE breeds (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    origin_country VARCHAR(50) NOT NULL,
    description TEXT,
    avg_lifespan_years INT,
    size VARCHAR(50) NOT NULL,
    temperament VARCHAR(255) NOT NULL,
    image_url VARCHAR(255)
);

CREATE TABLE dogs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    breed_id BIGINT NOT NULL,
    owner_id BIGINT,
    birth_date DATE,
    color VARCHAR(50),
    weight_kg DOUBLE,
    gender VARCHAR(50),
    CONSTRAINT fk_dog_breed FOREIGN KEY (breed_id) REFERENCES breeds(id),
    CONSTRAINT fk_dog_owner FOREIGN KEY (owner_id) REFERENCES users(id)
);
