(* ::Package:: *)

(* LLL-ALGORITHMUS *) 
(* Autor: Patrick Vogt *)
(* Datum: 12.04.2013 / 16.12.2013 *)
(* 
    nach: Buch, Hoffstein, Pipher, Silverman - An Introduction to 
    Mathematical Cryptography, Seite 411, Errata zum Buch, Hoffstein, 
    Pipher, Silverman - An Introduction to Mathematical Cryptography, 
    Seite 23 und Lenstra, Lenstra, Lovasz - Factoring Polynomials with 
    Rational Coefficients, Seite 516 und 519 
*)

(* EINGABEDATEN *)
(* base: Basis eines Gitters L mit b_1,...,b_n als Zeilenvektoren *)
LLL[base_] := Module[
    {basecopy, bi, bi1, bj, gsbase, i, j, myii1, myij, n, oi, oi1, oj},

    (* VORBEREITUNG *)
    (* Eingegebene Basis base kopieren - Arbeitskopie *)
    basecopy = base;
    (* Dimension des vollstaendigen Gitters bestimmen *)
    n = Length[basecopy];
    (* Laufvariable i fuer den zu verarbeitenden Basisvektor *)
    i = 2;
    (* 
        gsbase: Liste zur Speicherung der Gram-Schmidt 
        orthogonalisierten Basis 
    *)
    gsbase = List[];

    (* VERARBEITUNG *)
    (* der erste Basisvektor b_1 wird uebernommen *)
    AppendTo[gsbase, basecopy[[1]]];

    (* Solange i kleiner gleich der Anzahl der Basisvektoren ist *)
    While[i <= n, 
    
        (* Gram-Schmidt Berechnung *)
    
        (* 
            Da eventuell die Reihenfolge der Basisvektoren innerhalb der 
            Schleife vertauscht wird, muss die Gram-Schmidt 
            Orthogonalisierung (fuer eine Teilmenge der Basisvektoren) 
            wiederholt werden koennen und somit innerhalb der Schleife 
            berechnet werden 
        *)

        (* b_i: i. Basisvektor *)
        bi = basecopy[[i]];
        (* o_i: i. orthogonalisierter Basisvektor *)
        oi = bi;

        (* 
            innere Schleife fuer die Subtraktion der 1,...,j < i 
            orthogonalisierten Basisvektoren 
        *)
        For[j = 1, j < i, j = j + 1,
            (* o_j: j. Gram-Schmidt orthogonalisierter Basisvektor *)
            oj = gsbase[[j]];
            (* Berechnung des Gram-Schmidt Koeffizienten my_i,j *)
            myij = (bi . oj)/(oj . oj);
            (* Teilerzeugung vom i. Gram-Schmidt Basisvektor *)
            oi = oi - (myij*oj);
        ]; (* End For *)
    
        (* 
            i. Gram-Schmidt orthogonalisierten Basisvektor zu der Gram-
            Schmidt Basis hinzufuegen (nur im ersten Durchlauf moeglich)
            oder austauschen 
        *)
        gsbase = If[Length[gsbase] < i, Append[gsbase, oi], 
                      ReplacePart[gsbase, i -> oi]];
    
        (* Laengenreduktion der Basis basecopy *)
    
        (* b_i: i. Basisvektor *)
        bi = basecopy[[i]];
    
        (* innere Schleife um den i. Basisvektor zu laengenreduzieren *)
        For[j = i - 1, j >= 1, j = j - 1,
            (* b_j: j. Basisvektor *)
            bj = basecopy[[j]];
            (* o_j: j. Gram-Schmidt orthogonalisierter Basisvektor *)
            oj = gsbase[[j]];
            (* Berechnung des Gram-Schmidt Koeffizienten my_i,j *)
            myij = (bi . oj)/(oj . oj);
            (* i. Basisvektor laengenreduzieren *)
            bi = bi - (Round[myij]*bj);
        ]; (* End For *)
    
        (*
            i. laengenreduzierten Basisvektor in der Basis basecopy 
            austauschen 
        *)
        basecopy = ReplacePart[basecopy, i -> bi];
    
        (*
            bis hierhin ist fuer die Basisvektoren b_1,...,b_i die 
            Laengenreduziertheit sichergestellt. Jetzt muss noch die 
            Lovasz-Eigenschaft ueberprueft werden 
        *)
    
        (* Ueberpruefung der Lovasz-Eigenschaft *)
    
        (* b_i: i. Basisvektor *)
        bi = basecopy[[i]];
        (* b_i-1: i-1. Basisvektor *)
        bi1 = basecopy[[i - 1]];
        (* o_i: i. orthogonalisierter Basisvektor *)
        oi = gsbase[[i]];
        (* o_i-1: i-1. orthogonalisierter Basisvektor *)
        oi1 = gsbase[[i - 1]];
        (* 
            my_i,i-1: Gram-Schmidt Koeffizient vom i. Basisvektor 
            und dem i-1. Gram-Schmidt orthogonalisierten Basisvektor 
        *)
        myii1 = (bi . oi1)/(oi1 . oi1);
    
        (* Lovasz-Eigenschaft erfuellt? *)
        If[Norm[oi + myii1*oi1]^2 >= (3/4)*Norm[oi1]^2,
            (* Then *)
            i = i + 1,
            (* Else *)
            (* vertausche Basisvektor b_i mit b_i-1 *)
            basecopy = ReplacePart[basecopy, (i - 1) -> bi];
            basecopy = ReplacePart[basecopy, i -> bi1];

            (* 
                wenn wir den ersten Basisvektor vertauschen, muss auch 
                der erste Vektor in der Gram-Schmidt Basis ausgetauscht 
                werden 
            *)
            If[(i - 1) == 1, gsbase = ReplacePart[gsbase, 1 -> bi]];
            (* 
                nun muessen im naechsten Schleifendurchlauf u.a. das 
                Gram-Schmidt Orthogonalisierungsverfahren, die 
                Laengenreduktion und die Ueberpruefung der 
                Lovasz-Eigenschaft fuer i >= max(i-1,2) wiederholt 
                werden 
            *)
            i = Max[i - 1, 2];
        ]; (* End If *) 
        
    ];(* End While *)
    
    (* RUECKGABEWERT *)
    basecopy
    
]; (* End Module *)



baseA =
{
	{100,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
	{101,  50,  10,   0,   0,   0,   0,   0,   0,   0,   0},
	{ 50,  10,  20,  30,   0,   0,   0,   0,   0,   0,   0},
	{ 10,  20,  10,  10, 100,   0,   0,   0,   0,   0,   0},
	{200,  10,   5,   1,  90,  99,   0,   0,   0,   0,   0},
	{  1,   2,   3,   4,   5,   6,   7,   0,   0,   0,   0},
	{100,  99,  98,  97,  96,  95,  94,  93,   0,   0,   0},
	{  1,   2,   3,   4,   5,   6,   7,   8,   9,   0,   0},
	{  1,   2,   3,   4,   5,   6,   7,   8,   9,  10,   0},
	{100,   1,  99,   2,  98,   3,  97,   4,  96,   5,  95},
	{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}
};



LLL[baseA] == LatticeReduce[baseA]