# Set Up

1. W folderze projektu otwórz terminal i wpisz "docker compose up" w celu pobrania i uruchomienia środowiska niezbędnego do poprawnego działania aplikacji.

2. Wpisz komendę "gradle build" w bash

3. Wejdź w folder build, następnie uruchom program używając komendy ```java -jar library-0.0.1-SNAPSHOT.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/postgres --spring.datasource.username=admin --spring.datasource.password=admin```, w razie potrzeby podmieniając dane dostępu do bazy danych na własne

# Rollback

- W celu cofnięcia bazy danych do poprzedniej wersji należy użyć polecenia "gradle rollbackCount -Purl=jdbc:postgresql://localhost:5432/postgres -Pusername=admin -Ppassword=admin -PliquibaseCommandValue=1", podmieniając liczbę 1 na ilość zmian, które chcemy cofnąć.

- W celu cofnięcia się do konkretnej daty należy użyć polecenia "gradle rollbackToDate -Purl=jdbc:postgresql://localhost:5432/postgres -Pusername=admin -Ppassword=admin -PliquibaseCommandValue=DATA" zamieniając DATA na datę, do której chcesz się cofnąć używając formatu ```YYYY-MM-DD HH:MM:SS``` lub ```YYYY-MM-DD'T'HH:MM:SS``` (Można podać wyłącznie datę lub czas)

# Rodzaje dziedziczenia:

## Osobne tabele (Table per concrete class)

![alt Graficzne przedstawienie osobnych tabel](https://www.mimuw.edu.pl/~sroka/archiwalne/2006j2ee/lab9/10/WWW/table_per_concrete_class.png)

Rozwiązanie najbardziej podstawowe, w którym każdy obiekt ma swoją własną tabelę, nie mając ze sobą żadnych fizycznych powiązań i są w pełni niezależne od siebie nawzajem.

### Cechy rozwiązania:

- Jest to mało optymalne rozwiązanie i wraz z rozrośnięciem się aplikacji zwiększa się obciążenie dla bazy danych, ponieważ takie rozwiązanie wymaga większej ilości zapytań
- Zmiana jakiegokolwiek wspólnego pola wymaga ręcznego zmieniania każdej klasy, w której występowało takie pole.
- Jakiekolwiek bardziej zaawansowane operacje, jak np. więzy integralności stają się wyjątkowo trudne do wykonania

## Dziedziczenie tabel (Table per subclass)

![alt Graficzne przedstawienie dziedziczenia tabel](http://db.fizyka.pw.edu.pl/~bzdak/bazy_danych_ed_20/_images/db-schema-rel.svg)

Tutaj wykorzystujemy 3 tabele: "czytelnik", "rodzic", "dziecko".

W tabeli "czytelnik" znajdują się wszystkie dane wspólne dla "rodzic" oraz "dziecko".

W takim rozwiązaniu klucz główny z tabeli "rodzic" oraz tabeli "dziecko" będzie kluczem obcym dla tabeli "czytelnik".

### Cechy rozwiązania:

- Żeby wybrać dane o rodzicu i dziecku należy użyć JOIN.
- Łatwo wybrać dane wszystkich osób oraz to naturalne.
- Można wyrazić, że ktoś jest zarówno rodzicem, jak i dzieckiem.

## Pojedyncza tabela (Table per class hierarchy)

![alt Graficzne przedstawienie dziedziczenia pojedynczej tabeli](http://db.fizyka.pw.edu.pl/~bzdak/bazy_danych_ed_20/_images/db-schema-single-table.svg)

Używamy jednej tabeli, która zawiera dane zarówno o rodzicach, jak i dzieciach, zawiera ona kolumny obu tych tabel. 

Zawiera też dodatkową kolumnę, w której znajduje się informacja, czy dany wiersz reprezentuje rodzica, czy dziecko. 

Dane dotyczące rodzica w wierszu reprezentującym dziecko mają wartość NULL.

### Cechy rozwiązania:

- Nie trzeba używać JOIN
- Może pojawić się problem, kiedy ktoś będzie zarówno rodzicem, jak i dzieckiem.
- Nie możemy dawać oznaczenia NON NULL na kolumnach należących zarówno do rodzica, jak i dziecka.
- Są problemy z unikalnymi ograniczeniami dotyczącymi oddzielnie rodzica, jak i dziecka.
- Tworzenie kluczy obcych dla rodziców i dzieci może być problematyczne.

## Dziedziczenie PostgreSQL

![alt Graficzne przedstawienie dziedziczenia z wykorzystaniem metody z PostgreSQL](http://db.fizyka.pw.edu.pl/~bzdak/bazy_danych_ed_20/_images/db-schema-inherits.svg)

PostgreSQL umożliwia użycie wbudowanej metody dziedziczenia między tabelami o nazwie [INHERITS](https://www.postgresql.org/docs/current/ddl-inherit.html)

Działa ona w podobny sposób do rozwiązania [Dziedziczenie tabel](#Dziedziczenie tabel (Table per subclass)) wykonując przy tym większość czynności za nas.

Tabela dziedzicząca z nadrzędnej (tutaj "czytelnik") oprócz PK (powstanie kolumna id, jednak z niezależną zawartością).

Jeśli zostaną dodane jakieś dane dla tabeli dziedziczącej (tutaj rodzic lub dziecko), to zostaną one również umieszczone w tabeli nadrzędnej ("czytelnik").

### Cechy tego rozwiązania

- Może być problem z osobą, która jest i studentem i pracownikiem.
- Są problemy z unikalnymi SQL Constants. (nie pamiętam spolszczenia dlatego wrzucam nazwę po angielsku)
- Tabela, po której dziedziczą inne tabele, nie wspiera wszystkich operacji SQL.
- Działa wyłącznie na PostgreSQL i uniemożliwia użycie naszej aplikacji ze współpracy z jakimkolwiek innym silnikiem bazodanowym

<sub><sup>Grafiki oraz w dużej mierze informacje kradzione ze strony [Politechniki Warszawskiej](http://db.fizyka.pw.edu.pl/~bzdak)