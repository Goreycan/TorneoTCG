
@echo off

echo Iniciando Servidor de Descubrimiento Eureka (Puerto 8761)...
cd eureka
start cmd /k "mvnw spring-boot:run"

echo Esperando 12 segundos a que Eureka se estabilice...
timeout /t 12 /nobreak > nul

echo Iniciando API Gateway...
cd ../gateway
start cmd /k "mvnw spring-boot:run"

echo Iniciando Microservicio Torneos (TorneoTCG)...
cd ../torneos-service
start cmd /k "mvnw spring-boot:run"

echo Iniciando Microservicio Jugadores y Mazos ...
cd ../jugador-service
start cmd /k "mvnw spring-boot:run"

echo Iniciando Microservicio Partidas...
cd ../recinto-service
start cmd /k "mvnw spring-boot:run"

echo ==========================================================
echo Ecosistema lanzado exitosamente. 
echo Dashboard de Eureka disponible en: http://localhost:8761
echo ==========================================================