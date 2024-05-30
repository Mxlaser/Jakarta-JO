# Jakarta-JO

BELLANGER Nicolas
ZIVKOVIC Nikola

Acheteur
  Créer un acheteur
    POST /acheteurs
    Body: { "name": "Til", "firstname": "Jean" }
  Lire un acheteur
    GET /acheteurs/{uuid}
  Mettre à jour un acheteur
    PUT /acheteurs/{uuid}
    Body: { "name": "Til", "firstname": "Jean" }
  Supprimer un acheteur
    DELETE /acheteurs/{id}

Billet
  Créer un billet
    POST /billets
    Body: { "name": "Jean", "price": 49.99 }
  Lire un billet
    GET /billets/{uuid}
  Mettre à jour un billet
    PUT /billets/{uuid}
    Body: { "name": "Jean", "price": 49.99 }
  Supprimer un billet
    DELETE /billets/{uuid}

Epreuve
  Créer une épreuve
    POST /epreuves
    Body: { "name": "Finale 100m", "dateEpreuve": "20204-12-05T12:00:00.00" }
  Lire une épreuve
    GET /epreuves/{uuid}
  Mettre à jour une épreuve
    PUT /epreuves/{id}
    Body: { "name": "Finale 100m", "dateEpreuve": "20204-12-05T12:00:00.00" }
  Supprimer une épreuve
    DELETE /epreuves/{uuid}

Stade
  Créer un stade
    POST /stades
    Body: { "name": "Stade de France", "adresse": "Saint-Denis" }
  Lire un stade
    GET /stades/{uuid}
  Mettre à jour un stade
    PUT /stades/{uuid}
    Body: { "name": "Stade de France", "adresse": "Saint-Denis" }
  Supprimer un stade
    DELETE /stades/{uuid}
