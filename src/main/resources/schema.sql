CREATE VIEW match_view AS
SELECT
    m.id,
    ht.name AS home_team,
    at.name AS away_team,
    m.home_score,
    m.away_score,
    m.played
FROM "match" m
         JOIN team ht ON m.home_team_id = ht.id
         JOIN team at ON m.away_team_id = at.id;
