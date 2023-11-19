CREATE TABLE City
(
	id SERIAL PRIMARY KEY,
	name_city VARCHAR(255) NOT NULL
)
INSERT INTO City
VALUES
('Gomel'),
('Minsk'),
('Mogilev'),
('Vitebsk'),
('Grodno'),
('Brest');
-----------------------------------------------------------
CREATE TABLE Sportsmans
(
    id_sportsman SERIAL PRIMARY KEY,
	first_name VARCHAR(255) NOT NULL,
	surname VARCHAR(255) NOT NULL,
	date_birth INTEGER NOT NULL,
	city_id INTEGER,
	FOREIGN KEY (city_id) REFERENCES City (id)
)

INSERT INTO Sportsmans (first_name,surname,date_birth,city_id)
VALUES
('Ivan','Ivanov', 1995, 1),
('Semen','Semenov', 1989, 2),
('Egor','Egorov', 2001, 3),
('Petr','Petrov', 1994, 1),
('Alexandr','Alexanrov', 1999, 4),
('Makar','Makarenko', 1995, 5),
('Vlad','Topalov', 1990, 2);

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

----------------------------------------------------------------------------------------

CREATE TABLE Protokol
(
	id_distance INTEGER,
	id_sportsman INTEGER,
	result_time INTERVAL,
	id_competition INTEGER,
	points INTEGER,
	FOREIGN KEY (id_distance) REFERENCES Distance(id_distance),
	FOREIGN KEY (id_sportsman) REFERENCES Sportsmans(id_sportsman),
	FOREIGN KEY (id_competition) REFERENCES Competitions(id_competitions)
)

INSERT INTO Protokol (id_distance,id_sportsman,result_time,id_competition,points)
VALUES
(4,1,'00:00:22.50',1,950),
(4,2,'00:00:24.50',1,810),
(4,3,'00:00:25.50',1,720),
(4,4,'00:00:22.55',1,945),
(4,5,'00:00:23.23',1,880),
(4,6,'00:00:23.65',1,870),
(4,7,'00:00:22.90',1,920);



