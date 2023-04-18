/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listaligadasimplesbase;

/**
 *
 * @author yasmi
 */
public class ListaLigadaCircular {

    /**
     * @param args the command line arguments
     */            
    static No inicio = null;
    static No fim = null;

    public static void main(String[] args) {
        // TODO code application logic here
        inserir(4);
        inserir(5);
        remover(4);
       
        exibir();

    }

    public static void inserir(int n) {
        No novo = new No(n);

        if (inicio == null) {
            inicio = fim = novo;

        } else {
            fim.proximo = novo;
            fim = fim.proximo;
        }
        fim.proximo = inicio;
    }

    public static void exibir() {
        if (inicio == null) {
            System.out.println("lista vazia");
        } else {
            System.out.println(inicio.valor);
            No temp = inicio.proximo;

            while (temp != inicio) {
                System.out.println(temp.valor);
                temp = temp.proximo;
            }

        }
    }

    public static void remover(int n) { //precisa verificar se o no esta no inicio ou não
        if (inicio == null) {
            System.out.println("Lista vazia");
        } 
        else {
            if (inicio.valor == n) {//significa que o primeiro é igual a n
                if (inicio.proximo == null) {//significa que só tem apenas 1 No na lista
                    inicio = fim = null;
                } else {
                    inicio = inicio.proximo;
                    fim.proximo = inicio;
                }
            } 
            else {//significa que o primeiro é diferente de N, vai conferir os proximos
                No temp = inicio;

                while ((temp.proximo != inicio) && (temp.proximo.valor != n))//confere um por ate chegar no incio novamente
                    temp = temp.proximo;
                if (temp.proximo == inicio) //quando da a volta significa que nao encontrou nada
                    System.out.println("Numero nao encontrado");
                 
                else {
                    if (temp.proximo == fim) //singinfica que chegou no ultimo da lista e encontrou o n na ultima posiçao
                        fim = temp;// remove o ultimo e deixa o penultimo(temp)
                   
                    temp.proximo = temp.proximo.proximo;//se o x nao fo nem o primeiro e nem o ultimo cai nessa condição,de matar o no.

                }

            }

        }
    }

}
