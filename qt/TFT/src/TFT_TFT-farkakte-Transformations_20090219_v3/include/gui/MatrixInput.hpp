/******************************************************************************/
/* MatrixInput.hpp       	                                                  */
/******************************************************************************/ 

/* Autor: 			Patrick VOGT											  */
/* Matrikelnummer: 	256558													  */

/******************************************************************************/
/* Macro Guards																  */
/******************************************************************************/

#ifndef _MATRIXINPUT_HPP_
#define _MATRIXINPUT_HPP_

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include <QWidget>
#include <QGridLayout>
#include <QLineEdit>
#include <QPushButton>
#include <QComboBox>
#include <QMessageBox>
#include <QGroupBox>
#include <QInputDialog>
#include <QString>
#include "util/Matrix.hpp"
#include <cmath>

/******************************************************************************/
/* Klassendeklaration														  */
/******************************************************************************/

/**
*	@author Patrick Vogt
*
*	@brief implementiert eine Eingabemaske fuer eine 2x2 Matrix
*/
class MatrixInput: public QWidget
{
Q_OBJECT

private:
	/**
	*	@brief maximale Hoehe der Eingabemaske
	*/
	static const unsigned int maximum_height=150;
	/**
	*	@brief gruppiert alle Elemente des Widgets und umrahmt diese
	*/
	QGroupBox *group_all;

	/**
	*	@brief Textfeld fuer die linke obere 'Koordinate'
	*/
	QLineEdit *tx_field1;
	
	/**
	*	@brief Textfeld fuer die linke untere 'Koordinate'
	*/
	QLineEdit *tx_field2;
	
	/**
	*	@brief Textfeld fuer die rechte obere 'Koordinate'
	*/
	QLineEdit *tx_field3;
	
	/**
	*	@brief Textfeld fuer die rechte untere 'Koordinate'
	*/
	QLineEdit *tx_field4;
	
	/**
	*	@brief ComboBox fuer die Standard-Matrizen
	*/
	QComboBox *defaults;
	
	/**
	*	@brief Knopf zum bestaetigen der Transformation
	*/
	QPushButton *bt_submit;
	
	/**
	*	@brief initialisiert alle wichtigen Komponenten der Eingabemaske
	*
	*	@param parent Parent-Widget
	*/
	void init(QWidget *parent);
	
	/**
	*	@brief initialisiert die ComboBox mit den Default-Matrizen
	*/
	void setDefaultSelectionBox();
	
protected:

public:
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>MatrixInput</em>
	*
	*	@param parent Parent-Widget
	*/
	MatrixInput(QWidget *parent);
	
	/**
	*	@brief Konstruktor
	*
	*	erzeugt ein neues Objekt vom Typ <em>MatrixInput</em>
	*
	*	@param parent Parent-Widget
	*	@param a init-Wert der linken oberen Ecke der Matrix
	*	@param b init-Wert der linken unteren Ecke der Matrix
	*	@param c init-Wert der rechten oberen Ecke der Matrix
	*	@param d init-Wert der rechten unteren Ecke der Matrix
	*/
	MatrixInput(QWidget *parent, const double a, const double b,
		const double c, const double d);
		
	
	//MatrixInput(const MatrixInput &rhs);
	
	/**
	*	@brief Desktruktor
	*
	*	loescht ein Objekt vom Typ <em>MatrixInput</em>
	*/
	virtual ~MatrixInput();

	/**
	*	@brief gibt die in der Eingabemaske eingegebene Matrix zurueck
	*
	*	@return die Matrix die in der Eingabemaske eingegeben wurde
	*/
	Matrix getMatrix() const;
	
	/**
	*	@brief fuellt die EIngabemaske mit den uebergebenen Werten
	*
	*	@param a init-Wert der linken oberen Ecke der Matrix
	*	@param b init-Wert der linken unteren Ecke der Matrix
	*	@param c init-Wert der rechten oberen Ecke der Matrix
	*	@param d init-Wert der rechten unteren Ecke der Matrix
	*/
	void setMatrix(const double a, const double b, const double c, 
		const double d);
	
	/**
	*	@brief zeigt einen EingabeDialog zur Eingabe von Ganzzahlen an
	*
	*	@param title String in der Titelleiste des Dialoges
	*	@param label Text vor dem Eingabefeld
	*	@param init_value Anfangswert des Eingabefeldes
	*	@param min_value Kleinster gueltiger Wert
	*	@param  max_value Groesster gueltiger Wert
	*	
	*	@return die eingegebene Ganzzahl
	*/	
	int getIntegerDialog(QString title, QString label, int init_value, 
		int min_value, int max_value, int default_value) const;
	
public slots:
	/**
	*	@brief fuellt die Matrix mit den entsprechenden StanartMatrizen
	*
	*	@param text Der Name der Matrix aus der ComboBox
	*/
	void fillMatrixWithValues(const QString &text);

};

#endif /* _MATRIXINPUT_HPP_ */
