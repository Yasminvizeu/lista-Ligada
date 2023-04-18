/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listaligadasimplesbase;

/**
 *
 * @author yasmi
 */
public class ListaLigadasimplesbase {

    /**
     * @param args the command line arguments
     */
    static No inicio = null;
    static No fim = null;

    public static void main(String[] args) {
        // TODO code application logic here
        insereInicio(1);
        insereInicio(2);
        insereInicio(3);
        insereFim(5);
        insereInicio(6);
        removeInicio();
        removeFim();
        exibeInverso();

        //exibe();
    }

    private static void insereInicio(int x) {
        No novo = new No(x);

        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio = novo;
        }

    }

    private static void insereFim(int i) {
        No novo = new No(i);

        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }

    }

    private static void removeInicio() {
        if (inicio == null) {
            System.out.println("Lista Vazia, nada a remover");
        } else if (inicio.proximo == null) {
            inicio = fim = null;
        } else {
            inicio = inicio.proximo;
        }

    }

    private static void removeFim() {
        if (inicio == null) {
            System.out.println("Lista Vazia, nada a remover");
        } else if (inicio.proximo == null) {
            inicio = fim = null;
        } else {
            No temp = inicio;

            while (temp.proximo != fim) {
                temp = temp.proximo;
            }

            fim = temp;
            temp.proximo = null;
        }
    }

    private static void exibe() {
        if (inicio == null) {
            System.out.println("Lista Vazia, nada a exibir");
        } else {
            No temp = inicio;
            while (temp != null) {
                System.out.println(temp.valor);
                temp = temp.proximo;
            }
        }
    }
    
    private static void exiveInverso(){
        exibeInversoRecursivo(inicio);
    }

    private static void exibeInversoRecursivo(No no) {
        if (no == null) {
            return;
        } else {
            exibeInversoRecursivo(no.proximo);
            System.out.println(no.valor);
        }

    }
}
