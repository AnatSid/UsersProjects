
--Групировка по дням где суммарно проплыл больше чем какой-то метраж
SELECT execution_date, SUM(exer.distance) AS total_distance
FROM Done_exercise done
JOIN Exercise exer ON done.exercise_id = exer.id
GROUP BY done.execution_date
HAVING SUM(exer.distance) >= 800

-----------------------------------------------------

CREATE TABLE SwimmingCompetition (
  Name_sportsman VARCHAR(255) NOT NULL,
  Age INTEGER NOT NULL,
  City VARCHAR(255) NOT NULL,
  Result_time INTERVAL,
  Points INTEGER
);

INSERT INTO SwimmingCompetition (Name_sportsman, Age, City, Result_time,Points)
VALUES
('Ivan Ivanov', 25, 'Gomel', '02:30.500',670),
('Petr Petrov', 28, 'Minsk', '01:45.300',842),
('Semen Semenov', 24, 'Gomel', '01:30.500',956),
('Sasha Vasilev', 22, 'Minsk', '01:43.300',865),
('Stepan Stepanov', 29, 'Polotsk', '01:32.300',920);


--Вывод по результатам от лучшего к худшему  ( по времени проплывания)
SELECT *
FROM SwimmingCompetition
ORDER BY result_time

--Командное ( по городам) первенство по сумме очков
SELECT city, SUM(points) AS total_score
FROM SwimmingCompetition
GROUP BY city
ORDER BY total_score DESC

--Топ-3 результата по очкам
SELECT *
FROM SwimmingCompetition
ORDER BY points DESC
LIMIT 3