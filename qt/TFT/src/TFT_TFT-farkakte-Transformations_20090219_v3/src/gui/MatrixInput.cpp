/******************************************************************************/
/* MatrixInput.cpp       	                                                  */
/******************************************************************************/ 

/******************************************************************************/
/* Include-Files															  */
/******************************************************************************/

#include "gui/MatrixInput.hpp"

/******************************************************************************/
/* Klassendefinition														  */
/******************************************************************************/

/**
*	@brief initialisiert alle wichtigen Komponenten der Eingabemaske
*
*	@param parent Parent-Widget
*/
void MatrixInput::init(QWidget *parent)
{
	this->setParent(parent);
	
	this->tx_field1=new QLineEdit("1", this);
	this->tx_field2=new QLineEdit("2", this);
	this->tx_field3=new QLineEdit("3", this);
	this->tx_field4=new QLineEdit("4", this);
	this->bt_submit=new QPushButton(tr("&transform"), this);
	
	QGridLayout *layout=new QGridLayout();
	
	layout->addWidget(this->tx_field1, 0, 0);
	layout->addWidget(this->tx_field2, 0, 1);
	layout->addWidget(this->tx_field3, 1, 0);
	layout->addWidget(this->tx_field4, 1, 1);
	layout->addWidget(this->bt_submit, 2, 0);
	
	this->connect(this->bt_submit, SIGNAL(clicked()), 
		parent, SLOT(transform()));
	
	this->setDefaultSelectionBox();
	
	layout->addWidget(this->defaults, 2, 1);
	
	this->group_all = new QGroupBox(tr("Matrix-Input"), this);
	group_all->setLayout(layout);
	this->setMaximumHeight(MatrixInput::maximum_height);     
}

/**
*	@brief initialisiert die ComboBox mit den Default-Matrizen
*/
void MatrixInput::setDefaultSelectionBox()
{
	this->defaults = new QComboBox(this);
	defaults->addItem(QString(tr("")));
	defaults->addItem(QString(tr("Identity")));
	defaults->addItem(QString(tr("Mirroring (X-axis)")));
	defaults->addItem(QString(tr("Mirroring (Y-axis)")));
	defaults->addItem(QString(tr("Rotation +45 degree")));
	defaults->addItem(QString(tr("Rotation +90 degree")));
	defaults->addItem(QString(tr("Rotation +N degree")));
	defaults->addItem(QString(tr("Diminishment 2-times")));
	defaults->addItem(QString(tr("Diminishment 3-times")));
	defaults->addItem(QString(tr("Diminishment N-times")));
	defaults->addItem(QString(tr("Enlargement 2-times")));
	defaults->addItem(QString(tr("Enlargement 3-times")));
	defaults->addItem(QString(tr("Enlargement N-times")));	
	
	this->connect(this->defaults, SIGNAL(activated(const QString &)), 
		this, SLOT(fillMatrixWithValues(const QString &)));
}

/**
*	@brief Konstruktor
*
*	erzeugt ein neues Objekt vom Typ <em>MatrixInput</em>
*
*	@param parent Parent-Widget
*/
MatrixInput::MatrixInput(QWidget *parent)
{
	init(parent);
}

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
MatrixInput::MatrixInput(QWidget *parent, const double a, const double b,
		const double c, const double d)
{
	init(parent);
	
	/*hier noch zusaetzlich die TextFelder mit den Inhalten a-d initialisieren*/
	int success=0;
	char buffer[20];
	success=sprintf(buffer, "%lf", a);
	if(0>success)
	{
		this->tx_field1->insert(QString("0"));
	}
	this->tx_field1->insert(QString(buffer));
	
	success=sprintf(buffer, "%lf", b);
	if(0>success)
	{
		this->tx_field2->insert(QString("0"));
	}
	this->tx_field2->insert(QString(buffer));
	
	success=sprintf(buffer, "%lf", c);
	if(0>success)
	{
		this->tx_field3->insert(QString("0"));
	}
	this->tx_field3->insert(QString(buffer));
	
	success=sprintf(buffer, "%lf", d);
	if(0>success)
	{
		this->tx_field4->insert(QString("0"));
	}
	this->tx_field4->insert(QString(buffer));
	
}

/**
*	@brief Desktruktor
*
*	loescht ein Objekt vom Typ <em>MatrixInput</em>
*/
MatrixInput::~MatrixInput()
{

}

/**
*	@brief gibt die in der Eingabemaske eingegebene Matrix zurueck
*
*	@return die Matrix die in der Eingabemaske eingegeben wurde
*/
Matrix MatrixInput::getMatrix() const
{
	bool ok;
	
	double a=0,b=0,c=0,d=0;

	QString x1y1=this->tx_field1->text();
	QString x2y1=this->tx_field2->text();
	QString x1y2=this->tx_field3->text();
	QString x2y2=this->tx_field4->text();
	
	a=x1y1.toDouble(&ok);
	if(false==ok) 
	{
		
		return Matrix(1,0,0,1);         /* Einheitsmatrix / Identitaetsmatrix */
	}
	
	b=x2y1.toDouble(&ok);
	if(false==ok) 
	{
		return Matrix(1,0,0,1);
	}
	
	c=x1y2.toDouble(&ok);
	if(false==ok)
	{
		return Matrix(1,0,0,1);
	} 
	
	d=x2y2.toDouble(&ok);
	if(false==ok) 
	{
		return Matrix(1,0,0,1);
	}
	
	           /* pruefen, ob eine Zeile oder eine Spalte nur Nuller enthaelt */
	if((0==a && 0==b) || (0==a && 0==c) || (0==b && 0==d) || (0==c && 0==d))
	{
		                    /* Benutzer ueber falsche Eingabe benachrichtigen */
		QMessageBox info(QMessageBox::Warning, tr("Illegal Matrixinput"), 
			tr("This matrix will let disappear the polygon. "\
			"Do you really want that?"), QMessageBox::NoButton,
			dynamic_cast<QWidget *>(this->parent()));
		QPushButton *yes = info.addButton(tr("Yes"), QMessageBox::YesRole);
		(void *) info.addButton(tr("No"), QMessageBox::NoRole);
		(void) info.exec();
		if(info.clickedButton()==yes)
		{
			return Matrix(0,0,0,0);
		}
		return Matrix(1,0,0,1);
	}
	
	return Matrix(a,b,c,d);
}

/**
*	@brief fuellt die EIngabemaske mit den uebergebenen Werten
*
*	@param a init-Wert der linken oberen Ecke der Matrix
*	@param b init-Wert der linken unteren Ecke der Matrix
*	@param c init-Wert der rechten oberen Ecke der Matrix
*	@param d init-Wert der rechten unteren Ecke der Matrix
*/
void MatrixInput::setMatrix(const double a, const double b, const double c, 
	const double d)
{
	char buffer[20];
	int success=0;
	
	
	this->tx_field1->clear();                             /* Texfelder leeren */
	this->tx_field2->clear();
	this->tx_field3->clear();
	this->tx_field4->clear();

	(void) sprintf(buffer, "%lf", a);
	if(0>success)
	{
		this->tx_field1->insert(QString("0"));
	}
	this->tx_field1->insert(QString(buffer));
	
	(void) sprintf(buffer, "%lf", b);
	if(0>success)
	{
		this->tx_field2->insert(QString("0"));
	}
	this->tx_field2->insert(QString(buffer));
	
	(void) sprintf(buffer, "%lf", c);
	if(0>success)
	{
		this->tx_field3->insert(QString("0"));
	}
	this->tx_field3->insert(QString(buffer));
	
	(void) sprintf(buffer, "%lf", d);
	if(0>success)
	{
		this->tx_field4->insert(QString("0"));
	}
	this->tx_field4->insert(QString(buffer));
	
}

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
int MatrixInput::getIntegerDialog(QString title, QString label, int init_value, 
	int min_value, int max_value, int default_value) const
{
	bool ok;
    int number = QInputDialog::getInt(const_cast<MatrixInput *>(this), 
    	title, label, init_value, min_value, max_value, 1, &ok);
    
    if(ok) 
    {
    	return number;
    }
    return default_value;
}

/**
*	@brief fuellt die Matrix mit den entsprechenden StanartMatrizen
*
*	@param text Der Name der Matrix aus der ComboBox
*/
void MatrixInput::fillMatrixWithValues(const QString &text)
{
	if(tr("")==text)
	{
		return;
	}
	if(tr("Identity")==text)
	{
		this->setMatrix(1,0,0,1); return;
	}
	if(tr("Mirroring (Y-axis)")==text)
	{
		this->setMatrix(-1,0,0,1); return;
	}
	if(tr("Mirroring (X-axis)")==text)
	{
		this->setMatrix(1,0,0,-1); return;
	}
	if(tr("Rotation +45 degree")==text)
	{
		this->setMatrix(0.707,0.707,-0.707,0.707);
	}
	if(tr("Rotation +90 degree")==text)
	{
		this->setMatrix(0,1,-1,0); return;
	}
	if(tr("Rotation +N degree")==text)
	{
		int n=this->getIntegerDialog(tr("Integer-Input"), 
			tr("Angle (in degree): "), 45, 0, 360, 0);
		this->setMatrix(cos(((double)n)/180*M_PI),sin(((double)n)/180*M_PI),
			-1*sin(((double)n)/180*M_PI),cos(((double)n)/180*M_PI)); return;
	}
	if(tr("Diminishment 2-times")==text)
	{
		this->setMatrix(((double)1)/2,0,0,((double)1)/2); return;
	}
	if(tr("Diminishment 3-times")==text)
	{
		this->setMatrix(((double)1)/3,0,0,((double)1)/3); return;
	}
	if(tr("Diminishment N-times")==text)
	{
		int n=this->getIntegerDialog(tr("Integer-Input"), 
			tr("Factor: "), 2, 2, 10, 1);
		this->setMatrix(((double)1)/n,0,0,((double)1)/n); return;
	}	
	if(tr("Enlargement 2-times")==text)
	{
		this->setMatrix(2,0,0,2); return;
	}
	if(tr("Enlargement 3-times")==text)
	{
		this->setMatrix(3,0,0,3); return;
	}
	if(tr("Enlargement N-times")==text)
	{
		int n=this->getIntegerDialog(tr("Integer-Input"), 
			tr("Factor: "), 2, 2, 10, 1);
		this->setMatrix(n,0,0,n); return;
	}
}

