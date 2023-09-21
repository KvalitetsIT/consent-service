# consent-service
Consent-service modulet, der tidligere lå i _consent_ projektet.

Fra _consent_ projektet: Denne IdP kan sættes mellem service providers (SPs) og en identity provider (IdP) med det formål at håndtere brugersamtykke.

## Test
I _consent-webgui_ projektet findes et docker compose setup i mappen _consent-compose_ hvorfra hele consent flowet kan testes.

## Konfiguration

| Environment variable             | Beskrivelse                                                                                                     | Påkrævet |
|----------------------------------|-----------------------------------------------------------------------------------------------------------------|----------|
| DB_DRIVER                        | Database driver.                                                                                                | Ja       |
| DB_PASSWORD                      | Password til database.                                                                                          | Ja       |
| DB_USERNAME                      | Brugernavn til database.                                                                                        | Ja       |
| DB_URL                           | Url til database.                                                                                               | Ja       |
| NOTIFICATION_SERVICE_URL         | Url til notifikationsservice, f.eks. http://jsontomqservice:8090/notificationservice                            | Ja       |
| UID_KEY                          | Uid nøgle, f.eks. dk:gov:saml:cprNumberIdentification                                                           | Ja       |
| FLYWAY_PLACEHOLDERS_MUNICIPALITY | Kommune der arbejdes under. F.eks. 561 = Esbjerg                                                                | Ja       |
| SERVER_PORT                      | Server port. Defaulter til 80.                                                                                  | Nej      |
| LOG_LEVEL                        | Log Level til applikation log. Defaulter til INFO.                                                              | Nej      |
| LOG_LEVEL_FRAMEWORK              | Log level til framework. Defaulter to INFO.                                                                     | Nej      |
| CORRELATION_ID                   | HTTP header til at få correlation id fra. Benyttes til at korrelere log-beskeder. Defaulter til "x-request-id". | Nej      |
| SERVICE_ID                       | Service id til log-beskeder. Defaulter til "consent-service".                                                   | Nej      |
