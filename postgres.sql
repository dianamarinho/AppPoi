CREATE TABLE point_of_interest(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20),
    description VARCHAR(300),
    address_name VARCHAR(100),
    city VARCHAR(10),
    zip_code VARCHAR (20),
    poi_type VARCHAR(10),
    latitude INTEGER,
    longitude INTEGER
);