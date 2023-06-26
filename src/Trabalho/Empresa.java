package Trabalho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Empresa implements Serializable {
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

    public boolean addProdutoEstoque(Produto produto, int quantidade) {
        return addProdutoEstoque(produto, quantidade, true);
    }

    public boolean addProdutoEstoque(Produto produto, int quantidade, boolean adicionarAoEstoqueCasoNaoExista) {
        //Procura no estoque o produto do parâmetro
        for (Produto p: estoque) {
            //Se achou o produto, modifica o estoque e sai da função
            if(p.getCodigo() == produto.getCodigo()){
                System.out.println("Adicionando estoque de item já cadastrado...");
                p.adicionaQuantidade(quantidade);
                System.out.println(p);
                return true;
            }
        }

        //Se não encontrou o produto no estoque, e a flag de adição está habilitada, adiciona ao estoque
        if(adicionarAoEstoqueCasoNaoExista){
            System.out.println("Novo produto cadastrado ao estoque!");
            produto.setQuantidade(quantidade);
            System.out.println(produto);
            estoque.add(produto);
            return true;
        } else {
            System.out.println("Não foi possível adicionar o item " + produto.toString());
            System.out.println("Item não está cadastrado ao estoque.");
            System.out.println();
            return false;
        }
    }

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
                                System.out.println("Quantidade insuficiente no estoque! Item já está no carrinho.");
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
                    System.out.println("Quantidade insuficiente no estoque!");
                    return false;
                }

            }
        }
        return false;
    }

    public int removeProdutoCarrinho(Produto produto, int quantidade){
        // Encontra produto no estoque e remove caso
        for (Item p : carrinho) {
            if (p.getProduto().equals(produto)) {
                if(p.getQuantidade() > quantidade){
                    p.removeQuantidade(quantidade);
                    return 0;
                } else {
                    System.out.println("Item removido do carrinho!");
                    carrinho.remove(p);
                    return 1;
                }
            }
        }

        return -1;
    }

    public String visualizarCarrinho(){
        if(!carrinho.isEmpty()) {
            System.out.println("Carrinho do cliente:");
            //System.out.println(carrinho);
            int quant = 1;
            String tmpRet = "";
            if (carrinho != null) {
            	for (Item p : carrinho) {
                    tmpRet += String.format("%d) ", quant) + p.toString() + "\n";
                    quant++;
                }
            }	
            
            
            
            return tmpRet;
        } else {
            System.out.println("Carrinho vazio!");
            System.out.println();
            return "Vazio";
        }
    }

    public ArrayList<Produto> listarItensCarrinho(boolean asProduct){
        ArrayList<Produto> tmpCarrinho = new ArrayList<>();
        int quantItems = 0;

        for (Item p: carrinho){
            tmpCarrinho.add(p.getProduto());
            quantItems++;
            System.out.println(quantItems + ") " + tmpCarrinho.get(tmpCarrinho.size()-1).toString());
        }

        if (quantItems > 0){
            return tmpCarrinho;
        } else {
            return null;
        }
    }

    public List<Item> listarItensCarrinho(){
        if (!carrinho.isEmpty()) {
            return carrinho;
        } else {
            return null;
        }
    }

    public ArrayList<Produto> listarEletronicosEstoque(){
        ArrayList<Produto> tmpEstoque = new ArrayList<>();
        int quantItems = 0;

        for (Produto p: estoque){
            if(p instanceof Eletronicos){
                tmpEstoque.add(p);
                quantItems++;
                System.out.println(quantItems + ") " + tmpEstoque.get(tmpEstoque.size()-1).toString());
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

        for (Produto p: estoque){
            if(p instanceof Eletrodomestico){
                tmpEstoque.add(p);
                quantItems++;
                System.out.println(quantItems + ") " + tmpEstoque.get(tmpEstoque.size()-1).toString());
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

        for (Produto p: estoque){
            if(p instanceof Livros){
                tmpEstoque.add(p);
                quantItems++;
                System.out.println(quantItems + ") " + tmpEstoque.get(tmpEstoque.size()-1).toString());
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

        for (Produto p: estoque){
            if(p instanceof Roupas){
                tmpEstoque.add(p);
                quantItems++;
                System.out.println(quantItems + ") " + tmpEstoque.get(tmpEstoque.size()-1).toString());
            }
        }

        if (quantItems > 0){
            return tmpEstoque;
        } else {
            return null;
        }
    }

    public ArrayList<Produto> visualizarEstoque(){
        ArrayList<Produto> tmpEstoque = new ArrayList<>();

        if (!estoque.isEmpty()) {
            System.out.println("Estoque da loja:");
            //System.out.println(estoque);
            for (Produto p: estoque){
                System.out.println(p.toString());
                tmpEstoque.add(p);
            }
            System.out.println();
            return tmpEstoque;
        } else {
            System.out.println("Estoque vazio!");
            System.out.println();
            return null;
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
