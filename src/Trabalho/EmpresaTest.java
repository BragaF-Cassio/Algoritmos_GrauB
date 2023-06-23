import Trabalho.*;
import org.junit.Assert;
import org.junit.Test;

public class EmpresaTest {
    //testes do método addProdutoEstoque
    @Test
    public void testAddProdutoEstoqueSeNaoExisteNoEstoque(){
        Empresa empresa = new Empresa("Amazon");
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        empresa.addProdutoEstoque(mouse, 3, true);
        String resultadoEsperado = "[Eletronicos{anoDeLancamento=2020, nome='Mouse gamer', descricao='Mouse para jogos', marca='Corsair', cor='Cinza', categoria='Gamer', valor=49.99, quantidade=3}]";
        String resultado = empresa.visualizarEstoque();
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testAddProdutoSeJaExisteNoEstoque(){
        Empresa empresa = new Empresa("Amazon");
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        empresa.addProdutoEstoque(mouse, 3, true);
        empresa.addProdutoEstoque(mouse, 1, true);
        String resultado = empresa.visualizarEstoque();
        String resultadoEsperado = "[Eletronicos{anoDeLancamento=2020, nome='Mouse gamer', descricao='Mouse para jogos', marca='Corsair', cor='Cinza', categoria='Gamer', valor=49.99, quantidade=4}]";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testNaoAddProdutoCasoNaoExista(){
        Empresa empresa = new Empresa("Amazon");
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        empresa.addProdutoEstoque(mouse, 1, false);
        String resultado = empresa.visualizarEstoque();
        String resultadoEsperado = "Vazio";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    //testes do método removerProdutoEstoque

    @Test
    public void testRemoverProdutoEstoque(){
        Empresa empresa = new Empresa("Amazon");
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        empresa.addProdutoEstoque(carregadorIphone, 4, true);
        empresa.removerProdutoEstoque(carregadorIphone, 1);
        String resultado = empresa.visualizarEstoque();
        String resultadoEsperado = "[Eletronicos{anoDeLancamento=2022, nome='Carregador de Iphone', descricao='Carregador homologado Apple', marca='Apple', cor='Branco', categoria='Carregador', valor=89.99, quantidade=3}]";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testNaoDeveRemoverProdutoEstoqueSeNaoExiste(){
        Empresa empresa = new Empresa("Amazon");
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        empresa.removerProdutoEstoque(carregadorIphone, 1);
        String resultado = empresa.visualizarEstoque();
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
        String resultado = empresa.visualizarEstoque();
        String resultadoEsperado = "Vazio";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    //testes do método addProdutoCarrinho
    @Test
    public void testAddProdutoCarrinho(){
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
        Empresa empresa = new Empresa("Amazon");
        Produto livro = new Livros("Código limpo: Habilidades práticas do Agile", "Código limpo: Habilidades práticas do Agile", 89.99, 3, 4444, "Robert C. Martin", "Alta Books", "Educação", "Livro Físico - Capa Dura" );
        empresa.addProdutoCarrinho(livro, 2);
        String resultado = empresa.visualizarCarrinho();
        String resultadoEsperado = "Vazio";
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testAddProdutoCarrinhoQuantidadeMaiorQueNoEstoque(){
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

    //falta fazer alguns testes ainda, mas logo mais termino


}
