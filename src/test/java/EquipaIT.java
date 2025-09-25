

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pitstopmanager.speedpitmanager.Categoria;
import com.pitstopmanager.speedpitmanager.entidades.Pessoa;
import com.pitstopmanager.speedpitmanager.entidades.Veiculo;
import com.pitstopmanager.speedpitmanager.logica.Equipa;

/**
 *
 * @author anafi
 */
public class EquipaIT {

    public EquipaIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAdicionarMembro() {
        System.out.println("adicionarMembro");
        Pessoa p = null;
        Equipa instance = null;
        // Simulação: instance = new Equipa(...);
        // instance.adicionarMembro(p);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdicionarVeiculo() {
        System.out.println("adicionarVeiculo");
        Veiculo veiculo = null;
        Equipa instance = null;
        // instance.adicionarVeiculo(veiculo);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegistarResultado() {
        System.out.println("registarResultado");
        String competicao = "";
        int posicao = 0;
        Equipa instance = null;
        // instance.registarResultado(competicao, posicao);
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarMembros() {
        System.out.println("listarMembros");
        Equipa instance = null;
        // instance.listarMembros();
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarResultados() {
        System.out.println("listarResultados");
        Equipa instance = null;
        // instance.listarResultados();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Equipa instance = null;
        String expResult = "";
        String result = ""; // instance.getNome();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        Equipa instance = null;
        Categoria expResult = null;
        Categoria result = null; // instance.getCategoria();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCategoriaFormatada() {
        System.out.println("getCategoriaFormatada");
        Equipa instance = null;
        String expResult = "";
        String result = ""; // instance.getCategoriaFormatada();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMembros() {
        System.out.println("getMembros");
        Equipa instance = null;
        List<Pessoa> expResult = null;
        List<Pessoa> result = null; // instance.getMembros();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetVeiculos() {
        System.out.println("getVeiculos");
        Equipa instance = null;
        List<Veiculo> expResult = null;
        List<Veiculo> result = null; // instance.getVeiculos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAtribuirVeiculoAoPiloto() {
        System.out.println("atribuirVeiculoAoPiloto");
        String nomePiloto = "";
        String nomeVeiculo = "";
        Equipa instance = null;
        boolean expResult = false;
        boolean result = false; // instance.atribuirVeiculoAoPiloto(nomePiloto, nomeVeiculo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
