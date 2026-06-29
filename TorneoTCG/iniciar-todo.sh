#!/bin/bash

echo "Iniciando Servidor de Descubrimiento Eureka (Puerto 8761)..."
osascript -e 'tell application "Terminal" to do script "cd \"'"$(pwd)"'/eureka\" && ./mvnw spring-boot:run"'

echo "Esperando 12 segundos a que Eureka se estabilice..."
sleep 12

echo "Iniciando API Gateway..."
osascript -e 'tell application "Terminal" to do script "cd \"'"$(pwd)"'/gateway\" && ./mvnw spring-boot:run"'

echo "Iniciando Microservicio Torneos (TorneoTCG)..."
osascript -e 'tell application "Terminal" to do script "cd \"'"$(pwd)"'/torneos-service\" && ./mvnw spring-boot:run"'

echo "Iniciando Microservicio Jugadores y Mazos..."
osascript -e 'tell application "Terminal" to do script "cd \"'"$(pwd)"'/jugador-service\" && ./mvnw spring-boot:run"'

echo "Iniciando Microservicio Partidas..."
osascript -e 'tell application "Terminal" to do script "cd \"'"$(pwd)"'/recinto-service\" && ./mvnw spring-boot:run"'

echo "=========================================================="
echo "Ecosistema lanzado exitosamente."
echo "Dashboard de Eureka disponible en: http://localhost:8761"
echo "=========================================================="