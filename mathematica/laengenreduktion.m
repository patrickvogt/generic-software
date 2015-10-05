(* ::Package:: *)

(* L\[CapitalADoubleDot]NGENREDUKTION *) 
(* Autor: Patrick Vogt *)
(* Datum: 11.04.2013 *)
(* nach: Skript, Schnorr - Gitter und Kryptographie, Uni Frankfurt, WS2010, Seite 12 *)

(* EINGABEDATEN *)
(* B: Basis mit b_ 1,...,b_n als Zeilenvektoren *)
Laengenreduktion[B_] := Module[{Bcopy,i,j,oj,myij,oi,n,bi,GSB,bj},
(* VORBEREITUNG *)
    (* Eingegebene Basis B kopieren - Arbeitskopie *)
    Bcopy = B;
(* n: Anzahl der Basisvektoren *)
n = Length[Bcopy];
(* GSB: Liste zur Speicherung der Gram Schmidt-orthogonalisierten Basis *)
GSB= List[];

(* VERARBEITUNG *)
(* der erste Basisvektor b_ 1 wird \[UDoubleDot]bernommen *)
AppendTo[GSB, Bcopy[[1]]];

(* \[ADoubleDot]u\[SZ]ere Schleife f\[UDoubleDot]r Orthogonalisierung des i. Basisvektors *)
For[i=2,i<=n,i=i+1,

(* b_i: i. Basisvektor *)
bi=Bcopy[[i]];
(* o_i: i. orthogonalisierter Basisvektor *)
oi=bi;

(* innere Schleife f\[UDoubleDot]r die Subtraktion der 1,...,j < i orthogonalisierten Basisvektoren *)
For[j=1,j<i,j=j+1,

(* o_j: j. Gram Schmidt-orthogonalisierter Basisvektor *)
oj=GSB[[j]];

(* Berechnung des Gram Schmidt-Koeffizienten my_ij *)
myij = (bi .  oj)/(oj . oj);

(* Erzeugung vom i. Gram Schmidt-Basisvektor *)
oi = oi - (myij*oj);

]; (* End For *)

(* i. Gram Schmidt-Basisvektor in die Liste der Gram Schmidt-Basis \[UDoubleDot]bernehmen *)
AppendTo[GSB,oi];

]; (* End For *)

(* AUSGABE *)
(* Gram Schmidt-Orthogonalbasis *)
GSB;

(* L\[ADoubleDot]ngenreduktion der Basis B *)
For[i=2,i<=n,i=i+1,

(* b_i: i. Basisvektor *)
bi = Bcopy[[i]];

(* innere Schleife um den i. Basisvektor zu l\[ADoubleDot]ngenreduzieren *)
For[j=i-1,j>=1,j=j-1,

(* b_j: j. Basisvektor *)
bj = Bcopy[[j]];
(* o_j: j. Gram Schmidt-orthogonalisierter Basisvektor *)
oj=GSB[[j]];

(* Berechnung des Gram Schmidt-Koeffizienten *)
myij = (bi .  oj)/(oj . oj);

(* i. Basisvektor l\[ADoubleDot]ngenreduzieren *)
bi = bi - (Round[myij]*bj);

]; (* End For *)

(* l\[ADoubleDot]ngenreduzierten Basisvektor in Basis ersetzen *)
Bcopy = ReplacePart[Bcopy,i-> bi];

]; (* End For *)

(* RUECKGABEWERT *)
(* L\[ADoubleDot]ngenreduzierte Basis *)
Bcopy
]; (* End Module *)


B = 
{
  {1,2},  (* b_ 1 *)
  {3,4}   (* b_ 2 *)
};


Laengenreduktion[B]
