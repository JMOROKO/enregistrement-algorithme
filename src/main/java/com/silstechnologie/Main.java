package com.silstechnologie;

import java.util.Scanner;
import com.silstechnologie.GestionEtudiant.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        Etudiant[] etudiants = new Etudiant[10];
        boolean verifierSaisie = false;
        int cpt = 0;
        int rep;
        do{
            // Affichage du menu
            System.out.println("============ MENU ============");
            System.out.println("1- Saisir un étudiant");
            System.out.println("2- rechercher un étudiant");
            System.out.println("3- Quitter le programme");
            rep = sc.nextInt();

            switch (rep){
                case 1:
                    if(cpt <= 9){
                        verifierSaisie = true;
                        System.out.println("Entrez le matricule de l'étudiant : ");
                        int matricule = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Veuillez saisir l'identifiant de l'étudiant : ");
                        String identite = sc.nextLine();
                        etudiants[cpt] = new Etudiant(matricule, identite);
                        //System.out.println(etudiants[cpt].mat);
                        cpt++;
                        System.out.println("L'étudiant a été ajouté avec succès !");
                    }else{
                        System.out.println("***************************************************");
                        System.out.println("La liste des étudiant est plein.");
                        System.out.println("***************************************************");
                    }
                    break;
                case 2:
                    if(verifierSaisie){
                        System.out.println("Entrez le matricule recherché : ");
                        int matRecherche = sc.nextInt();
                        sc.nextLine();
                        boolean trouve = false;

                        for(int i = 0; i <= cpt; i++){
                            if(etudiants[i].mat == matRecherche){
                                System.out.println("--------------------------------");
                                System.out.println("Etudiant trouvé");
                                System.out.println("Matricule : "+ etudiants[i].mat);
                                System.out.println("Identifiant : "+ etudiants[i].identite);
                                System.out.println("--------------------------------");
                                trouve = true;
                                break;
                            }
                        }

                        if( !trouve ){
                            System.out.println("Aucun étudiant trouvé");
                        }
                    }
                    else{
                        System.out.println("----------------------------------------");
                        System.out.println("Aucun étudiant n'a été saisi.");
                        System.out.println("----------------------------------------");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Mauvaise saisie, veuillez réessayer !");
            }
        }
        while(rep != 3);
        sc.close();
    }
}