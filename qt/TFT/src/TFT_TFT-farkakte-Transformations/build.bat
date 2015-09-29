rem Aufraeumen
mingw32-make clean

mkdir doc

rem Doxygen Documentation
doxygen doxy-conf

rem Sprachdatei bereitstellen
lrelease lang_de.ts

rem Qt-pro-file erstellen
qmake -project
copy TFT_TFT-farkakte-Transformations.pro tmp.pro

rem Qt-pro-file erweitern
copy tmp.pro + append TFT_TFT-farkakte-Transformations.pro
del tmp.pro

rem Makefile erstellen
qmake

rem Kompilieren
mingw32-make

rem Debugging-Symbole entfernen
rem strip TFT_TFT-farkakte-Transformations

pause
