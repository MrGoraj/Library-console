#!/bin/bash

echo "Uruchamianie aplikacji"

cd library-app/build/libs || exit

java -jar library-app-0.0.1-SNAPSHOT.jar