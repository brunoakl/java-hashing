package hashingencadeado;

import static java.lang.String.valueOf;

public class Hash {

    private int TAM = 21;
    private No tabela[] = new No[TAM];

    private int funcaoHashing(String chave) {
        Integer quadrado;
        int tamanho = chave.length();
        int vet[] = new int[tamanho];
        Integer somaChar =0;
        for(int i=0;i<tamanho;i++){
            somaChar += (int) chave.charAt(i);
        }
        quadrado = somaChar*somaChar;
        String stg_quadrado = quadrado.toString();
        System.out.println("Quadrado: " + stg_quadrado);
        int lem = stg_quadrado.length();
        int meio = lem/2;
        Integer sub = Integer.parseInt(stg_quadrado.substring(meio-1, meio+2));
        
        System.out.println("Valor do char: " + somaChar);
        System.out.println("Meio: " + sub);
        return sub % TAM;
    }

    public void inserir(String chave) {
        int posicao = funcaoHashing(chave);
        System.out.println("Posição: " + posicao);
        No novo = new No();
        novo.setChave(chave);

        if (tabela[posicao] == null) {
            System.out.println("Posição Vazia");
            tabela[posicao] = novo;
        } else {
            System.out.println("Posição ja existe chave");
            No no = tabela[posicao];
            while (no.getProx() != null) {
                no = no.getProx();
            }
            no.setProx(novo);
        }
        imprimir();
        System.out.println("Chave Inserida");
    }

    public void imprimir() {
        
        
        String str = "";
        str = "----------TABELA------------\n";
        for (int i = 0; i < TAM; i++) {
            str+="\n";
            str+="Posição " + i + " da Tabela\n";

            if (tabela[i] == null) {
                str+="Posição Vazia";
            } else {
                No no = tabela[i];
                str+= " " + no.getChave();
                while (no.getProx() != null) {
                    no = no.getProx();
                    str+= " -> " + no.getChave();
                }              

            }

        }
        
        Janela.jTextArea1.setText(str);
                

    }

}
