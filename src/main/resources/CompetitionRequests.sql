---- Вывод итоговой таблицы (общий протокол) со всеми данными
SELECT
    r.distance || ' ' || r.style AS distance,
    ath.surname,
    ath.first_name,
    ath.date_birth,
    c.name,
    rr.result_time,
    comp.name,
    rr.points

FROM
	RaceResult rr
JOIN
    Race r ON rr.id_race = r.id
JOIN
    Athletes ath ON rr.id_athlete = ath.id
JOIN
    Competitions comp ON rr.id_race = comp.id
JOIN
    City c ON ath.city_id = c.id
ORDER BY result_time


--- Топ 3 спортсмена, которые набрали больше всего очков на данных соревнованиях
SELECT ath.surname,ath.first_name, rr.points
FROM RaceResult rr
JOIN Athletes ath ON rr.id_athlete = ath.id
ORDER BY points DESC
LIMIT 3;

----Cписок участников на соревнованиях по дистанциям
SELECT ath.surname,ath.first_name, r.distance || ' ' || r.style AS distance
FROM RaceResult rr
JOIN Athletes ath ON rr.id_athlete = ath.id
JOIN Race r ON rr.id_race = r.id

------список результатов ( ФИО + дистанция + результат)
SELECT ath.surname,ath.first_name, r.distance || ' ' || r.style AS distance,
rr.result_time
FROM RaceResult rr
JOIN Athletes ath ON rr.id_athlete = ath.id
JOIN Race r ON rr.id_race = r.id
ORDER BY result_time

---------топ 3 города, которые набрали больше всего очков на данных соревнованиях
SELECT c.name AS city, SUM(rr.points) AS total_points
FROM RaceResult rr
JOIN Athletes ath ON rr.id_athlete = ath.id
JOIN City c ON ath.city_id = c.id
GROUP BY city
ORDER BY total_points DESC
LIMIT 3