package tests;
import Trabalho.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class EmpresaTest {
    //testes do método addProdutoEstoque
    @Test
    public void testAddProdutoEstoqueSeNaoExisteNoEstoque(){
        //aqui, vamos testar o método addProdutoEstoque
        //em um cenário onde deve adicionar o produto no estoque se o mesmo ainda não existir
        Empresa empresa = new Empresa("Amazon");
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        empresa.addProdutoEstoque(mouse, 3, true);
        String resultadoEsperado = "[Eletronicos{anoDeLancamento=2020, nome='Mouse gamer', descricao='Mouse para jogos', marca='Corsair', cor='Cinza', categoria='Gamer', valor=49.99, quantidade=3}]";
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testAddProdutoSeJaExisteNoEstoque(){
        //aqui, vamos testar o método addProdutoEstoque em um cenário onde adiciona mais quantidades, se o produto já existe no estoque
        Empresa empresa = new Empresa("Amazon");
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        empresa.addProdutoEstoque(mouse, 3, true);
        empresa.addProdutoEstoque(mouse, 1, true);
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        String resultadoEsperado = "[Eletronicos{anoDeLancamento=2020, nome='Mouse gamer', descricao='Mouse para jogos', marca='Corsair', cor='Cinza', categoria='Gamer', valor=49.99, quantidade=4}]";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testNaoAddProdutoCasoNaoExista(){
        //aqui, vamos testar o método addProdutoEstoque em um cenário onde
        //a flag de adicionarAoEstoqueCasoNaoExista está em false
        //resultado esperado é que o estoque esteja vazio
        Empresa empresa = new Empresa("Amazon");
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        empresa.addProdutoEstoque(mouse, 1, false);
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        String resultadoEsperado = "Vazio";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    //testes do método removerProdutoEstoque

    @Test
    public void testRemoverProdutoEstoque(){
        //aqui, vamos testar o método removerProdutoEstoque, em um cenário padrão de funcionamento
        Empresa empresa = new Empresa("Amazon");
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        empresa.addProdutoEstoque(carregadorIphone, 4, true);
        empresa.removerProdutoEstoque(carregadorIphone, 1);
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        String resultadoEsperado = "[Eletronicos{anoDeLancamento=2022, nome='Carregador de Iphone', descricao='Carregador homologado Apple', marca='Apple', cor='Branco', categoria='Carregador', valor=89.99, quantidade=3}]";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testNaoDeveRemoverProdutoEstoqueSeNaoExiste(){
        //aqui, vamos testar o método removerProdutoEstoque, em um cenário onde o método
        //identifica que o produto não existe no estoque, logo não remove
        //estoque continua vazio
        Empresa empresa = new Empresa("Amazon");
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        empresa.removerProdutoEstoque(carregadorIphone, 1);
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        String resultadoEsperado = "Vazio";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testRemoverProdutoEstoqueSeQuantidadeMaiorQueDoEstoque(){
        //testando no caso do usuário tentar retirar uma quantidade de um produto maior do que a quantidade existente já no estoque
        //nesse caso, deve zerar o estoque
        Empresa empresa = new Empresa("Amazon");
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        empresa.addProdutoEstoque(carregadorIphone, 2, true);
        empresa.removerProdutoEstoque(carregadorIphone, 3);
        ArrayList<Produto> resultado = empresa.visualizarEstoque();
        String resultadoEsperado = "Vazio";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    //testes do método addProdutoCarrinho
    @Test
    public void testAddProdutoCarrinho(){
        //aqui, vamos testar o método addProdutoCarrinho, em um cenário padrão de funcionamento
        //o produto existe no estoque, e devemos adicioná-lo no carrinho normalmente
        Empresa empresa = new Empresa("Amazon");
        Produto livro = new Livros("Código limpo: Habilidades práticas do Agile", "Código limpo: Habilidades práticas do Agile", 89.99, 3, 4444, "Robert C. Martin", "Alta Books", "Educação", "Livro Físico - Capa Dura" );
        empresa.addProdutoEstoque(livro, 5, true);
        empresa.addProdutoCarrinho(livro, 3);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "[Item{produto=Livros{Autor: Robert C. Martineditora= Alta Booksgenero= Educaçãoformato= Livro Físico - Capa Dura, nome='Código limpo: Habilidades práticas do Agile', descricao='Código limpo: Habilidades práticas do Agile', valor=89.99, quantidade=5}, quantidade=3}]";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testAddProdutoCarrinhoQueNaoTemNoEstoque() {
        //aqui, vamos testar o método addProdutoCarrinho, em um cenário onde o produto a ser
        //adicionado ao carrinho não existe no estoque
        //carrinho continua vazio
        Empresa empresa = new Empresa("Amazon");
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
        Empresa empresa = new Empresa("Amazon");
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
        Empresa empresa = new Empresa("Amazon");
        Produto livro = new Livros("Código limpo: Habilidades práticas do Agile", "Código limpo: Habilidades práticas do Agile", 89.99, 3, 4444, "Robert C. Martin", "Alta Books", "Educação", "Livro Físico - Capa Dura" );
        empresa.addProdutoEstoque(livro, 5, true);
        empresa.addProdutoCarrinho(livro, 3);
        empresa.addProdutoCarrinho(livro, 3);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "[Item{produto=Livros{Autor: Robert C. Martineditora= Alta Booksgenero= Educaçãoformato= Livro Físico - Capa Dura, nome='Código limpo: Habilidades práticas do Agile', descricao='Código limpo: Habilidades práticas do Agile', valor=89.99, quantidade=5}, quantidade=3}]";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    //testes do método removeProdutoCarrinho

    @Test
    public void testRemoveProdutoCarrinho(){
        //aqui, vamos testar o método removeProdutoCarrinho, em um cenário padrão de funcionamento
        //o produto existe no carrinho e vamos retirá-lo por completo, todas as unidades, assim, carrinho fica zerado
        Empresa empresa = new Empresa("Amazon");
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
        Empresa empresa = new Empresa("Amazon");
        Produto camisetaPolo = new Roupas("Camiseta Polo", "Camiseta Polo Listrada", "Polo", "Cinza e preto", "Camisetas", 99.99, 1, 999, "M", "Algodão");
        empresa.addProdutoEstoque(camisetaPolo, 5, true);
        empresa.addProdutoCarrinho(camisetaPolo, 3);
        empresa.removeProdutoCarrinho(camisetaPolo, 1);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "[Item{produto=Roupas{tamanho='M', tecido='Algodão', nome='Camiseta Polo', descricao='Camiseta Polo Listrada', marca='Polo', cor='Cinza e preto', categoria='Camisetas', valor=99.99, quantidade=5, codigo=999}, quantidade=2}]";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testRemoveProdutoCarrinhoQuantidadeMaiorQueDoCarrinho(){
        //aqui, vamos testar o método removeProdutoCarrinho, em um cenário onde o usuário tenta
        //remover uma quantidade do produto maior do que a existente no carrinho
        //nesse caso, é zerado o produto no carrinho
        //testando se caso o usuário solicite remover uma quantidade maior do que a do carrinho, o produto é removido do carrinho, todas as quantidades
        Empresa empresa = new Empresa("Amazon");
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
        Empresa empresa = new Empresa("Amazon");
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
        Empresa empresa = new Empresa("Amazon");
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
        Empresa empresa = new Empresa("Amazon");
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
        Empresa amazon = new Empresa("Amazon");
        String resultadoEsperado = "Amazon";
        Assert.assertEquals(resultadoEsperado, amazon.getNomeEmpresa());
    }

    @Test
    public void testConstrutorIsString(){
        //testando se é do tipo String o argumento da classe empresa
        Empresa mercadoLivre = new Empresa("Mercado Livre");
        Assert.assertEquals(true, mercadoLivre.getNomeEmpresa() instanceof String);
    }

    //testes do método getNomeEmpresa e setNomeEmpresa
    @Test
    public void testGetNomeEmpresa(){
        Empresa amazon = new Empresa("Amazon");
        Assert.assertEquals("Amazon", amazon.getNomeEmpresa());
        Assert.assertEquals(true, amazon.getNomeEmpresa() instanceof String);
    }

    @Test
    public void testSetNomeEmpresa(){
        Empresa mercadoLivre = new Empresa(null);
        mercadoLivre.setNomeEmpresa("Mercado Livre");
        Assert.assertEquals("Mercado Livre", mercadoLivre.getNomeEmpresa());
        Assert.assertEquals(true, mercadoLivre.getNomeEmpresa() instanceof String);
    }
}
    
    //Testando toString

    //falta teste do toString, do visualizarCarrinho, que teoricamente ja foi testado mas ne
    //dp listarItensCarrinho, visualziarEstoque, listarEletronicosEstoque, listarEletromedistcosEstoque, livros, roupas, visualizarEstoque, finalziarcompra, retornarprodutocomcodigo
