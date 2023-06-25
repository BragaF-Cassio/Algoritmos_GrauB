package Trabalho;


//import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
//import org.apache.commons.lang.SerializationUtils;
public class Empresa {
    private String nomeEmpresa;
    private List<Item> carrinho = new ArrayList<>();
    private List<Produto> estoque = new ArrayList<>();

    public Empresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nomeEmpresa='" + nomeEmpresa + '\'' +
                ", carrinho=" + carrinho +
                ", estoque=" + estoque +
                '}';
    }

    /*public void addProdutoEstoque(Produto produto, int quantidade){
        for (int i=0; i<quantidade; i++){
            estoque.add(produto);
        }
        System.out.println("Novo item adicionado ao estoque:");
        System.out.println(estoque);
        System.out.println();
    }*/

    public boolean addProdutoEstoque(Produto produto, int quantidade) {
        return addProdutoEstoque(produto, quantidade, true);
    }

    public boolean addProdutoEstoque(Produto produto, int quantidade, boolean adicionarAoEstoqueCasoNaoExista) {
        //Procura no estoque o produto do parâmetro
        for (Produto p: estoque) {
            //Se achou o produto, modifica o estoque e sai da função
            if(p.getCodigo() == produto.getCodigo()){
            	JOptionPane.showMessageDialog(null, "Adicionando estoque de item já cadastrado...", "Espera",
                  		JOptionPane.INFORMATION_MESSAGE);
                p.adicionaQuantidade(quantidade);
                JOptionPane.showMessageDialog(null, p, "Cadastro",
                  		JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }

        //Se não encontrou o produto no estoque, e a flag de adição está habilitada, adiciona ao estoque
        if(adicionarAoEstoqueCasoNaoExista){
        	JOptionPane.showMessageDialog(null, "Novo produto cadastrado ao estoque!", "Cadastro",
              		JOptionPane.INFORMATION_MESSAGE);
            produto.setQuantidade(quantidade);
            System.out.println(produto);
            estoque.add(produto);
            return true;
        } else {
        	JOptionPane.showMessageDialog(null, "Não foi possível adicionar o item " + produto.toString() + "\nItem não está cadastrado ao estoque.", "Erro",
              		JOptionPane.ERROR_MESSAGE);
            System.out.println();
            System.out.println();
            return false;
        }
    }

    /*public void removerProdutoEstoque(Produto produto, int quantidade) {
        int count = 0; // Contador para verificar o número de ocorrências do produto no estoque

        // Verifica a quantidade de ocorrências do produto no estoque
        for (Produto p : estoque) {
            if (p.equals(produto)) {
                count++;
            }
        }
        // Verifica se a quantidade no estoque é maior ou igual à quantidade desejada
        if (count >= quantidade) {
            for (int i = 0; i < quantidade; i++) {
                estoque.remove(produto);
            }
            System.out.println(estoque);
        } else {
            //da pra tipo, se o cara tentar tirar mais produtos do que tem ali no carrinho, so pegar e zerar aquele produto no estoque dele, ou exibir alguma msg, isso é detalhe, a gente pensa
            System.out.println("Tem apenas " + count + " " + produto.getNome() + " no estoque.");
        }
    }*/

    public int removerProdutoEstoque(Produto produto, int quantidade) {
        // Encontra produto no estoque e remove caso
        for (Produto p : estoque) {
            if (p.equals(produto)) {
                if(p.getQuantidade() > quantidade){
                    p.removeQuantidade(quantidade);
                    return 0;
                } else {
                    estoque.remove(p);
                    return 1;
                }
            }
        }

        return -1;
    }

    //Função que adiciona a quantidade de produtos ao carrinho, se houver a quantidade no estoque
    //Retorna true se adicionou com sucesso, senão retorna false
    public boolean addProdutoCarrinho(Produto produto, int quantidade) {
        int count = 0; // Contador para verificar o número de ocorrências do produto no estoque

        // Verifica a quantidade de ocorrências do produto no estoque
        for (Produto p : estoque) {
            if (p.equals(produto)) {
                if (p.getQuantidade() >= quantidade){

                    //Checa se o item já não está no carrinho, se estiver, adiciona mais itens
                    boolean estaNoCarrinho = false;
                    for (Item it: carrinho) {
                        if(it.getProduto().equals(produto)){
                            estaNoCarrinho = true;
                            if (it.getQuantidade() + quantidade <= produto.getQuantidade()){
                                it.adicionaQuantidade(quantidade);
                                break;
                            } else {
                            	JOptionPane.showMessageDialog(null, "Quantidade insuficiente no estoque! Item já está no carrinho!", "Erro",
                                  		JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        }
                    }

                    if (estaNoCarrinho == false) {
                        carrinho.add(new Item(p, quantidade));
                    }

                    //Mostra informações do carrinho após adicionar ao estoque carrinho
                    visualizarCarrinho();
                    return true;
                } else {
                	JOptionPane.showMessageDialog(null, "Quantidade insuficiente no estoque!", "Erro",
                      		JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            }
        }
        return false;
    }


    /*public void removerProdutoCarrinho(Produto produto, int quantidade){
        int count = 0; // Contador para verificar o número de ocorrências do produto no carrinho (para nao ser possivel ter 2 mouses no carrinho e querer tirar 3

        // Verifica a quantidade de ocorrências do produto no carrinho
        for (Item it : carrinho) {
            if (it.getProduto().equals(produto)) {
                count++;
            }
        }
        // Verifica se a quantidade no estoque é maior ou igual à quantidade desejada
        if (count >= quantidade) {
            for (int i = 0; i < quantidade; i++) {
                carrinho.remove(produto);
            }
            System.out.println(carrinho);
        } else {
            //da pra tipo, se o cara tentar tirar mais produtos do que tem ali no carrinho, so pegar e zerar aquele produto no carrinho dele, ou exibir alguma msg, isso é detalhe, a gente pensa
            System.out.println("Tem apenas " + count + " " + produto.getNome() + " no seu carrinho.");
        }
    }*/

    public int removeProdutoCarrinho(Produto produto, int quantidade){
        // Encontra produto no estoque e remove caso
        for (Item p : carrinho) {
            if (p.getProduto().equals(produto)) {
                if(p.getQuantidade() > quantidade){
                    p.removeQuantidade(quantidade);
                    return 0;
                } else {
                	JOptionPane.showMessageDialog(null, "Item removido do carrinho!", "Sucesso",
                      		JOptionPane.INFORMATION_MESSAGE);
                    carrinho.remove(p);
                    return 1;
                }
            }
        }

        return -1;
    }

    public String visualizarCarrinho(){
    	Eletronicos.contList = 0;
    	Eletrodomestico.contList = 0;
    	Roupas.contList = 0;
    	Livros.contList = 0;
        if(!carrinho.isEmpty()) {
           // System.out.println("Carrinho do cliente:");
            //System.out.println(carrinho);
            for (Item p: carrinho){
               // System.out.println(p.toString());
            }
            System.out.println();
           
            return carrinho.toString();
        } else {
           // System.out.println("Carrinho vazio!");
            System.out.println();
            return "Vazio";
        }
    }

    public ArrayList<Produto> listarItensCarrinho(){
        ArrayList<Produto> tmpCarrinho = new ArrayList<>();
        int quantItems = 0;
        Eletronicos.contList = 0;
    	Eletrodomestico.contList = 0;
    	Roupas.contList = 0;
    	Livros.contList = 0;

        for (Item p: carrinho){
            tmpCarrinho.add(p.getProduto());
            quantItems++;
           // System.out.println(quantItems + ") " + tmpCarrinho.get(tmpCarrinho.size()-1).toString());
        }

        if (quantItems > 0){
            return tmpCarrinho;
        } else {
            return null;
        }
    }

    public ArrayList<Produto> listarEletronicosEstoque(){
        ArrayList<Produto> tmpEstoque = new ArrayList<>();
        int quantItems = 0;
        Eletronicos.contList = 0; // Zerar a listagem, caso for anteriormente usada o toString de Eletronicos.

        for (Produto p: estoque){
            if(p instanceof Eletronicos){
                tmpEstoque.add(p);
                quantItems++;
              //  System.out.println(quantItems + ") " + tmpEstoque.get(tmpEstoque.size()-1).toString());
                
            }
        }

        if (quantItems > 0){
            return tmpEstoque;
        } else {
            return null;
        }
    }

    public ArrayList<Produto> listarEletrodomesticosEstoque(){
        ArrayList<Produto> tmpEstoque = new ArrayList<>();
        int quantItems = 0;
        Eletrodomestico.contList = 0; // Zerar a listagem, caso for anteriormente usada o toString de Eletrodomestico.

        for (Produto p: estoque){
            if(p instanceof Eletrodomestico){
                tmpEstoque.add(p);
                quantItems++;
                //System.out.println(quantItems + ") " + tmpEstoque.get(tmpEstoque.size()-1).toString());
            }
        }

        if (quantItems > 0){
            return tmpEstoque;
        } else {
            return null;
        }
    }

    public ArrayList<Produto> listarLivrosEstoque(){
        ArrayList<Produto> tmpEstoque = new ArrayList<>();
        int quantItems = 0;
        Livros.contList = 0; // Zerar a listagem, caso for anteriormente usada o toString de Livros.

        for (Produto p: estoque){
            if(p instanceof Livros){
                tmpEstoque.add(p);
                quantItems++;
               // System.out.println(quantItems + ") " + tmpEstoque.get(tmpEstoque.size()-1).toString());
            }
        }

        if (quantItems > 0){
            return tmpEstoque;
        } else {
            return null;
        }
    }

    public ArrayList<Produto> listarRoupasEstoque(){
        ArrayList<Produto> tmpEstoque = new ArrayList<>();
        int quantItems = 0;
        Roupas.contList = 0; // Zerar a listagem, caso for anteriormente usada o toString de Roupas.

        for (Produto p: estoque){
            if(p instanceof Roupas){
                tmpEstoque.add(p);
                quantItems++;
               // System.out.println(quantItems + ") " + tmpEstoque.get(tmpEstoque.size()-1).toString());
            }
        }

        if (quantItems > 0){
            return tmpEstoque;
        } else {
            return null;
        }
    }

    public String visualizarEstoque(){
        if (!estoque.isEmpty()) {
            System.out.println("Estoque da loja:");
            //System.out.println(estoque);
            for (Produto p: estoque){
                System.out.println(p.toString());
            }
            System.out.println();
            return estoque.toString();
        } else {
            System.out.println("Estoque vazio!");
            System.out.println();
            return "Vazio";
        }
    }

    public double checkoutCarrinho(){
        double valorGasto = 0;

        for (Item it: carrinho){
            if(it.getProduto().getQuantidade() >= it.getQuantidade()){
                it.getProduto().removeQuantidade(it.getQuantidade());
                valorGasto += it.getProduto().getValor()*it.getQuantidade();
            }
        }

        System.out.println("Checkout realizado!");
        System.out.println("Valor gasto na compra: " + String.format("R$%.2f", valorGasto));
        System.out.println();
        carrinho.clear();
        return valorGasto;
    }

    public double finalizarCompra(){
        double valorGasto;

        valorGasto = checkoutCarrinho();
        visualizarCarrinho();
        visualizarEstoque();
        return valorGasto;
    }

    public Produto retornaProdutoDoEstoqueComCodigo(long codigo) {
        for (Produto p: estoque) {
            if (p.getCodigo() == codigo){
                return p;
            }
        }

       return null;
    };

}
