# SportAPI

Ett enkelt Spring Boot-API för att hantera lag och matcher.

## Funktioner
- Skapa och lista lag
- Skapa matcher mellan lag
- Uppdatera matchresultat
- Visa matcher med lagnamn (DTO)

## Teknik
- Java 25
- Spring Boot
- Spring Data JPA
- PostgreSQL

## Kom igång

### Förkrav
- Java 25
- PostgreSQL lokalt

### Konfigurera databas
Uppdatera `src/main/resources/application.properties` vid behov:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/sportapi
spring.datasource.username=postgres
spring.datasource.password=postgres
```

### Starta
```
./gradlew bootRun
```

## API-endpoints

### Lag
- `POST /teams` skapa lag
- `GET /teams` lista alla lag

Exempel:
```
curl -X POST http://localhost:8080/teams \
  -H "Content-Type: application/json" \
  -d '{"name":"Team A"}'
```

### Matcher
- `POST /matches` skapa match
- `GET /matches` lista alla matcher
- `GET /matches/{id}` hämta en match med id
- `PUT /matches/{id}/result` uppdatera resultat
- `GET /matches/view` lista matcher med lagnamn

Exempel:
```
curl -X POST http://localhost:8080/matches \
  -H "Content-Type: application/json" \
  -d '{"homeTeamId":1,"awayTeamId":2}'
```

```
curl -X PUT http://localhost:8080/matches/1/result \
  -H "Content-Type: application/json" \
  -d '{"homeScore":2,"awayScore":1}'
```

## Noteringar
- Databasschemat skapas/uppdateras automatiskt via JPA (`spring.jpa.hibernate.ddl-auto=update`).

## Arbetsprocess (Scrum)
Vi arbetade iterativt med issues och milestones i GitHub:
- Sprint 1: Grundsetup och lag (Team)
- Sprint 2: Matcher (Match), resultat och vy
Varje issue representerade en user story med tydliga mål och accepterades när funktionen var klar.

## Testa endpoints (Bruno)
Vi använder Bruno för att testa API:et.

Steg:
1. Starta API:t (`./gradlew bootRun`)
2. Öppna Bruno och skapa/importera en request mot `http://localhost:8080`
3. Kör requests för `/teams`, `/matches`, `/matches/{id}/result` och `/matches/view`
