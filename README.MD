Приложение по ведению регионов.



Swagger api:
http://localhost:8080/swagger-ui/index.html

Swagger documentation:
http://localhost:8080/v3/api-docs

---------------------------------------------------------
Запуск прилодение через docker:
docker-compose -f docker-compose.yaml up --build -d

Описание команды:
-f - указание имени файла
--build - именно пересобрать иначе будет старый контейнер из кеша и поднимать. 
Даже удаление из докера не поможет.
-d - detach
---------------------------------------------------------