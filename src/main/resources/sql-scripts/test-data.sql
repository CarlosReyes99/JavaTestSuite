CREATE TABLE IF NOT EXISTS movies(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(50) NOT NULL,
    director1 VARCHAR(50) NOT NULL,
    director2 VARCHAR(50) NOT NULL


);

INSERT INTO movies (name, minutes, genre, director1, director2) VALUES
    ('Dark Knight', 152, 'ACTION', 'Christopher Nolan', 'Emma Thomas'),
    ('Memento', 113, 'THRILLER', 'Quentin Tarantino', 'Lawrence Bender'),
    ('Matrix', 136, 'ACTION', 'Lana Wachowski', 'Lilly Wachowski');