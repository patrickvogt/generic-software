/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include <QWidget>
#include <QApplication>
#include <QTranslator>
#include <QString>
#include <QSplashScreen>
#include "gui/MainWindow.hpp"

#include <cstdio>
#include <cstdlib>

/* Bedingte Kompilierung */
#ifdef __WIN32__
	#include <windows.h>
#elif _MSC_VER
	#include <windows.h>
#endif

#define SPLASH_TIME 5

/******************************************************************************/
/* main																		  */
/******************************************************************************/

/**
*	@brief main-Methode
*
*	@param argc Anzahl der Kommandoparamter
*	@param argv Werte/Kommandoparameter
*/
int main(int argc, char *argv[])
{	
	QApplication app(argc, argv);             /* QApplication-Objekt erzeugen */
	
	QTranslator trans;          /* Uebersetzungsmodul laden und konfigurieren */
	QString filename;
	filename = QString(":/lang_%1").arg(QLocale::system().name());
	trans.load(filename, qApp->applicationDirPath());
	app.installTranslator(&trans);
	
	QPixmap pixmap(":/images/caligari_splash.png");          /* Splash Screen */
    QSplashScreen splash(pixmap, Qt::WindowStaysOnTopHint);
    splash.show();
    app.processEvents();
    
	QWidget *myWidget = new MainWindow();    /* Neues MainWindow erstellen */
	#ifdef __WIN32__
		Sleep(SPLASH_TIME*1000);
	#elif _MSC_VER
		Sleep(SPLASH_TIME*1000);
	#elif __unix__ || __linux__ || FreeBSD
	sleep(SPLASH_TIME);
	#endif
	splash.finish(myWidget);
	myWidget->show();                                  /* MainWindow anzeigen */

	return app.exec();                                       /* 'GUI-starten' */
}
