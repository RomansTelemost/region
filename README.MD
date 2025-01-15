Реестр регионов
---------------------------------------------------------
Запуск приложения через docker - командой:

docker-compose -f docker-compose.yaml up --build -d

Прложение поднимается на порту 8081

---------------------------------------------------------
API Документация / примеры запросов доступны по следующим ip:

Взаимодействие с приложением доступно по UI / REST:
http://localhost:8081/swagger-ui/index.html

Документация в json формате:
http://localhost:8081/v3/api-docs

---------------------------------------------------------

Запуск приложения локально:
- Необходимо добавить параметр профиля в environmentVariables при старте приложения:
- - "SPRING_PROFILES_ACTIVE=local"

- - "SPRING_PROFILES_ACTIVE=docker"

"SPRING_PROFILES_ACTIVE=local" - Будет подключена локальная бд postgres, 
сервис которой должен быть запущен на порту 5434

"SPRING_PROFILES_ACTIVE=docker" - Запуск контейнера с бд postgres
