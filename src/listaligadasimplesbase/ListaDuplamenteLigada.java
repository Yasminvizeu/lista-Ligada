/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listaligadasimplesbase;

/**
 *
 * @author yasmi
 */
public class ListaDuplamenteLigada {

    /**
     * @param args the command line arguments
     */
    static No inicio = null;
    static No fim = null;

    public static void main(String[] args) {
        // TODO code application logic here
        inserir(5);
        remover(5);

        exibir();

    }

    public static void inserir(int x) {
        No novo = new No(x);

        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }

    }

    public static void inserirOrdenado(int x) {
        No novo = new No(x);

        if (inicio == null) {
            inicio = fim = novo;

        }

        No temp = inicio;

        while ((temp != null) && (temp.valor < x)) {
            temp = temp.proximo;
        }

        if (temp == inicio) {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        } else if (temp == null) {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        } else {
            novo.proximo = temp;
            novo.anterior = temp.proximo;
            temp.anterior.proximo = novo;
            temp.anterior = novo;
        }

    }

    public static void exibir() {
        if (inicio == null) {
            System.out.println("Lista vazia");
        } else {
            No temp = inicio;

            do {
                System.out.println(temp.valor);
                temp = temp.proximo;
            } while (temp != inicio);

        }

    }

    public void exibirInverso() {
        if (inicio == null) {
            System.out.println("Lista vazia");
        } else {
            No temp = inicio.anterior;

            do {
                System.out.println(temp.valor);
                temp = temp.anterior;
            } while (temp != inicio);

        }

    }

    public static void remover(int x) {
        if (inicio == null) {
            System.out.println("Lista vazia");
        } else {
            No temp = inicio;

            while ((temp.proximo != null) && (temp.valor != x)) {
                temp = temp.proximo;
            }

            if (temp.valor == x) {

                if (temp == temp.proximo) { //verifica se o numero  foi encontrado e for uma lista circular de apenas um elemento
                    inicio = null;  // remove-se o inicio
                } else {
                    temp.anterior.proximo = temp.proximo;
                    temp.proximo.anterior = temp.anterior;

                    if (temp == inicio) {
                        inicio = temp.proximo;

                    }
                }
            } else {// se o numero x nao foi encontrado na lista 
                System.out.println("Numero nao encontrado");

            }

        }

    }

}
