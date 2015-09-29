#! /bin/sh

# Aufraeumen
make clean

if [ ! -d doc ] 
then mkdir doc
fi

# Doxygen Documentation
doxygen doxy-conf

# Sprachdatei bereitstellen
lrelease lang_de.ts

# Qt-pro-file erstellen
qmake -project
cp TFT_TFT-farkakte-Transformations.pro tmp.pro

# Qt-pro-file erweitern
cat tmp.pro append > TFT_TFT-farkakte-Transformations.pro
rm tmp.pro

# Makefile erstellen
qmake

# Kompilieren
make

# Debugging-Symbole entfernen
strip TFT_TFT-farkakte-Transformations
