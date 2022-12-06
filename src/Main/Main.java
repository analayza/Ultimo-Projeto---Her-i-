package Main;
import Model.*;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bolsa bolsa = new Bolsa();

        bolsa.put(1, "Maca Dourada (+80 HP)");
        bolsa.put(2, "Porcao de forca (+70 ATK)");

        boolean remover1=false;
        boolean remover2=false;

        System.out.println("=========================");
        System.out.println("BEM VINDO A SUA NOVA AVENTURA");
        System.out.println("=========================");

        Random aleatorio = new Random();
        Heroi h1 = new Heroi(null);
        Vilao v1 = new Vilao("Elon Musk", 1000);
        int opcao = 0;


        while (opcao != 2) {

            System.out.println("1-Cadastrar seu Heroi " +
                    "\n2-Sair");

            while (opcao != 1 && opcao != 2) {
                Scanner t1 = new Scanner(System.in);
                System.out.print("Digite uma opcao =>");


                try {
                    opcao = t1.nextInt();
                    if (opcao != 1 && opcao != 2) {
                        System.out.println("Opcao invalida");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Tipo de variavel invalida");
                }
            }

            if (opcao == 1) {

                System.out.println("Bem vindo a criacao do seu personagem " +
                        "Seu personagem vem por padrao com 100 de vida e 100 no nivel de forca");

                System.out.print("Digite o nome do seu Heroi=> ");
                Scanner n1 = new Scanner(System.in);
                h1.setNome(n1.nextLine());

                int escolhaDeArma = 0;

                while (escolhaDeArma != 1 && escolhaDeArma != 2) {
                    System.out.println("Escolha uma arma para comecar: \n" + "1 - Espada do Twitter\n" +
                            "2 - Escudo Comunista");
                    Scanner t3 = new Scanner(System.in);

                    try {
                        escolhaDeArma = t3.nextInt();
                        if (escolhaDeArma != 1 && escolhaDeArma != 2) {
                            System.out.println("Opcao invalida!");
                            continue;
                        }
                        if (escolhaDeArma == 1) {
                            System.out.println("Voce escolheu a Espada do Twitter");
                            h1 = new Heroi(new Espada());
                            h1.usarFerramenta();

                        } else {
                            System.out.println("Voce escolheu o Escudo Comunista");
                            h1 = new Heroi(new Escudo());
                            h1.usarFerramenta();
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Tipo de variavel invalida");
                    }
                }
            }
            if (opcao == 2) {
                System.out.println("Obrigado e ate logo!");
                break;
            }

            opcao = 0;
            while (opcao != 1 && opcao != 2) {

                System.out.println("1 - Lutar\n2 - Sair");
                System.out.print("=>");
                Scanner t4 = new Scanner(System.in);
                try {
                    opcao = t4.nextInt();
                    if (opcao != 1 && opcao != 2) {
                        System.out.println("Opcao invalida");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Tipo de variavel invalida");
                }
            }

            if (opcao == 1) {
                while (h1.getNivelDeVida() > 0 || v1.getVida() > 0) {

                    opcao = 0;

                    while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4) {
                        System.out.println("Escolha:\n" + "1 - Atacar\n" + "2 - Usar Item\n" + "3 - Trocar de Arma\n"
                                + "4 - Status");
                        Scanner t4 = new Scanner(System.in);
                        try {
                            opcao = t4.nextInt();
                            if (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4) {
                                System.out.println("Digite uma opcao valida");
                                continue;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Tipo de variavel invalida");
                        }
                    }


                    if (opcao == 1) {
                        try {
                            Thread.sleep(2000);
                        } catch (Exception erro) {
                        }
                        System.out.println("Voce atacou o " + v1.getNome());
                        h1.usarFerramenta();
                        v1.setVida((int) (v1.getVida() - h1.getNivelDeForca()));
                        try {
                            Thread.sleep(2000);
                        } catch (Exception erro) {
                        }
                        System.out.println(v1.getNome() + " HP: " + v1.getVida());
                        try {
                            Thread.sleep(2000);
                        } catch (Exception erro) {
                        }
                        System.out.println(v1.getNome() + " atacou voce");
                        int ataqueVilao = aleatorio.nextInt(25, 30);
                        h1.setNivelDeVida(h1.getNivelDeVida() - ataqueVilao);
                        try {
                            Thread.sleep(2000);
                        } catch (Exception erro) {
                        }
                        System.out.println(" SEU HP E: " + h1.getNivelDeVida());
                        if (v1.getVida() <= 0) {
                            try {
                                Thread.sleep(2000);
                            } catch (Exception erro) {
                            }
                            System.out.println("Parabens! Voce venceu e derrotou o monstro do capitalismo");
                            break;
                        } else if (h1.getNivelDeVida() <= 0) {
                            try {
                                Thread.sleep(2000);
                            } catch (Exception erro) {
                            }
                            System.out.println("Que pena! Voce perdeu, o capitalismo ira perdurar\n" +
                                    "ate o nascimento de um novo heroi");
                            break;
                        }
                    } else if (opcao == 2) {
                        int escolhaDeItem = 0;

                        if (bolsa.tamanho() == 0) {
                            System.out.println("Voce nao possui mais itens");
                            continue;
                        }
                        while (escolhaDeItem != 1 && escolhaDeItem != 2) {
                            System.out.println(bolsa);
                            Scanner t5 = new Scanner(System.in);
                            try {
                                escolhaDeItem = t5.nextInt();
                                if (escolhaDeItem != 1 && escolhaDeItem != 2) {
                                    System.out.println("Digite um opcao valida");
                                    continue;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Tipo de variavel invalida");
                            }
                        }
                        if (escolhaDeItem == 1) {
                            if(remover1==true){
                                System.out.println("Voce nao possui esse item");
                                continue;
                            }
                            System.out.println("Voce usou a porcao de vida, +80 de HP");
                            h1.setNivelDeVida(h1.getNivelDeVida() + 80);
                            bolsa.remove(1);
                            remover1=true;
                        }
                        if (escolhaDeItem == 2) {
                            if (remover2== true){
                                System.out.println("Voce nao possui esse item");
                                continue;
                            }
                            System.out.println("Voce aumentou o seu ataque, +70 de ATK");
                            h1.setNivelDeForca(h1.getNivelDeForca() + 70);
                            bolsa.remove(2);
                            remover2=true;

                        }
                    } else if (opcao == 3) {
                            int escolhaDeArma = 0;

                            while (escolhaDeArma != 1 && escolhaDeArma != 2) {
                                System.out.println("Escolha uma arma para comecar: \n" + "1 - Espada do Twitter\n" +
                                        "2 - Escudo Comunista");
                                Scanner t3 = new Scanner(System.in);

                                try {
                                    escolhaDeArma = t3.nextInt();
                                    if (escolhaDeArma != 1 && escolhaDeArma != 2) {
                                        System.out.println("Opcao invalida!");
                                        continue;
                                    }
                                    if (escolhaDeArma == 1) {
                                        System.out.println("Voce escolheu a Espada do Twitter");
                                        h1 = new Heroi(new Espada());
                                        h1.usarFerramenta();

                                    } else {
                                        System.out.println("Voce escolheu o Escudo Comunista");
                                        h1 = new Heroi(new Escudo());
                                        h1.usarFerramenta();
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Tipo de variavel invalida");
                                }
                            }
                        }
                    if (opcao == 4) {
                        System.out.println("Status do Personagem: \n" + "HP: " + h1.getNivelDeVida() +
                                "\nATK: " + h1.getNivelDeForca());
                    }
                    } if (opcao == 2) {
                        System.out.println("Obrigado e ate logo!");
                    }
                }
            }
        }

    }