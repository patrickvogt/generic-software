(* ::Package:: *)

(* PAARWEISE REDUKTION *) 
(* Autor: Patrick Vogt *)
(* Datum: 11.04.2013 *)
(* nach: Skript, Schnorr - Gitter und Kryptographie, Uni Frankfurt, WS2010, Seite 13 *)

(* EINGABEDATEN *)
(* B: Basis mit b_ 1,...,b_n als Zeilenvektoren *)
PaarweiseReduktion[B_] := Module[{i,n,j,r,bi,bj},
(* VORBEREITUNG *)
    (* Eingegebene Basis B kopieren - Arbeitskopie *)
    Bcopy = B;
(* n: Anzahl der Basisvektoren *)
n = Length[Bcopy];

(* VERARBEITUNG *)
Do[ (* Notl\[ODoubleDot]sung um 'Label' und 'Goto' nutzen zu k\[ODoubleDot]nnen *)

Label["Sort"];
(* Basis B aufsteigend nach L2-Norm sortieren *)
Bcopy=Sort[Bcopy, Norm[#1] < Norm[#2] &];

(* \[ADoubleDot]u\[SZ]ere Schleife f\[UDoubleDot]r paarweise Reduktion des i. Basisvektors *)
For[i=2,i<=n,i=i+1,

(* b_i: i. Basisvektor *)
bi=Bcopy[[i]];

(* innere Schleife f\[UDoubleDot]r die Subtraktion der 1,...,j < i Basisvektoren *)
For[j=1,j<i,j=j+1,

(* b_j: j. Basisvektor *)
bj=Bcopy[[j]];

(* r: Berechnung des Koeffizienten *)
r = (bi .  bj)/(bj . bj);

(* Anpassung des Basisvektors b_i *)
If[Abs[r]>(1/2), 
(* Then *)
bi=bi-Round[r]*bj;
Bcopy=ReplacePart[Bcopy,i->bi]; 
Goto["Sort"]

]; (* End If*)

]; (* End For *)

](* End For *)
,{1}
];(* End Do *)

(* RUECKGABE *)
(* Paarweise reduzierte Basis B *)
Bcopy
]; (* End Module *)


Ba = 
{
  {1,2},    (* b_ 1 *)
  {3,4}     (* b_ 2 *)
};


PaarweiseReduktion[Ba]