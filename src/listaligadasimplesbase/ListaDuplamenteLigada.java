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

    public static void main(String[] args) {
        // TODO code application logic here
        inserirOrdenado(24);
        inserirOrdenado(4);
        inserirOrdenado(100);
        remover(100);
        removerUltimo();
        removerPrimeiro();
        inserirOrdenado(24);
        inserirOrdenado(4);
        inserirOrdenado(100);

        exibir();

    }

    public static void inserir(int x) {
        No novo = new No(x);

        if (inicio == null) {
            novo.proximo = novo;
            novo.anterior = novo;
            inicio = novo;
        } else {
            novo.proximo = inicio;
            novo.anterior = inicio.anterior;
            inicio.anterior.proximo = novo;
            inicio.anterior = novo;
        }

    }

    public static void inserirOrdenado(int x) {
        No novo = new No(x);

        if (inicio == null) {
            novo.proximo = novo;
            novo.anterior = novo;
            inicio = novo;
        } else {
            //verificar se o valor deve ser encaixado nas extremindades da lista 
            if ((novo.valor <= inicio.valor) || (novo.valor > inicio.anterior.valor)) {
                novo.proximo = inicio;
                novo.anterior = inicio.anterior;
                inicio.anterior.proximo = novo;
                inicio.anterior = novo;
                if (novo.valor > inicio.anterior.valor) {
                    inicio = novo;
                }
            } //verificar se o velor deve ser encaixado no meio da lista
            else {
                No temp = inicio.proximo;

                while ((novo.valor > temp.valor) && (temp != inicio)) {
                    temp = temp.proximo;
                }
                if (temp != inicio) {
                    novo.proximo = temp;
                    novo.anterior = temp.anterior;
                    temp.anterior.proximo = novo;
                    temp.anterior = novo;

                }
            }
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

            System.out.println(temp.valor);

        }

    }

    public static void remover(int x) {
        No temp = inicio;

        while ((temp.valor != x) && (temp.proximo != inicio)) {
            temp = temp.proximo;
        }
        //depois de encontrar o valor de x
        if (temp.valor == x) {
            //verificar se a lista é feita de apenas 1 elemento
            if (temp == temp.proximo) {
                inicio = null;
            } //se  alista tiver varios elementos, fazer a remoção do x
            else {
                temp.anterior.proximo = temp.proximo;
                temp.proximo.anterior = temp.anterior;
                //verificar se a lista chegou ao fim e fazer a modificação dos ponteiros
                if (temp == inicio) {
                    inicio = temp.proximo;
                }
            }
        } else {
            System.out.println("Valor nao encontrado");
        }

    }

    public static void removerPrimeiro() {
        if (inicio == null) {
            System.out.println("Lista Vazia");
        } else { //verifica se a lista tem apenas 1 elemento
            if (inicio == inicio.proximo) {
                inicio = null;
            } else {
                inicio.anterior.proximo = inicio.proximo;
                inicio.proximo.anterior = inicio.anterior;
                //ajustar o ponterio inicio
                inicio = inicio.proximo;

            }

        }

    }

    public static void removerUltimo() {
        if(inicio == null){
            System.out.println("Lista vazia");
        }
        else{
            if(inicio == inicio.proximo){
                inicio = null;
            }
            else{
                inicio.anterior.anterior.proximo = inicio;
                inicio.anterior = inicio.anterior.anterior;
            }
        }

    }

}
