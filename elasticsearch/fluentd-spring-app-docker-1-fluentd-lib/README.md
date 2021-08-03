* Projekt `demo-fluentd` loguje pres fluent-logger-java

TOHLE JE SPATNY PRISTUP!!! VHODNY POUZE PRO HELLO WORLD!!!

cd demo-fluentd

# Provede build image aplikace
mvnw spring-boot:build-image

cd ..

# Spusti elasticsearch, kibana, fluentd & aplikaci
docker-compose up --build

# Kibana:
http://localhost:5601

# Vsechno smazne:
docker-compose down
