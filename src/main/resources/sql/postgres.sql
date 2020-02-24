CREATE USER jablonm WITH PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE "testdb" to jablonm;

Select distinctCountry.country,coalesce(exportTable.export,0),coalesce(importTable.import,0) from
    (Select distinct country from companies) as distinctCountry
        left join
    (SELECT A.country, sum(B.value) as "export" from companies A join trades B on A.name= B.seller group by A.country) as exportTable
    on distinctCountry.country= exportTable.country
        left join
    (SELECT A.country, sum(B.value) as "import" from companies A join trades B on A.name= B.buyer group by A.country) as importTable
    on distinctCountry.country= importTable.country
ORDER BY distinctCountry.country
;




Select distinctCountry.country,coalesce(exportTable.export,0),coalesce(importTable.import,0)
SELECT  A.country, B.value as "export" from companies A join trades B on A.name= B.seller
SELECT A.country, B.value as "import" from companies A join trades B on A.name= B.buyer) as importTable
on distinctCountry.country= importTable.country

Select((Select count( City) from station) -( Select count(distinct City) from station)) as difference;