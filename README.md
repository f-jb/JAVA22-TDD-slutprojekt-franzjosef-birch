# TDD slutuppgift
Detta var en märklig uppgift. Enligt principerna för TDD så ska man skriva tester för allt utåt, det vill säga det kontraktet man gör med omvärlden. Den inre logiken är likgiltig. Så att testa inre egenskaper kvittar då det av börd är endast beteendet av klassen och dess metoder. Gör de publika metoderna det som de anger? Ja eller nej.

Sedan att testa via "omvägar" är också udda. Vad är det vi vill testa? Konkreta klassers beteenden. Med lite mer utvecklad logik i buffert så som att den har sin egna lista över aktiva producers och consumers hade varit kanske mer av intresse. Nu fanns det bara två metoder som vem som helst kan anropa. Då bör vi också testa de metoderna som att vem som helst anropar.

Vilket även leder till att om det blir fel i mock-klasserna så får vi fel fokus, tror att saker funkar som kanske inte gör det eller vice versa. Testa enskilt och testa sedan integration.

## Viktiga tester
Som föregående uppgift så föredrar jag först tester som beskriver hur det ska fungera och sedan tester för allt som kan gå fel. För om du inte vet hur något ska fungera hur vet du då vad som kan gå fel?

Svårt kan jag inte påstå att uppgiften var. Uppgiftsbeskrivningen var däremot kanske lite märklig. 