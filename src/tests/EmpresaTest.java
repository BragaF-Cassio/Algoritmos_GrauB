package tests;
import Trabalho.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class EmpresaTest {
    private Empresa empresa;
    //antes de cada teste, o método 'setup' é executado para inicializar a instância da empresa
    //se desejado, pode ser criada outra instancia nos métodos dos testes com alguma finalidade, se nao, sera usado o padrão do before
    @Before
    public void setup(){
        empresa = new Empresa("Amazon");
    }

    //testes do método addProdutoEstoque
    @Test
    public void testAddProdutoEstoqueSeNaoExisteNoEstoque(){
        //aqui, vamos testar o método addProdutoEstoque
        //em um cenário onde deve adicionar o produto no estoque se o mesmo ainda não existirProduto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        empresa.addProdutoEstoque(mouse, 3, true);
        String resultadoEsperado = "[{Nome='Mouse gamer', Valor=49.99, Descrição='Mouse para jogos', Ano De Lancamento=2020, Marca='Corsair', Cor='Cinza', Categoria='Gamer', Quantidade=3}]";
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        Assert.assertEquals(resultadoEsperado, resultado.toString());
    }

    @Test
    public void testAddProdutoSeJaExisteNoEstoque(){
        //aqui, vamos testar o método addProdutoEstoque em um cenário onde adiciona mais quantidades, se o produto já existe no estoque
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        empresa.addProdutoEstoque(mouse, 3, true);
        empresa.addProdutoEstoque(mouse, 1, true);
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        String resultadoEsperado = "[{Nome='Mouse gamer', Valor=49.99, Descrição='Mouse para jogos', Ano De Lancamento=2020, Marca='Corsair', Cor='Cinza', Categoria='Gamer', Quantidade=4}]";
        Assert.assertEquals(resultadoEsperado, resultado.toString());
    }

    @Test
    public void testNaoAddProdutoCasoNaoExista(){
        //aqui, vamos testar o método addProdutoEstoque em um cenário onde
        //a flag de adicionarAoEstoqueCasoNaoExista está em false
        //resultado esperado é que o estoque esteja vazio
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        empresa.addProdutoEstoque(mouse, 1, false);
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        String resultadoEsperado = null;
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    //testes do método removerProdutoEstoque

    @Test
    public void testRemoverProdutoEstoque(){
        //aqui, vamos testar o método removerProdutoEstoque, em um cenário padrão de funcionamento
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        empresa.addProdutoEstoque(carregadorIphone, 4, true);
        empresa.removerProdutoEstoque(carregadorIphone, 1);
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        String resultadoEsperado = "[{Nome='Carregador de Iphone', Valor=89.99, Descrição='Carregador homologado Apple', Ano De Lancamento=2022, Marca='Apple', Cor='Branco', Categoria='Carregador', Quantidade=3}]";
        Assert.assertEquals(resultadoEsperado, resultado.toString());
    }

    @Test
    public void testNaoDeveRemoverProdutoEstoqueSeNaoExiste(){
        //aqui, vamos testar o método removerProdutoEstoque, em um cenário onde o método
        //identifica que o produto não existe no estoque, logo não remove
        //estoque continua vazio
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        empresa.removerProdutoEstoque(carregadorIphone, 1);
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        String resultadoEsperado = null;
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testRemoverProdutoEstoqueSeQuantidadeMaiorQueDoEstoque(){
        //testando no caso do usuário tentar retirar uma quantidade de um produto maior do que a quantidade existente já no estoque
        //nesse caso, deve zerar o estoque
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        empresa.addProdutoEstoque(carregadorIphone, 2, true);
        empresa.removerProdutoEstoque(carregadorIphone, 3);
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        String resultadoEsperado = null;
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    //testes do método addProdutoCarrinho
    @Test
    public void testAddProdutoCarrinho(){
        //aqui, vamos testar o método addProdutoCarrinho, em um cenário padrão de funcionamento
        //o produto existe no estoque, e devemos adicioná-lo no carrinho normalmente
        Produto livro = new Livros("Código limpo: Habilidades práticas do Agile", "Código limpo: Habilidades práticas do Agile", 89.99, 3, 4444, "Robert C. Martin", "Alta Books", "Educação", "Livro Físico - Capa Dura" );
        empresa.addProdutoEstoque(livro, 5, true);
        empresa.addProdutoCarrinho(livro, 3);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "[Item{produto={Nome='Código limpo: Habilidades práticas do Agile', Valor=89.99, Autor: Robert C. Martin, Editora= Alta Books, Gênero= Educação, Formato= Livro Físico - Capa Dura, Descricao='Código limpo: Habilidades práticas do Agile', Quantidade=5}, quantidade=3}]";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testAddProdutoCarrinhoQueNaoTemNoEstoque() {
        //aqui, vamos testar o método addProdutoCarrinho, em um cenário onde o produto a ser
        //adicionado ao carrinho não existe no estoque
        //carrinho continua vazio
        Produto livro = new Livros("Código limpo: Habilidades práticas do Agile", "Código limpo: Habilidades práticas do Agile", 89.99, 3, 4444, "Robert C. Martin", "Alta Books", "Educação", "Livro Físico - Capa Dura" );
        empresa.addProdutoCarrinho(livro, 2);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "Vazio";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testAddProdutoCarrinhoQuantidadeMaiorQueNoEstoque(){
        //aqui, vamos testar o método addProdutoCarrinho, em um cenário onde o usuário tenta adicionar uma quantidade do
        //produto ao carrinho maior do que a quantidade existente no estoque, assim, o carrinho continua vazio
        //é informado ao usuário que a quantidade no estoque é insuficiente
        Produto livro = new Livros("Código limpo: Habilidades práticas do Agile", "Código limpo: Habilidades práticas do Agile", 89.99, 3, 4444, "Robert C. Martin", "Alta Books", "Educação", "Livro Físico - Capa Dura" );
        empresa.addProdutoEstoque(livro, 1, true);
        empresa.addProdutoCarrinho(livro, 3);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "Vazio";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testAddProdutoCarrinhoQuandoProdutoJaEstaNoCarrinho(){
        //aqui, vamos testar o método addProdutoCarrinho, em um cenário onde o usuário tenta adicionar um produto que já se encontra no carrinho
        //assim, o carrinho mantem-se no seu estado anterior, porque nesse caso, tentaria adicionar 6 do produto e tem apenas 5 no estoque
        Produto livro = new Livros("Código limpo: Habilidades práticas do Agile", "Código limpo: Habilidades práticas do Agile", 89.99, 3, 4444, "Robert C. Martin", "Alta Books", "Educação", "Livro Físico - Capa Dura" );
        empresa.addProdutoEstoque(livro, 5, true);
        empresa.addProdutoCarrinho(livro, 3);
        empresa.addProdutoCarrinho(livro, 3);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "[Item{produto={Nome='Código limpo: Habilidades práticas do Agile', Valor=89.99, Autor: Robert C. Martin, Editora= Alta Books, Gênero= Educação, Formato= Livro Físico - Capa Dura, Descricao='Código limpo: Habilidades práticas do Agile', Quantidade=5}, quantidade=3}]";
        Assert.assertEquals(resultadoEsperado, resultado.toString());
    }

    //testes do método removeProdutoCarrinho

    @Test
    public void testRemoveProdutoCarrinho(){
        //aqui, vamos testar o método removeProdutoCarrinho, em um cenário padrão de funcionamento
        //o produto existe no carrinho e vamos retirá-lo por completo, todas as unidades, assim, carrinho fica zerado
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 99.99, 1, 999, "M", "Algodão");
        empresa.addProdutoEstoque(camisetaPolo, 5, true);
        empresa.addProdutoCarrinho(camisetaPolo, 3);
        empresa.removeProdutoCarrinho(camisetaPolo, 3);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "Vazio";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testRemoveProdutoCarrinhoDeixandoAlgumasQuantidades(){
        //aqui, vamos testar o método removeProdutoCarrinho em um cenário onde o usuário remove apenas algumas unidades do produto
        //do carrinho, atualizando a quantidade do produto no carrinho
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 99.99, 1, 999, "M", "Algodão");
        empresa.addProdutoEstoque(camisetaPolo, 5, true);
        empresa.addProdutoCarrinho(camisetaPolo, 3);
        empresa.removeProdutoCarrinho(camisetaPolo, 1);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "[Item{produto={Nome='Camiseta Polo', Valor=99.99, Tamanho='M', Tecido='Algodão', Descricao='Camiseta Polo Listrada', Marca='Polo', Cor='Cinza e preto', Categoria='Camisetas', Quantidade=5, Codigo=999}, quantidade=2}]";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testRemoveProdutoCarrinhoQuantidadeMaiorQueDoCarrinho(){
        //aqui, vamos testar o método removeProdutoCarrinho, em um cenário onde o usuário tenta
        //remover uma quantidade do produto maior do que a existente no carrinho
        //nesse caso, é zerado o produto no carrinho
        //testando se caso o usuário solicite remover uma quantidade maior do que a do carrinho, o produto é removido do carrinho, todas as quantidades
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 99.99, 1, 999, "M", "Algodão");
        empresa.addProdutoEstoque(camisetaPolo, 5, true);
        empresa.addProdutoCarrinho(camisetaPolo, 3);
        empresa.removeProdutoCarrinho(camisetaPolo, 6);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "Vazio";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testRemoveProdutoCarrinhoSeProdutoNaoExisteNoCarrinho(){
        //aqui, vamos testar o método removeProdutoCarrinho, em um cenário onde o usuário tenta remover
        //um produto que não está no carrinho, assim, carrinho segue vazio
        //testando se caso o usuário solicite remover uma quantidade maior do que a do carrinho, o produto é removido do carrinho, todas as quantidades
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 99.99, 1, 999, "M", "Algodão");
        empresa.addProdutoEstoque(camisetaPolo, 5, true);
        empresa.removeProdutoCarrinho(camisetaPolo, 2);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "Vazio";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    //testes do método checkoutCarrinho
    @Test
    public void testCheckOutCarrinho(){
        //aqui, vamos testar o método checkOutCarrinho, em um cenário de funcionamento padrão
        //usuário adicionou alguns produtos ao carrinho e o checkout entra o valor gasto na compra
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 100, 1, 999, "M", "Algodão");
        empresa.addProdutoEstoque(camisetaPolo, 5, true);
        empresa.addProdutoCarrinho(camisetaPolo, 2);
        Produto geladeira = new Eletrodomestico("Geladeira", "Geladeira Moderna", "Brastemp", "Preta", "Eletrodomestico", 1800, 3, "56kWh/mes", 29283);
        empresa.addProdutoEstoque(geladeira, 5);
        empresa.addProdutoCarrinho(geladeira, 1);
        double resultadoEsperado = 2000;
        double resultado = empresa.checkoutCarrinho();
        Assert.assertEquals(resultadoEsperado, resultado, 0);
    }

    @Test
    public void testCheckOutCarrinhoDeveSerZeroSeNenhumItemNoCarrinho(){
        //teste quando o carrinho estiver vazio, o valor gasto deve ser zero
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 100, 1, 999, "M", "Algodão");
        empresa.addProdutoCarrinho(camisetaPolo, 2);
        Produto geladeira = new Eletrodomestico("Geladeira", "Geladeira Moderna", "Brastemp", "Preta", "Eletrodomestico", 1800, 3, "56kWh/mes", 29283);
        empresa.addProdutoCarrinho(geladeira, 1);
        double resultadoEsperado = 0;
        double resultado = empresa.checkoutCarrinho();
        Assert.assertEquals(resultadoEsperado, resultado, 0);
    }

    //testes do construtor da classe empresa
    @Test
    public void testConstrutor(){
        //testando o construtor da classe
        String resultadoEsperado = "Amazon";
        Assert.assertEquals(resultadoEsperado, empresa.getNomeEmpresa());
    }

    @Test
    public void testConstrutorIsString(){
        //testando se é do tipo String o argumento da classe empresa
        Assert.assertEquals(true, empresa.getNomeEmpresa() instanceof String);
    }

    //testes do método getNomeEmpresa e setNomeEmpresa
    @Test
    public void testGetNomeEmpresa(){
        Assert.assertEquals("Amazon", empresa.getNomeEmpresa());
        Assert.assertEquals(true, empresa.getNomeEmpresa() instanceof String);
    }

    @Test
    public void testSetNomeEmpresa(){
        Empresa mercadoLivre = new Empresa(null);
        mercadoLivre.setNomeEmpresa("Mercado Livre");
        Assert.assertEquals("Mercado Livre", mercadoLivre.getNomeEmpresa());
        Assert.assertEquals(true, mercadoLivre.getNomeEmpresa() instanceof String);
    }

    //testes do método toString

    @Test
    public void testToString() {
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 100, 1, 999, "M", "Algodão");
        Produto geladeira = new Eletrodomestico("Geladeira", "Geladeira Moderna", "Brastemp", "Preta", "Eletrodomestico", 1800, 3, "56kWh/mes", 29283);
        empresa.addProdutoEstoque(camisetaPolo, 5);
        empresa.addProdutoEstoque(geladeira, 4);
        empresa.addProdutoCarrinho(camisetaPolo, 3);
        empresa.addProdutoCarrinho(geladeira, 1);
        String resultado = empresa.toString();
        String resultadoEsperado = "Empresa{" +
                "nomeEmpresa='" + empresa.getNomeEmpresa() + '\'' +
                ", carrinho=" + empresa.visualizarCarrinho() +
                ", estoque=" + empresa.visualizarEstoque() +
                '}';
        Assert.assertEquals(resultado, resultadoEsperado);
    }

    @Test
    public void testToStringQuandoEstoqueECarrinhoVazio(){
        String resultado = empresa.toString();
        String resultadoEsperado = "Empresa{" +
                "nomeEmpresa='" + empresa.getNomeEmpresa() + '\'' +
                ", carrinho=[]" +
                ", estoque=[]" +
                '}';
        Assert.assertEquals(resultado, resultadoEsperado);
    }

    //testes do método visualizarCarrinho
    @Test
    public void testVisualizarCarrinho(){
        //aqui, vamos testar o método visualizarCarrinho, em um cenário padrão de funcionamento
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 100, 1, 999, "M", "Algodão");
        Produto geladeira = new Eletrodomestico("Geladeira", "Geladeira Moderna", "Brastemp", "Preta", "Eletrodomestico", 1800, 3, "56kWh/mes", 29283);
        empresa.addProdutoEstoque(camisetaPolo, 5);
        empresa.addProdutoEstoque(geladeira, 4);
        empresa.addProdutoCarrinho(camisetaPolo, 3);
        empresa.addProdutoCarrinho(geladeira, 1);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "[Item{produto={Nome='Camiseta Polo', Valor=100.0, Tamanho='M', Tecido='Algodão', Descricao='Camiseta Polo Listrada', Marca='Polo', Cor='Cinza e preto', Categoria='Camisetas', Quantidade=5, Codigo=999}, quantidade=3}, Item{produto={Nome='Geladeira', Valor=1800.0, Descrição='Geladeira Moderna', Eficiência Energética=56kWh/mes, Marca='Brastemp', Cor='Preta', Categoria='Eletrodomestico', Quantidade=4, Código=29283}, quantidade=1}]";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testVisualizarCarrinhoQuandoCarrinhoVazio(){
        //aqui, vamos testar o método visualizarCarrinho, em um cenário onde o carrinho encontra-se vazio
        //esperamos o resultado "Vazio".
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 100, 1, 999, "M", "Algodão");
        empresa.addProdutoEstoque(camisetaPolo, 10);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "Vazio";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    //testes do método listarItensCarrinho
    @Test
    public void testListarItensCarrinho(){
        //aqui, vamos testar o método listarItensCarrinho, onde adicionamos alguns produtos ao carrinho da empresa
        //e verificamos se a listagem de itens está correta, cenário padrão de funcionamento
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 100, 1, 999, "M", "Algodão");
        Produto geladeira = new Eletrodomestico("Geladeira", "Geladeira Moderna", "Brastemp", "Preta", "Eletrodomestico", 1800, 3, "56kWh/mes", 29283);
        empresa.addProdutoEstoque(camisetaPolo, 10);
        empresa.addProdutoEstoque(geladeira, 5);
        empresa.addProdutoCarrinho(camisetaPolo, 4);
        empresa.addProdutoCarrinho(geladeira, 2);
        List<Item> itensCarrinho = empresa.listarItensCarrinho();
        Assert.assertEquals(2, itensCarrinho.size()); //testando se o tamanho é igual ao esperado
        Assert.assertEquals(camisetaPolo, itensCarrinho.get(0).getProduto()); //testando se corresponde ao item
        Assert.assertEquals(4,itensCarrinho.get(0).getQuantidade()); //testando se a quantidade está correta conforme o esperado
        Assert.assertEquals(geladeira, itensCarrinho.get(1).getProduto());
        Assert.assertEquals(2, itensCarrinho.get(1).getQuantidade());
    }

    @Test
    public void testListarItensCarrinhoQuandoVazio(){
        //aqui, vamos testar o método listarItensCarrinhos quando o mesmo está vazio
        List<Item> itensCarrinho = empresa.listarItensCarrinho();
        Assert.assertNull(itensCarrinho);
    }

    //testando o método listarEletronicosEstoque
    @Test
    public void testListarEletronicosEstoqueComEletronicos(){
        //aqui, vamos testar o método listarEletronicosEstoque, quando há eletronicos no estoque
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        Produto geladeira = new Eletrodomestico("Geladeira", "Geladeira Moderna", "Brastemp", "Preta", "Eletrodomestico", 1800, 3, "56kWh/mes", 29283);
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        empresa.addProdutoEstoque(mouse, 10);
        empresa.addProdutoEstoque(carregadorIphone, 8);
        empresa.addProdutoEstoque(geladeira, 3);
        ArrayList<Produto> eletronicosEstoque = empresa.listarEletronicosEstoque();
        Assert.assertEquals(2, eletronicosEstoque.size());
        Assert.assertEquals(mouse, eletronicosEstoque.get(0));
        Assert.assertEquals(carregadorIphone, eletronicosEstoque.get(1));
    }

    @Test
    public void testListarEletronicosEstoqueSemEletronicosNoEstoque(){
        //aqui, vamos testar o método listarEletronicosEstoque quando não há eletrônicos no estoque
        Produto geladeira = new Eletrodomestico("Geladeira", "Geladeira Moderna", "Brastemp", "Preta", "Eletrodomestico", 1800, 3, "56kWh/mes", 29283);
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 100, 1, 999, "M", "Algodão");
        empresa.addProdutoEstoque(geladeira, 5);
        empresa.addProdutoEstoque(camisetaPolo, 12);
        ArrayList<Produto> eletronicosEstoque = empresa.listarEletronicosEstoque();
        Assert.assertNull(eletronicosEstoque);
    }

    //testes do método listarEletrodomesticosEstoque
    @Test
    public void testListarEletrodomesticosEstoqueComEletrodomesticosNoEstoque(){
        //aqui, vamos testar o método listarEletrodomesticosEstoque, em um cenário onde há eletrodomesticos no estoque
        Produto geladeira = new Eletrodomestico("Geladeira", "Geladeira Moderna", "Brastemp", "Preta", "Eletrodomestico", 1800, 3, "56kWh/mes", 29283);
        Produto forno = new Eletrodomestico("Forno", "Forno elétrico", "Brastemp", "Prata", "Eletrodomestico", 1100, 3, "56kWh/mes", 11929);
        empresa.addProdutoEstoque(geladeira, 6);
        empresa.addProdutoEstoque(forno, 10);
        ArrayList<Produto> eletrodomesticosEstoque = empresa.listarEletrodomesticosEstoque();
        Assert.assertEquals(2, eletrodomesticosEstoque.size());
        Assert.assertEquals(geladeira, eletrodomesticosEstoque.get(0));
        Assert.assertEquals(forno, eletrodomesticosEstoque.get(1));
    }

    @Test
    public void testListarEletrodomesticosEstoqueSemEletrodomesticosNoEstoque(){
        //aqui, vamos testar o método listarEletrodomesticoEstoque, em um cenário onde não há nenhum eletrodoméstico no estoque
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 100, 1, 999, "M", "Algodão");
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        empresa.addProdutoEstoque(camisetaPolo, 20);
        empresa.addProdutoEstoque(mouse, 10);
        empresa.addProdutoEstoque(carregadorIphone, 5);
        ArrayList<Produto> eletrodomesticosEstoque = empresa.listarEletrodomesticosEstoque();
        Assert.assertNull(eletrodomesticosEstoque);
    }

    //testes do método listarLivrosEstoque
    @Test
    public void testlistarLivrosEstoqueComLivrosNoEstoque(){
        //aqui vamos testar o método listarLivrosEstoque, em um cenário onde há livros no estoque
        Produto cleanCode = new Livros("Código limpo: Habilidades práticas do Agile", "Código limpo: Habilidades práticas do Agile", 89.99, 3, 4444, "Robert C. Martin", "Alta Books", "Educação", "Livro Físico - Capa Dura" );
        Produto aVoltaAoMundoEm80Dias = new Livros("A Volta ao Mundo em 80 dias", "O livro é sobre um homem que percorre o mundo em 80 dias", 9.99 , 3, 121323,   "Julio Verne", "Penguin Books", "Aventura", "Livro Fisico");
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        empresa.addProdutoEstoque(cleanCode, 10);
        empresa.addProdutoEstoque(aVoltaAoMundoEm80Dias, 10);
        empresa.addProdutoEstoque(carregadorIphone, 10);
        ArrayList<Produto> livrosEstoque = empresa.listarLivrosEstoque();
        Assert.assertEquals(2, livrosEstoque.size());
        Assert.assertEquals(cleanCode, livrosEstoque.get(0));
        Assert.assertEquals(aVoltaAoMundoEm80Dias, livrosEstoque.get(1));
    }

    @Test
    public void testlistarLivrosEstoqueSemLivrosNoEstoque() {
        //aqui vamos testar o método listarLivrosEstoque, em um cenário onde não há livros no estoque
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 100, 1, 999, "M", "Algodão");
        empresa.addProdutoEstoque(camisetaPolo, 10);
        empresa.addProdutoEstoque(carregadorIphone, 6);
        ArrayList<Produto> livrosEstoque = empresa.listarLivrosEstoque();
        Assert.assertNull(livrosEstoque);
    }

    //testes do método listarRoupasEstoque
    @Test
    public void testListarRoupasEstoqueComRoupasNoEstoque(){
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 100, 1, 999, "M", "Algodão");
        Produto calcaJeans = new Roupas("Calça Jeans", "Calça Jeans escuro", "Renner", "Jeans azul escuro", "Calças", 160, 1, 1001, "P", "Jeans");
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        empresa.addProdutoEstoque(camisetaPolo, 19);
        empresa.addProdutoEstoque(calcaJeans, 12);
        empresa.addProdutoEstoque(carregadorIphone, 12);
        ArrayList<Produto> roupasEstoque = empresa.listarRoupasEstoque();
        Assert.assertEquals(2, roupasEstoque.size());
        Assert.assertEquals(camisetaPolo, roupasEstoque.get(0));
        Assert.assertEquals(calcaJeans, roupasEstoque.get(1));
    }
    @Test
    public void testListarRoupasEstoqueSemRoupasNoEstoque(){
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        Produto aVoltaAoMundoEm80Dias = new Livros("A Volta ao Mundo em 80 dias", "O livro é sobre um homem que percorre o mundo em 80 dias", 9.99 , 3, 121323,   "Julio Verne", "Penguin Books", "Aventura", "Livro Fisico");
        Produto forno = new Eletrodomestico("Forno", "Forno elétrico", "Brastemp", "Prata", "Eletrodomestico", 1100, 3, "56kWh/mes", 11929);
        empresa.addProdutoEstoque(carregadorIphone, 10);
        empresa.addProdutoEstoque(aVoltaAoMundoEm80Dias, 4);
        empresa.addProdutoEstoque(forno, 10);
        ArrayList<Produto> roupasEstoque = empresa.listarRoupasEstoque();
        Assert.assertNull(roupasEstoque);
    }

    //testes do método visualizarEstoque
    @Test
    public void testVisualizarEstoque(){
        Produto aVoltaAoMundoEm80Dias = new Livros("A Volta ao Mundo em 80 dias", "O livro é sobre um homem que percorre o mundo em 80 dias", 9.99 , 3, 121323,   "Julio Verne", "Penguin Books", "Aventura", "Livro Fisico");
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 100, 1, 999, "M", "Algodão");
        Produto geladeira = new Eletrodomestico("Geladeira", "Geladeira Moderna", "Brastemp", "Preta", "Eletrodomestico", 1800, 3, "56kWh/mes", 29283);
        empresa.addProdutoEstoque(camisetaPolo, 5);
        empresa.addProdutoEstoque(geladeira, 4);
        empresa.addProdutoEstoque(aVoltaAoMundoEm80Dias, 12);
        String resultado = String.valueOf(empresa.visualizarEstoque());
        String resultadoEsperado = "[{Nome='Camiseta Polo', Valor=100.0, Tamanho='M', Tecido='Algodão', Descricao='Camiseta Polo Listrada', Marca='Polo', Cor='Cinza e preto', Categoria='Camisetas', Quantidade=5, Codigo=999}, {Nome='Geladeira', Valor=1800.0, Descrição='Geladeira Moderna', Eficiência Energética=56kWh/mes, Marca='Brastemp', Cor='Preta', Categoria='Eletrodomestico', Quantidade=4, Código=29283}, {Nome='A Volta ao Mundo em 80 dias', Valor=9.99, Autor: Julio Verne, Editora= Penguin Books, Gênero= Aventura, Formato= Livro Fisico, Descricao='O livro é sobre um homem que percorre o mundo em 80 dias', Quantidade=12}]";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testVisualizarEstoqueQuandoEstoqueVazio(){
        //aqui, vamos testar o método visualizarCarrinho, em um cenário onde o carrinho encontra-se vazio
        //esperamos o resultado null.
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 100, 1, 999, "M", "Algodão");
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        ArrayList<Produto> resultadoEsperado = null;
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    //testes do método finalizarCompra
    @Test
    public void testFinalizarCompraCarrinhoVazio(){
        //aqui, vamos testar o metodo finalizarCompraCarrinho, quando o mesmo encontra-se vazio
        double valorGasto = empresa.finalizarCompra();
        Assert.assertEquals(0.0, valorGasto, 0.0001);
        Assert.assertTrue(empresa.visualizarCarrinho().equals("Vazio"));
        Assert.assertNull(empresa.listarItensCarrinho());
        Assert.assertNull(empresa.visualizarEstoque());
    }

    @Test
    public void testFinalizarCompraCarrinhoComProdutos(){
        //aqui, vamos testar o método finalizarCompraCarrinho quando existem produtos no carrinho, padrão de funcionamneto
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 60, 1, 999, "M", "Algodão");
        Produto geladeira = new Eletrodomestico("Geladeira", "Geladeira Moderna", "Brastemp", "Preta", "Eletrodomestico", 1800, 3, "56kWh/mes", 29283);
        Produto aVoltaAoMundoEm80Dias = new Livros("A Volta ao Mundo em 80 dias", "O livro é sobre um homem que percorre o mundo em 80 dias", 39.99 , 3, 121323,   "Julio Verne", "Penguin Books", "Aventura", "Livro Fisico");
        empresa.addProdutoEstoque(camisetaPolo, 10);
        empresa.addProdutoEstoque(geladeira, 5);
        empresa.addProdutoEstoque(aVoltaAoMundoEm80Dias, 15);
        empresa.addProdutoCarrinho(camisetaPolo, 2); //120
        empresa.addProdutoCarrinho(geladeira, 1); //1800
        empresa.addProdutoCarrinho(aVoltaAoMundoEm80Dias, 1); //39.99
        double resultadoValorGasto = empresa.finalizarCompra();
        double resultadoEsperado = 120 + 1800 + 39.99;
        Assert.assertEquals(resultadoEsperado, resultadoValorGasto, 0.0001);
        Assert.assertTrue(empresa.visualizarCarrinho().equals("Vazio"));
        Assert.assertNull(empresa.listarItensCarrinho());
    }

    //testes do método retornaProdutoDoEstoqueComCodigo
    @Test
    public void testRetornaProdutoDoEstoqueComCodigoExistente(){
        //aqui, vamos testar o método retornaProdutoDoEstoqueComCodigo, em um cenário onde o código é existente
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 60, 1, 999, "M", "Algodão");
        Produto geladeira = new Eletrodomestico("Geladeira", "Geladeira Moderna", "Brastemp", "Preta", "Eletrodomestico", 1800, 3, "56kWh/mes", 29283);
        empresa.addProdutoCarrinho(camisetaPolo, 4);
        empresa.addProdutoEstoque(geladeira, 2);
        Produto resultadoProdutoEncontrado = empresa.retornaProdutoDoEstoqueComCodigo(29283); //codigo da geladeira
        Produto resultadoEsperado = geladeira;
        Assert.assertEquals(resultadoEsperado, resultadoProdutoEncontrado);
    }

    @Test
    public void testRetornaProdutoDoEstoqueComCodigoInexistente(){
        //aqui, vamos testar o método retornaProdutoEstoqueComCodigo, em um cenário onde o código é inexistente
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 60, 1, 999, "M", "Algodão");
        Produto geladeira = new Eletrodomestico("Geladeira", "Geladeira Moderna", "Brastemp", "Preta", "Eletrodomestico", 1800, 3, "56kWh/mes", 29283);
        empresa.addProdutoCarrinho(camisetaPolo, 4);
        empresa.addProdutoEstoque(geladeira, 2);
        Produto resultadoProdutoEncontrado = empresa.retornaProdutoDoEstoqueComCodigo(111);
        Assert.assertNull(resultadoProdutoEncontrado);
    }
}
