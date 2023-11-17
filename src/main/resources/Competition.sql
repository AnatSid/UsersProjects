CREATE TABLE Sportsmans
(
	first_name VARCHAR(255) NOT NULL,
	surname VARCHAR(255) NOT NULL,
	date_birth INTEGER NOT NULL,
	city_id INTEGER,
	FOREIGN KEY (city_id) REFERENCES City(id)
)

INSERT INTO Sportsmans
VALUES
('Ivan','Ivanov', 1995, 1),
('Semen','Semenov', 1989, 2),
('Egor','Egorov', 2001, 3),
('Petr','Petrov', 1994, 1),
('Alexandr','Alexanrov', 1999, 4),
('Makar','Makarenko', 1995, 5),
('Vlad','Topalov', 1990, 2);

SELECT s.first_name, s.surname, s.date_birth, c.name_city AS city_name
FROM Sportsmans s
JOIN City c ON s.city_id = c.id_city;

-----------------------------------------------------------------------------------
CREATE TABLE Distance
(
	id_distance SERIAL PRIMARY KEY,
	name_style VARCHAR(255) NOT NULL,
	meters INTEGER NOT NULL
)

INSERT INTO Distance (name_style,meters)
VALUES
('Butterfly',50),
('Butterfly',100),
('Butterfly',200),
('Freestyle ',50),
('Freestyle ',100),
('Freestyle ',200),
('Freestyle ',400);
-----------------------------------------------------------------

CREATE TABLE Competitions
(
    id_competitions SERIAL PRIMARY KEY,
    name_competitions VARCHAR(255) NOT NULL,
    date_competitions DATE NOT NULL,
    city_id INTEGER NOT NULL,
	FOREIGN KEY (city_id) REFERENCES City(id)
);

INSERT INTO Competitions (name_competitions, date_competitions, city_id)
VALUES
('Swimming Championship', '2023-08-15', 2),
('Aquatic Games', '2022-09-20', 1),
('Summer Swim Fest', '2021-07-10', 5),
('Golden Finale', '2020-11-05', 2),
('Sprint Showdown', '2019-06-25', 4),
('Winter Swim Cup', '2022-01-25', 6);

SELECT comp.name_competitions,comp.date_competitions, c.name_city AS city_name
FROM Competitions comp
JOIN City c ON comp.city_id = c.id
----------------------------------------------------------------------------------------

