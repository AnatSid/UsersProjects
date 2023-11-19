---- Вывод итоговой таблицы (общий протокол) со всеми данными
SELECT
    d.meters || ' ' || d.name_style AS distance,
    s.surname,
    s.first_name,
    s.date_birth,
    c.name_city ,
    p.result_time,
    comp.name_competitions,
    p.points
FROM
    Protokol p
JOIN
    Distance d ON p.id_distance = d.id_distance
JOIN
    Sportsmans s ON p.id_sportsman = s.id_sportsman
JOIN
    Competitions comp ON p.id_competition = comp.id_competitions
JOIN
    City c ON s.city_id = c.id
ORDER BY result_time


--- Топ 3 спортсмена, которые набрали больше всего очков на данных соревнованиях
SELECT s.surname,s.first_name, p.points
FROM Protokol p
JOIN Sportsmans s ON p.id_sportsman = s.id_sportsman
ORDER BY points DESC
LIMIT 3;

----Cписок участников на соревнованиях по дистанциям
SELECT s.surname,s.first_name, d.meters || ' ' || d.name_style AS distance
FROM Protokol p
JOIN Sportsmans s ON p.id_sportsman = s.id_sportsman
JOIN Distance d ON p.id_distance = d.id_distance

------список результатов ( ФИО + дистанция + результат)
SELECT s.surname,s.first_name, d.meters || ' ' || d.name_style AS distance,
p.result_time
FROM Protokol p
JOIN Sportsmans s ON p.id_sportsman = s.id_sportsman
JOIN Distance d ON p.id_distance = d.id_distance
ORDER BY result_time

---------топ 3 города, которые набрали больше всего очков на данных соревнованиях
SELECT c.name_city AS city, SUM(p.points) AS total_points
FROM Protokol p
JOIN Sportsmans s ON p.id_sportsman = s.id_sportsman
JOIN City c ON s.city_id = c.id
GROUP BY city
ORDER BY total_points DESC
LIMIT 3